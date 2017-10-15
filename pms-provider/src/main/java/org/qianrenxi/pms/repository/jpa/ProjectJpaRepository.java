package org.qianrenxi.pms.repository.jpa;

import java.util.List;

import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectJpaRepository extends SupportRepository<Project, Long> {

	@Query("select proj from Project proj where proj.product.id = :productId and isDeleted = 0")
	List<Project> findByProductId(@Param("productId")Long productId);
}
