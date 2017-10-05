package org.qianrenxi.pms.service;

import java.util.List;

import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.pms.entity.Module;
import org.qianrenxi.pms.repository.jpa.ModuleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ModuleService extends BaseService<Module, Long, ModuleJpaRepository> {

	public List<Module> getRoots(Long productId) {
		return repository.findRoots(productId);
	}
	
	public List<Module> getChildren(Long parentId) {
		return repository.findChildren(parentId);
	}
	
	public List<Module> findAllByProduct(Long productId) {
		return repository.findAllByProduct(productId);
	}
}
