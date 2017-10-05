package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.Plan;
import org.springframework.data.jpa.domain.Specification;

public class PlanSpecification {

	public static Specification<Plan> getBaseSpecification(final Plan plan) {
		return new Specification<Plan>() {

			@Override
			public Predicate toPredicate(Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);

				if (null == plan) {
					return predicate;
				}

				if (null != plan.getName()) {
					predicate = cb.and(predicate, cb.like(root.get("name"), "%" + plan.getName() + "%"));
				}

				return predicate;
			}
		};
	}

	public static Specification<Plan> getProductSpecification(final Long productId) {
		return new Specification<Plan>() {

			@Override
			public Predicate toPredicate(Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("product").get("id"), productId);
				return predicate;
			}
		};
	}
}
