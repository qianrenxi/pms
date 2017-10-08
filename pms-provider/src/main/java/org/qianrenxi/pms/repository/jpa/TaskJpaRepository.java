package org.qianrenxi.pms.repository.jpa;

import org.qianrenxi.core.common.repository.SupportRepository;
import org.qianrenxi.pms.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskJpaRepository extends SupportRepository<Task, Long> {

	@Query("select t from Task t where t.id = ("
			+ " select max(r.id) from Task r where r.id < :id and r.isDeleted = 0 and r.project.id = :projectId"
			+ ")")
	Task findPrev(@Param("id")Long id, @Param("projectId")Long projectId);

	@Query("select t from Task t where t.id = ("
			+ " select min(r.id) from Task r where r.id > :id and r.isDeleted = 0 and r.project.id = :projectId"
			+ ")")
	Task findNext(@Param("id")Long id, @Param("projectId")Long projectId);
}
