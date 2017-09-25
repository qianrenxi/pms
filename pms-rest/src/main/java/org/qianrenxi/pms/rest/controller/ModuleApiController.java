package org.qianrenxi.pms.rest.controller;

import java.util.List;

import org.qianrenxi.pms.entity.Module;
import org.qianrenxi.pms.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modules")
public class ModuleApiController {

	@Autowired
	private ModuleService moduleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Module> allModules(@RequestParam(name = "product.id") Long productId,
			@RequestParam(name = "parent.id", required = false) Long parentId) {
		if (parentId != null) {
			return moduleService.getChildren(parentId);
		} else {
			return moduleService.getRoots(productId);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Module getOne(@PathVariable("id") Long id) {
		Module module = moduleService.findOne(id);
		return module;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Module create(@RequestBody() Module module) {
		module = moduleService.save(module);
		return module;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Module update(@PathVariable("id") Long id, Module module) {
		module.setId(id);
		module = moduleService.save(module);
		return module;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		moduleService.delete(ids);
	}
}
