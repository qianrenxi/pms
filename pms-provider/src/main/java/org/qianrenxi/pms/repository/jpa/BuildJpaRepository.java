package org.qianrenxi.pms.repository.jpa;

import java.util.List;

import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Build;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuildJpaRepository extends SupportRepository<Build, Long> {
	
	@Query("select b from Build b where b.project.id = :projectId and b.isDeleted = 0 order by b.id desc")
	List<Build> findByProjectId(@Param("projectId")Long projectId);
	
	@Query("select b from Build b where b.product.id = :productId and b.isDeleted = 0 order by b.id desc")
	List<Build> findByProductId(@Param("productId")Long productId);
}
