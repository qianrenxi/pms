package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.Requirement;
import org.springframework.data.jpa.domain.Specification;

public class RequirementSpecification {

	public static Specification<Requirement> getBaseSpecification(final Requirement requirement) {
		return new Specification<Requirement>() {

			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);

				if (null == requirement) {
					return predicate;
				}

				if (null != requirement.getName()) {
					predicate = cb.and(predicate, cb.like(root.get("name"), "%" + requirement.getName() + "%"));
				}
				
				if (null != requirement.getStatus()) {
					predicate = cb.and(predicate, cb.equal(root.get("status"), requirement.getStatus()));
				}

				return predicate;
			}
		};
	}

	public static Specification<Requirement> getProductSpecification(final Long productId) {
		return new Specification<Requirement>() {

			@Override
			public Predicate toPredicate(Root<Requirement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("product").get("id"), productId);
				return predicate;
			}
		};
	}
}
