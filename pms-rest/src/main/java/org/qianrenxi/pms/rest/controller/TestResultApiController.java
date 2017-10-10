package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.TestResultDto;
import org.qianrenxi.pms.dto.TestTaskDto;
import org.qianrenxi.pms.entity.TestResult;
import org.qianrenxi.pms.service.TestResultService;
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
@RequestMapping("/api/test/results")
public class TestResultApiController {

	@Autowired
	private TestResultService testResultService;

	@ModelAttribute("testResultForUpdate")
	public TestResult testResultForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return testResultService.findOne(id);
		}
		return new TestResult();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<TestResultDto> allActivities(TestResult testResult, Pageable pageable) {
		Page<TestResult> activities = testResultService.findAll(testResult, pageable);

		Type type = new TypeToken<List<TestResultDto>>() {
		}.getType();
		return ModelMapperUtils.map(activities, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TestResultDto getOne(@PathVariable("id") Long id) {
		TestResult testResult = testResultService.findOne(id);
		return ModelMapperUtils.map(testResult, TestResultDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public TestResultDto create(@RequestBody() TestResult testResult) {
		testResult = testResultService.save(testResult);
		return ModelMapperUtils.map(testResult, TestResultDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public TestResultDto update(@PathVariable("id") Long id,
			@ModelAttribute("testResultForUpdate") TestResult testResult) {
		testResult.setId(id);
		testResult = testResultService.save(testResult);
		return ModelMapperUtils.map(testResult, TestResultDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		testResultService.delete(ids);
	}
}
