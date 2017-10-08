package org.qianrenxi.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.pms.entity.Build;
import org.qianrenxi.pms.entity.BuildRequirementRef;
import org.qianrenxi.pms.entity.BuildRequirementRefPK;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.repository.jpa.BuildRequirementRefJpaRepository;
import org.qianrenxi.pms.repository.jpa.RequirementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class BuildRequirementRefService
		extends BaseService<BuildRequirementRef, BuildRequirementRefPK, BuildRequirementRefJpaRepository> {

	@Autowired
	BuildService buildService;

	@Autowired
	RequirementJpaRepository requirementRepository;

	/**
	 * 构建关联需求
	 * @param buildId
	 * @param requrementIds
	 * @param user
	 */
	public void link(Long buildId, Long[] requrementIds, User user) {
		List<BuildRequirementRef> refs = new ArrayList<>();
		for (Long requirementId : requrementIds) {
			BuildRequirementRef ref = new BuildRequirementRef(buildId, requirementId);
			refs.add(ref);
		}
		
		save(refs);
	}

	/** 
	 * 构建取消关联需求
	 * @param buildId
	 * @param requrementIds
	 * @param user
	 */
	public void unlink(Long buildId, Long[] requrementIds, User user) {
		List<BuildRequirementRef> refs = new ArrayList<>();
		for (Long requirementId : requrementIds) {
			BuildRequirementRef ref = new BuildRequirementRef(buildId, requirementId);
			refs.add(ref);
		}
		
		delete(refs);
	}

	/**
	 * 查询构建已关联的需求
	 * @param buildId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	public Page<Requirement> findLinkedRequirements(Long buildId, Requirement requirement, Pageable pageable) {
		Specifications<Requirement> specifications = Specifications
				.where(RequirementSpecification.getBaseSpecification(requirement))
				.and(BuildReauirementRefSpecification.linkedRequirementSpecification(buildId));

		return requirementRepository.findAll(specifications, pageable);
	}

	/**
	 * 查询构建未关联的需求
	 * 
	 * 构建所属项目所关联的需求且未被构建关联的（逻辑有待改善）
	 * @param buildId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	public Page<Requirement> findNotLinkedRequirements(Long buildId, Requirement requirement, Pageable pageable) {
		Build build = buildService.getOne(buildId);
		if (null == build || null == build.getProject()) {
			// TODO throw exception
			return null;
		}

		if (null == requirement) {
			requirement = new Requirement();
		}

		Long projectId = build.getProject().getId();
		Specifications<Requirement> specifications = Specifications
				.where(RequirementSpecification.getBaseSpecification(requirement))
				.and(ProjectRequirementRefSpecification.linkedRequirementSpecification(projectId))
				.and(BuildReauirementRefSpecification.notLinkedRequirementSpecification(buildId));

		return requirementRepository.findAll(specifications, pageable);
	}
}
