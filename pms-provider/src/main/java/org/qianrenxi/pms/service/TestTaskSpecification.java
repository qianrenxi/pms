package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.TestSuite;
import org.qianrenxi.pms.entity.TestTask;
import org.springframework.data.jpa.domain.Specification;

public class TestTaskSpecification {

	public static Specification<TestTask> getBaseSpecification(final TestTask testTask) {
		return new Specification<TestTask>() {
			@Override
			public Predicate toPredicate(Root<TestTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);
				
				if(null == testTask) {
					return predicate;
				}
				
				return predicate;
			}
		};
	}
	
	public static Specification<TestTask> getProductSpecification(final Long productId) {
		return new Specification<TestTask>() {
			@Override
			public Predicate toPredicate(Root<TestTask> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != productId) {
					return cb.equal(root.get("product").get("id"), productId);
				}

				return null;
			}
		};
	}
}
