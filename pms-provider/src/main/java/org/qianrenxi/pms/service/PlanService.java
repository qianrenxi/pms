package org.qianrenxi.pms.service;

import static org.qianrenxi.pms.service.PlanSpecification.getBaseSpecification;
import static org.qianrenxi.pms.service.PlanSpecification.getProductSpecification;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.Plan;
import org.qianrenxi.pms.repository.jpa.PlanJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

@Service
public class PlanService extends BaseService<Plan, Long, PlanJpaRepository> {

	public Page<Plan> findByProduct(Long productId, Plan plan, Pageable pageable) {
		Specifications<Plan> specifications = Specifications.where(getBaseSpecification(plan))
				.and(getProductSpecification(productId));
		
		return repository.findAll(specifications, pageable);
	}
}
