package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.qianrenxi.pms.entity.ProjectRequirementRef;
import org.qianrenxi.pms.entity.Requirement;
import org.springframework.data.jpa.domain.Specification;

public class ProjectRequirementRefSpecification {

	public static Subquery<Long> linkedSubQuery(final Long projectId, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Subquery<Long> subquery = query.subquery(Long.class);
		Root<ProjectRequirementRef> root = subquery.from(ProjectRequirementRef.class);
		subquery.select(root.get("requirementId"));
		subquery.where(cb.equal(root.get("projectId"), projectId));

		return subquery;
	}

	public static Specification<Requirement> linkedRequirementSpecification(final Long projectId) {
		return new Specification<Requirement>() {

			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.in(root.get("id")).value(linkedSubQuery(projectId, query, cb));
				
				return predicate;
			}
		};
	}
	
	public static Specification<Requirement> notLinkedRequirementSpecification(final Long projectId) {
		return new Specification<Requirement>() {
			
			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.not(cb.in(root.get("id")).value(linkedSubQuery(projectId, query, cb)));
				
				return predicate;
			}
		};
	}

}
