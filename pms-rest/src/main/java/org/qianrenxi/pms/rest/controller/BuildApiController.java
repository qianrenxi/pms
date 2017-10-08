package org.qianrenxi.pms.rest.controller;

import org.qianrenxi.pms.entity.Build;
import org.qianrenxi.pms.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/builds")
public class BuildApiController {

	@Autowired
	BuildService buildService;
	
	@ModelAttribute("buildForUpdate")
	public Build buildForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return buildService.findOne(id);
		}
		return new Build();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Build> allActivities(Build build, Pageable pageable) {
		Page<Build> activities = buildService.findAll(build, pageable);
		return activities;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Build getOne(@PathVariable("id") Long id) {
		Build build = buildService.findOne(id);
		return build;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Build create(@RequestBody() Build build) {
		build = buildService.save(build);
		return build;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Build update(@PathVariable("id") Long id, @ModelAttribute("buildForUpdate") Build build) {
		build.setId(id);
		build = buildService.save(build);
		return build;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		buildService.delete(ids);
	}
}
