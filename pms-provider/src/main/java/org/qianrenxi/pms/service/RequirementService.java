package org.qianrenxi.pms.service;

import static org.qianrenxi.pms.service.RequirementSpecification.getBaseSpecification;
import static org.qianrenxi.pms.service.RequirementSpecification.getProductSpecification;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.javers.core.Javers;
import org.javers.core.changelog.SimpleTextChangeLog;
import org.javers.core.diff.Change;
import org.javers.core.diff.Diff;
import org.javers.repository.jql.QueryBuilder;
import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.pms.dto.ReviewInfo;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.entity.Requirement.RequirementStage;
import org.qianrenxi.pms.entity.Requirement.RequirementStatus;
import org.qianrenxi.pms.entity.RequirementSpec;
import org.qianrenxi.pms.entity.RequirementSpecPK;
import org.qianrenxi.pms.repository.jpa.RequirementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

@Service
public class RequirementService extends BaseService<Requirement, Long, RequirementJpaRepository> {

	public enum Actions {
		CREATE, UPDATE, DELETE, CHANGE, REVIEW, OPEN, CLOSE, REMARK
	}

	@Autowired
	Javers javers;

	@Autowired
	RequirementSpecService requirementSpecService;

	// 处理创建需求逻辑
	private Requirement processCreate(Requirement requirement, User user) {
		if (null == requirement.getAssignTo()) {
			requirement.setAssignTo(user);
		}

		if (BooleanUtils.isTrue(requirement.getNeedReview())) {
			requirement.setStatus(RequirementStatus.DRAFT);
		} else {
			requirement.setStatus(RequirementStatus.ACTIVE);
		}

		if (null != requirement.getPlan()) {
			requirement.setStage(RequirementStage.PLANNED);
		} else {
			requirement.setStage(RequirementStage.WAIT);
		}

		requirement.setVersion(1);
		requirement = save(requirement);

		RequirementSpec spec = new RequirementSpec(requirement.getId(), 1, requirement.getName(),
				requirement.getDescription(), requirement.getAcceptance());
		requirementSpecService.save(spec);

		return requirement;
	}

	// 处理需求变更逻辑
	private Requirement processChange(Requirement requirementInfo, User user) {
		Long requirementId = requirementInfo.getId();

		Requirement requirement = getOne(requirementId);

		RequirementSpec oldSpec = new RequirementSpec(requirement.getId(), null, requirement.getName(),
				requirement.getDescription(), requirement.getAcceptance());
		RequirementSpec spec = new RequirementSpec(requirementId, null, requirementInfo.getName(),
				requirementInfo.getDescription(), requirementInfo.getAcceptance());

		Diff diff = javers.compare(oldSpec, spec);
		if (!diff.hasChanges()) {
			return requirement;
		}

		oldSpec.setVersion(requirement.getVersion());

		spec.setVersion(oldSpec.getVersion() + 1);
		requirementSpecService.save(spec);

		requirement.setVersion(spec.getVersion());
		requirement.setName(spec.getName());
		requirement.setDescription(spec.getDescription());
		requirement.setAcceptance(spec.getAcceptance());
		requirement.setNeedReview(requirementInfo.getNeedReview());

		if (BooleanUtils.isTrue(requirementInfo.getNeedReview())) {
			requirement.setStatus(RequirementStatus.DRAFT);
			if (null != requirementInfo.getAssignTo()) {
				requirement.setAssignTo(requirementInfo.getAssignTo());
			} else {
				requirement.setAssignTo(user);
			}
		} else {
			requirement.setStatus(RequirementStatus.ACTIVE);
		}

		requirement = save(requirement);

		return requirement;
	}

	/**
	 * 创建需求
	 * 
	 * @param requirement
	 * @param user
	 * @return
	 */
	public Requirement create(Requirement requirement, User user) {
		return processCreate(requirement, user);
	}

	/**
	 * 变更需求
	 * 
	 * @param requirement
	 * @param user
	 * @return
	 */
	public Requirement change(Requirement requirement, User user, String remark) {
		requirement = processChange(requirement, user);

		Map<String, String> commitProperties = ImmutableMap.of("actions", Actions.CHANGE.toString());
		if (remark != null) {
			commitProperties = new HashMap<>(commitProperties);
			commitProperties.put("comment", remark);
		}
		javers.commit(user.getUsername(), requirement, commitProperties);

		return requirement;
	}

	/**
	 * 更新、修改基本信息
	 * @param requirement
	 * @param user
	 * @param remark
	 * @return
	 */
	public Requirement update(Requirement requirement, User user, String remark) {
		requirement = save(requirement);

		if (null != remark) {
			javers.commit(user.getUsername(), requirement,
					ImmutableMap.of("actions", Actions.UPDATE.toString(), "comment", remark));
		}

		return requirement;
	}

