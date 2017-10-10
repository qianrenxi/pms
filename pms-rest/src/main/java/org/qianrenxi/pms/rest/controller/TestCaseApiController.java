package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.TestCaseDto;
import org.qianrenxi.pms.dto.TestTaskDto;
import org.qianrenxi.pms.entity.TestCase;
import org.qianrenxi.pms.service.TestCaseService;
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
@RequestMapping("/api/test/cases")
public class TestCaseApiController {

	@Autowired
	private TestCaseService testCaseService;

	@ModelAttribute("testCaseForUpdate")
	public TestCase testCaseForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return testCaseService.findOne(id);
		}
		return new TestCase();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<TestCaseDto> allActivities(TestCase testCase, Pageable pageable) {
		Page<TestCase> activities = testCaseService.findAll(testCase, pageable);

		Type type = new TypeToken<List<TestCaseDto>>() {
		}.getType();
		return ModelMapperUtils.map(activities, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TestCaseDto getOne(@PathVariable("id") Long id) {
		TestCase testCase = testCaseService.findOne(id);
		return ModelMapperUtils.map(testCase, TestCaseDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public TestCaseDto create(@RequestBody() TestCase testCase) {
		testCase = testCaseService.save(testCase);
		return ModelMapperUtils.map(testCase, TestCaseDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public TestCaseDto update(@PathVariable("id") Long id, @ModelAttribute("testCaseForUpdate") TestCase testCase) {
		testCase.setId(id);
		testCase = testCaseService.save(testCase);
		return ModelMapperUtils.map(testCase, TestCaseDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		testCaseService.delete(ids);
	}
}
