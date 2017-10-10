package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.TestCase;
import org.springframework.data.jpa.domain.Specification;

public class TestCaseSpecification {

	public static Specification<TestCase> baseSpecification(final TestCase testCase){
		return new Specification<TestCase>() {

			@Override
			public Predicate toPredicate(Root<TestCase> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);
				
				if (null == testCase) {
					return predicate;
				}
				
				return predicate;
			}
		};
	}
	
	public static Specification<TestCase> productSpecification(final Long productId) {
		return new Specification<TestCase>() {

			@Override
			public Predicate toPredicate(Root<TestCase> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != productId) {
					return cb.equal(root.get("product").get("id"), productId);
				}
				return null;
			}
		};
	}
}
