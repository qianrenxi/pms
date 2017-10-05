package org.qianrenxi.pms.service;

import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.RequirementSpec;
import org.qianrenxi.pms.entity.RequirementSpecPK;
import org.qianrenxi.pms.repository.jpa.RequirementSpecJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RequirementSpecService extends BaseService<RequirementSpec, RequirementSpecPK, RequirementSpecJpaRepository> {

	public List<RequirementSpec> findByReuirement(Long requirementId) {
		return repository.findByRequirementIdOrderByVersionDesc(requirementId);
	}
}
