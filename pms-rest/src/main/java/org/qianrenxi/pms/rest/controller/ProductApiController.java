package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.ModuleDto;
import org.qianrenxi.pms.dto.PlanDto;
import org.qianrenxi.pms.dto.RequirementDto;
import org.qianrenxi.pms.entity.Module;
import org.qianrenxi.pms.entity.Plan;
import org.qianrenxi.pms.entity.Product;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.service.ModuleService;
import org.qianrenxi.pms.service.PlanService;
import org.qianrenxi.pms.service.ProductService;
import org.qianrenxi.pms.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductApiController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RequirementService requirementService;
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private ModuleService moduleService;


	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Product> allProducts(Product product, Pageable pageable) {
		Page<Product> products = productService.findAll(product, pageable);
		return products;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getOne(@PathVariable("id") Long id) {
		Product product = productService.findOne(id);
		return product;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Product create(@RequestBody() Product product) {
		product = productService.save(product);
		return product;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Product update(@PathVariable("id") Long id, Product product) {
		product.setId(id);
		product = productService.save(product);
		return product;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		productService.delete(ids);
	}

	/**
	 * 产品需求列表
	 * @param productId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "{id}/requirements", method = RequestMethod.GET)
	public Page<RequirementDto> requirements(@PathVariable(name = "id") Long productId, Requirement requirement,
			Pageable pageable) {
		Page<Requirement> reqs = requirementService.findByProduct(productId, requirement, pageable);
		
		Type type = new TypeToken<List<RequirementDto>>() {}.getType();
		return ModelMapperUtils.map(reqs, type, pageable);
	}
	
	/**
	 * 产品计划列表
	 * @param productId
	 * @param plan
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "{id}/plans", method = RequestMethod.GET)
	public Page<PlanDto> plans(@PathVariable(name="id")Long productId, Plan plan, Pageable pageable) {
		Page<Plan> plans = planService.findByProduct(productId, plan, pageable);
		
		Type type = new TypeToken<List<PlanDto>>() {}.getType();
		return ModelMapperUtils.map(plans, type, pageable);
	}
	
	/**
	 * 产品所有模块（平铺）
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "{id}/modulesFlat", method = RequestMethod.GET)
	public List<ModuleDto> modulesFlat(@PathVariable(name="id")Long productId) {
		List<Module> modules = moduleService.findAllByProduct(productId);
		
		List<ModuleDto> moduleDtos = new ArrayList<>();
		for (Module module : modules) {
			ModuleDto moduleDto = ModelMapperUtils.map(module, ModuleDto.class);
			Module parent = module.getParent();
			if(null!= parent) {
				moduleDto.setParentId(parent.getId());
				moduleDto.setParentName(parent.getName());
				moduleDto.setParentCode(parent.getCode());
			}
			moduleDtos.add(moduleDto);
		}
		
		// Type type = new TypeToken<List<ModuleDto>>(){}.getType();
		// return ModelMapperUtils.map(modules, type);
		
		return moduleDtos;
	}
}