	/**
	 * 评审
	 * 
	 * @param id
	 * @param reviewInfo
	 * @param user
	 */
	public void review(Long id, ReviewInfo reviewInfo, User user) {
		Requirement requirement = getOne(id);
		switch (reviewInfo.getReviewedResult()) {
		case PASS: // 通过
			requirement.setStatus(RequirementStatus.ACTIVE);
			requirement.setNeedReview(false);
			requirement.setAssignTo(new User(reviewInfo.getAssignToId()));
			requirement = save(requirement);
			break;
		case REVERT: // 变更回滚
			Requirement prev = new Requirement();
			RequirementSpec prevSpec = requirementSpecService
					.getOne(new RequirementSpecPK(requirement.getId(), requirement.getVersion() - 1));
			prev.setId(id);
			prev.setAssignTo(new User(reviewInfo.getAssignToId()));
			prev.setNeedReview(false);
			prev.setName(prevSpec.getName());
			prev.setDescription(prevSpec.getDescription());
			prev.setAcceptance(prevSpec.getAcceptance());

			requirement = processChange(prev, user);

			break;
		case CLARIFY: // 有待明确
			// TODO: flag reviewed
			requirement.setNeedReview(false);
			requirement = save(requirement);

			break;
		case REJECT: // 拒绝
			requirement.setNeedReview(false);
			requirement.setStatus(RequirementStatus.CLOSED);
			requirement = save(requirement);
			break;
		default:
			break;
		}

		Map<String, String> commitProperties = ImmutableMap.of("actions", Actions.REVIEW.toString(), "result",
				reviewInfo.getReviewedResult().toString());
		if (reviewInfo.getRemark() != null) {
			commitProperties = new HashMap<>(commitProperties);
			commitProperties.put("comment", reviewInfo.getRemark());
		}
		javers.commit(user.getUsername(), requirement, commitProperties);
	}

	/**
	 * 关闭
	 * 
	 * @param id
	 * @param remark
	 */
	public void close(Long id, String reason, String remark, User user) {
		Requirement requirement = getOne(id);
		requirement.setStatus(RequirementStatus.CLOSED);
		requirement.setCloseReason(reason);
		requirement = save(requirement);

		Map<String, String> commitProperties = ImmutableMap.of("actions", Actions.CLOSE.toString(), "reason", reason);
		if (remark != null) {
			commitProperties = new HashMap<>(commitProperties);
			commitProperties.put("comment", remark);
		}
		javers.commit(user.getUsername(), requirement, commitProperties);
	}

	/**
	 * 添加备注、评论
	 * 
	 * @param id
	 * @param remark
	 * @param user
	 */
	public void remark(Long id, String remark, User user) {
		if (null == remark) {
			return;
		}

		Requirement requirement = getOne(id);
		requirement.setLastModifiedBy(user);
		requirement.setLastModifiedDate(new Date());
		save(requirement);

		javers.commit(user.getUsername(), requirement,
				ImmutableMap.of("actions", Actions.REMARK.toString(), "comment", remark));

	}

	/**
	 * 按产品查询需求
	 * 
	 * @param productId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	public Page<Requirement> findByProduct(Long productId, Requirement requirement, Pageable pageable) {
		Specifications<Requirement> specifications = Specifications.where(getProductSpecification(productId))
				.and(getBaseSpecification(requirement));

		return repository.findAll(specifications, pageable);
	}

	/**
	 * 查找同一个产品下上一条需求
	 * 
	 * @param id
	 * @param productId
	 * @return
	 */
	public Requirement findPrev(Long id, Long productId) {
		return repository.findPrev(id, productId);
	}

	/**
	 * 查找同一个产品下下一条需求
	 * 
	 * @param id
	 * @param productId
	 * @return
	 */
	public Requirement findNext(Long id, Long productId) {
		return repository.findNext(id, productId);
	}

	/**
	 * 查找同一条产品下临近的（上一条、下一条）需求
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Requirement> findNear(Long id) {
		Requirement self = findOne(id);
		Requirement prev = findPrev(id, self.getProduct().getId());
		Requirement next = findNext(id, self.getProduct().getId());

		Map<String, Requirement> near = new HashMap<>();
		near.put("prev", prev);
		near.put("next", next);

		return near;
	}
	
	/**
	 * 更新日志
	 * @param id
	 * @return
	 */
	public String changeLog(Long id) {
		List<Change> changes = javers.findChanges(
	            QueryBuilder.byInstanceId(id, Requirement.class).build());
		String changeLog = javers.processChangeList(changes, new SimpleTextChangeLog());
		return changeLog;
	}
}
