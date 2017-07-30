package org.qianrenxi.pms.repository.jpa;

import java.util.List;

import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleJpaRepository extends SupportRepository<Module, Long> {
	
	@Query("select m from Module m where m.product.id = :productId and m.parent.id is null and m.isDeleted = 0")
	List<Module> findRoots(@Param("productId")Long productId);
	
	@Query("select m from Module m where m.parent.id = :parentId and m.isDeleted = 0")
	List<Module> findChildren(@Param("parentId")Long parentId);
}
