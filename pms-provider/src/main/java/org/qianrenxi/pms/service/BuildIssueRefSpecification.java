package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.qianrenxi.pms.entity.BuildIssueRef;
import org.qianrenxi.pms.entity.Issue;
import org.springframework.data.jpa.domain.Specification;

public class BuildIssueRefSpecification {

	public static Subquery<Long> linkedSubquery(Long buildId, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Subquery<Long> subquery = query.subquery(Long.class);
		Root<BuildIssueRef> root = subquery.from(BuildIssueRef.class);
		subquery.select(root.get("issueId"));
		subquery.where(cb.equal(root.get("buildId"), buildId));

		return subquery;
	}

	public static Specification<Issue> linkedIssueSpecification(Long buildId) {
		return new Specification<Issue>() {

			@Override
			public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate predicate = cb.in(root.get("id")).value(linkedSubquery(buildId, query, cb));
				
				return predicate;
			}
		};
	}
	
	public static Specification<Issue> notLinkedIssueSpecification(Long buildId) {
		return new Specification<Issue>() {
			
			@Override
			public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate predicate = cb.not(cb.in(root.get("id")).value(linkedSubquery(buildId, query, cb)));
				
				return predicate;
			}
		};
	}
}
