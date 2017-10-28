package org.qianrenxi.pms.service;

import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.DocLib;
import org.qianrenxi.pms.repository.jpa.DocLibJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DocLibService extends BaseService<DocLib, Long, DocLibJpaRepository> {

	public List<DocLib> findByProduct(Long productId) {
		return repository.findByProductId(productId);
	}
	
	public List<DocLib> findByProject(Long projectId) {
		return repository.findByProjectId(projectId);
	}
}
