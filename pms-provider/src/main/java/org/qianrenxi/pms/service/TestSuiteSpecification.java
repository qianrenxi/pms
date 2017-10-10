package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.TestSuite;
import org.springframework.data.jpa.domain.Specification;

public class TestSuiteSpecification {

	public static Specification<TestSuite> getBaseSpecification(final TestSuite testSuite) {
		return new Specification<TestSuite>() {
			@Override
			public Predicate toPredicate(Root<TestSuite> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);

				if (null == testSuite) {
					return predicate;
				}

				return predicate;
			}
		};
	}

	public static Specification<TestSuite> getProductSpecification(final Long productId) {
		return new Specification<TestSuite>() {
			@Override
			public Predicate toPredicate(Root<TestSuite> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != productId) {
					return cb.equal(root.get("product").get("id"), productId);
				}

				return null;
			}
		};
	}
}
