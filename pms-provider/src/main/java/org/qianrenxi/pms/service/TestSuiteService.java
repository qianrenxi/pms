package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.TestSuite;
import org.qianrenxi.pms.repository.jpa.TestSuiteJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class TestSuiteService extends BaseService<TestSuite, Long, TestSuiteJpaRepository> {

	public Page<TestSuite> findByProduct(Long productId, TestSuite testSuite, Pageable pageable) {
		Specifications<TestSuite> specifications = Specifications.where(TestSuiteSpecification.getBaseSpecification(testSuite))
				.and(TestSuiteSpecification.getProductSpecification(productId));
		
		return repository.findAll(specifications, pageable);
	}
}
