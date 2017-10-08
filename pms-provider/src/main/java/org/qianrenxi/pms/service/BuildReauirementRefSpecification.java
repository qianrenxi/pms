package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.qianrenxi.pms.entity.BuildRequirementRef;
import org.qianrenxi.pms.entity.Requirement;
import org.springframework.data.jpa.domain.Specification;

public class BuildReauirementRefSpecification {

	public static Subquery<Long> linkedSubQuery(final Long buildId, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Subquery<Long> subquery = query.subquery(Long.class);
		Root<BuildRequirementRef> root = subquery.from(BuildRequirementRef.class);
		subquery.select(root.get("requirementId"));
		subquery.where(cb.equal(root.get("buildId"), buildId));

		return subquery;
	}

	public static Specification<Requirement> linkedRequirementSpecification(final Long buildId) {
		return new Specification<Requirement>() {

			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.in(root.get("id")).value(linkedSubQuery(buildId, query, cb));
				
				return predicate;
			}
		};
	}
	
	public static Specification<Requirement> notLinkedRequirementSpecification(final Long buildId) {
		return new Specification<Requirement>() {
			
			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.not(cb.in(root.get("id")).value(linkedSubQuery(buildId, query, cb)));
				
				return predicate;
			}
		};
	}
}
