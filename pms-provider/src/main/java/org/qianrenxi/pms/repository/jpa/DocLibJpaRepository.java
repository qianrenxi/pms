package org.qianrenxi.pms.repository.jpa;

import java.util.List;

import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.DocLib;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocLibJpaRepository extends SupportRepository<DocLib, Long> {

	@Query("select dl from DocLib dl where dl.product.id = :productId and dl.isDeleted = 0")
	List<DocLib> findByProductId(@Param("productId")Long productId);
	
	@Query("select dl from DocLib dl where dl.project.id = :projectId and dl.isDeleted = 0")
	List<DocLib> findByProjectId(@Param("projectId")Long projectId);
}
