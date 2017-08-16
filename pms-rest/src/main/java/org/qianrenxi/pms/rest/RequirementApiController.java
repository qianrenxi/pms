package org.qianrenxi.pms.rest;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirements")
public class RequirementApiController {

	@Autowired
	private RequirementService requirementService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Requirement> allRequirements(Requirement requirement, Pageable pageable) {
		Page<Requirement> requirements = requirementService.findAll(requirement, pageable);
		return requirements;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Requirement getOne(@PathVariable("id") Long id) {
		Requirement requirement = requirementService.findOne(id);
		return requirement;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Requirement create(Requirement requirement) {
		requirement = requirementService.save(requirement);
		return requirement;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Requirement update(@PathVariable("id") Long id, Requirement requirement) {
		requirement.setId(id);
		requirement = requirementService.save(requirement);
		return requirement;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		requirementService.delete(ids);
	}

	@RequestMapping(value = "properties", method = RequestMethod.GET)
	public Map<String, Object> properties() {
		Map<String, Object> properties = new HashedMap();
		
		Map<String, String> source = new HashedMap();
		properties.put("requirementSource", source);
		source.put("customer", "客户");
		source.put("user", "客户");
		source.put("po", "产品经理");
		source.put("market", "市场");
		source.put("service", "客户");
		source.put("other", "其他");
		
		Map<String, String> priority = new HashedMap();
		properties.put("priority", priority);
		priority.put("0", "0");
		priority.put("1", "1");
		priority.put("2", "2");
		priority.put("3", "3");
		priority.put("4", "4");
		priority.put("5", "5");
		
		return properties;
	}
}
