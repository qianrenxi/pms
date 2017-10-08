package org.qianrenxi.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.pms.entity.Project;
import org.qianrenxi.pms.entity.ProjectRequirementRef;
import org.qianrenxi.pms.entity.ProjectRequirementRefPK;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.entity.Requirement.RequirementStatus;
import org.qianrenxi.pms.repository.jpa.ProjectJpaRepository;
import org.qianrenxi.pms.repository.jpa.ProjectRequirementRefJpaRepository;
import org.qianrenxi.pms.repository.jpa.RequirementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class ProjectRequirementRefService
		extends BaseService<ProjectRequirementRef, ProjectRequirementRefPK, ProjectRequirementRefJpaRepository> {
	
	@Autowired
	ProjectJpaRepository projectRepository;
	
	@Autowired
	RequirementJpaRepository requirementRepository;
	
	@Autowired
	RequirementService requirementService;
	
	/**
	 * 项目管理需求
	 * @param projectId
	 * @param requirementIds
	 */
	public void link(Long projectId, Long[] requirementIds, User user) {
		List<ProjectRequirementRef> refs = new ArrayList<>();
		for (Long requirementId : requirementIds) {
			ProjectRequirementRef ref = new ProjectRequirementRef(projectId, requirementId);
			refs.add(ref);
			
			requirementService.projection(requirementId, "", user);
		}
		save(refs);
	}
	
	/**
	 * 项目取消关联需求
	 * @param projectId
	 * @param requirementIds
	 */
	public void unlink(Long projectId, Long[] requirementIds, User user) {
		List<ProjectRequirementRef> refs = new ArrayList<>();
		for (Long requirementId : requirementIds) {
			ProjectRequirementRef ref = new ProjectRequirementRef(projectId, requirementId);
			refs.add(ref);
			
			requirementService.disProjection(requirementId, "", user);
		}
		
		delete(refs);
	} 

	/**
	 * 项目已关联的需求
	 * @param projectId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	public Page<Requirement> findLinkedRequirements(Long projectId, Requirement requirement, Pageable pageable) {
		Specifications<Requirement> specifications = Specifications
				.where(RequirementSpecification.getBaseSpecification(requirement))
				.and(ProjectRequirementRefSpecification.linkedRequirementSpecification(projectId));
		
		return requirementRepository.findAll(specifications, pageable);
	}
	
	/**
	 * 项目未关联的需求
	 * 
	 * 项目关联的需求是产品需求的子集，并且只有评审通过的需求才能关联。
	 * 
	 * @param projectId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	public Page<Requirement> findNotLinkedRequirements(Long projectId, Requirement requirement, Pageable pageable) {
		Project project = projectRepository.findOne(projectId);
		if (null == project || null == project.getProduct()) {
			// TODO: throw exception
			return null;
		}
		if (null == requirement) {
			requirement = new Requirement();
		}
		requirement.setStatus(RequirementStatus.ACTIVE);
		
		Long productId = project.getProduct().getId();
		Specifications<Requirement> specifications = Specifications
				.where(RequirementSpecification.getBaseSpecification(requirement))
				.and(RequirementSpecification.getProductSpecification(productId))
				.and(ProjectRequirementRefSpecification.notLinkedRequirementSpecification(projectId));
		
		return requirementRepository.findAll(specifications, pageable);
	} 
}
