package org.qianrenxi.pms.service;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.Issue;
import org.qianrenxi.pms.repository.jpa.IssueJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class IssueService extends BaseService<Issue, Long, IssueJpaRepository> {

	public Page<Issue> findByProduct(Long productId, Issue issue, Pageable pageable) {
		Specifications<Issue> specifications = Specifications.where(IssueSpecification.getBaseSpecification(issue))
				.and(IssueSpecification.getProductSpecification(productId));
		
		return repository.findAll(specifications, pageable);
	}
}
