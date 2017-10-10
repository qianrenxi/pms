package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.TestCase;
import org.qianrenxi.pms.repository.jpa.TestCaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService extends BaseService<TestCase, Long, TestCaseJpaRepository> {

	/**
	 * 按产品查找用例
	 * @param productId
	 * @param testCase
	 * @param pageable
	 * @return
	 */
	public Page<TestCase> findByProduct(Long productId, TestCase testCase, Pageable pageable) {
		Specifications<TestCase> specifications = Specifications.where(TestCaseSpecification.baseSpecification(testCase))
				.and(TestCaseSpecification.productSpecification(productId));
		
		return repository.findAll(specifications, pageable);
	}
}
