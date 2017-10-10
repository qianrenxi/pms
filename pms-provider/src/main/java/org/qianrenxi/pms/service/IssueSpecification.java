package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.Issue;
import org.springframework.data.jpa.domain.Specification;

public class IssueSpecification {

	public static Specification<Issue> getBaseSpecification(final Issue issue){
		return new Specification<Issue>() {

			@Override
			public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);
				
				if(null == issue) {
					return predicate;
				}
				
				return predicate;
			}
		};
	}
	
	public static Specification<Issue> getProductSpecification(final Long productId) {
		return new Specification<Issue>() {
			@Override
			public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != productId) {
					return cb.equal(root.get("product").get("id"), productId);
				}
				return null;
			}
		};
	}
}
