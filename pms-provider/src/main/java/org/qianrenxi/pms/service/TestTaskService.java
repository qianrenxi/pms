package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.TestTask;
import org.qianrenxi.pms.repository.jpa.TestTaskJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class TestTaskService extends BaseService<TestTask, Long, TestTaskJpaRepository> {

	public Page<TestTask> findByProduct(Long productId, TestTask testTask, Pageable pageable) {
		Specifications<TestTask> specifications = Specifications.where(TestTaskSpecification.getBaseSpecification(testTask))
				.and(TestTaskSpecification.getProductSpecification(productId));
		
		return repository.findAll(specifications, pageable);
	}
}
