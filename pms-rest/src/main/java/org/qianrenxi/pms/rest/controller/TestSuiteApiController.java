package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.TestSuiteDto;
import org.qianrenxi.pms.dto.TestTaskDto;
import org.qianrenxi.pms.entity.TestSuite;
import org.qianrenxi.pms.service.TestSuiteService;
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
@RequestMapping("/api/rest/suites")
public class TestSuiteApiController {
	@Autowired
	private TestSuiteService testSuiteService;

	@ModelAttribute("testSuiteForUpdate")
	public TestSuite testSuiteForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return testSuiteService.findOne(id);
		}
		return new TestSuite();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<TestSuiteDto> allActivities(TestSuite testSuite, Pageable pageable) {
		Page<TestSuite> activities = testSuiteService.findAll(testSuite, pageable);

		Type type = new TypeToken<List<TestSuiteDto>>() {
		}.getType();
		return ModelMapperUtils.map(activities, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TestSuiteDto getOne(@PathVariable("id") Long id) {
		TestSuite testSuite = testSuiteService.findOne(id);
		return ModelMapperUtils.map(testSuite, TestSuiteDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public TestSuiteDto create(@RequestBody() TestSuite testSuite) {
		testSuite = testSuiteService.save(testSuite);
		return ModelMapperUtils.map(testSuite, TestSuiteDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public TestSuiteDto update(@PathVariable("id") Long id, @ModelAttribute("testSuiteForUpdate") TestSuite testSuite) {
		testSuite.setId(id);
		testSuite = testSuiteService.save(testSuite);
		return ModelMapperUtils.map(testSuite, TestSuiteDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		testSuiteService.delete(ids);
	}
}
