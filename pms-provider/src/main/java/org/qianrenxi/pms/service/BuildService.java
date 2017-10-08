package org.qianrenxi.pms.service;

import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.Build;
import org.qianrenxi.pms.repository.jpa.BuildJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildService extends BaseService<Build, Long, BuildJpaRepository> {

	/**
	 * 按项目查找
	 * @param projectId
	 * @return
	 */
	public List<Build> findByProjectId(Long projectId) {
		return repository.findByProjectId(projectId);
	}
	
	/**
	 * 按产品查找
	 * @param productId
	 * @return
	 */
	public List<Build> findByProductId(Long productId) {
		return repository.findByProductId(productId);
	}
}
