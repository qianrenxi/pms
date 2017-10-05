package org.qianrenxi.pms.repository.jpa;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.RequirementSpec;
import org.qianrenxi.pms.entity.RequirementSpecPK;

@JaversSpringDataAuditable
public interface RequirementSpecJpaRepository extends SupportRepository<RequirementSpec, RequirementSpecPK> {

	List<RequirementSpec> findByRequirementIdOrderByVersionDesc(Long requirementId);
}
