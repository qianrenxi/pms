package org.qianrenxi.pms.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qianrenxi.pms.entity.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

	public static Specification<Task> getBaseSpecification(final Task task) {
		return new Specification<Task>() {

			@Override
			public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("isDeleted"), false);

				if (null == task) {
					return predicate;
				}

				if (null != task.getName()) {
					predicate = cb.and(predicate, cb.like(root.get("name"), "%" + task.getName() + "%"));
				}

				return predicate;
			}
		};
	}
	
	public static Specification<Task> getProjectSpecification(final Long projectId){
		return new Specification<Task>() {

			@Override
			public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return cb.equal(root.get("project").get("id"), projectId);
			}
		};
	} 
}
