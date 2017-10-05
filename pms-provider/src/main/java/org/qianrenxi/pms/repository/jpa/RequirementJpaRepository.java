package org.qianrenxi.pms.repository.jpa;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Requirement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@JaversSpringDataAuditable
public interface RequirementJpaRepository extends SupportRepository<Requirement, Long> {

	@Query("select req from Requirement req where req.id = ("
			+ " select max(r.id) from Requirement r where r.id < :id and r.isDeleted = 0 and r.product.id = :productId"
			+ ")")
	Requirement findPrev(@Param("id")Long id, @Param("productId")Long productId);

	@Query("select req from Requirement req where req.id = ("
			+ " select min(r.id) from Requirement r where r.id > :id and r.isDeleted = 0 and r.product.id = :productId"
			+ ")")
	Requirement findNext(@Param("id")Long id, @Param("productId")Long productId);
	
}
