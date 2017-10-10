package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.TestTaskDto;
import org.qianrenxi.pms.entity.TestTask;
import org.qianrenxi.pms.service.TestTaskService;
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
@RequestMapping("/api/test/tasks")
public class TestTaskApiController {
	@Autowired
	private TestTaskService testTaskService;

	@ModelAttribute("testTaskForUpdate")
	public TestTask testTaskForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return testTaskService.findOne(id);
		}
		return new TestTask();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<TestTaskDto> allActivities(TestTask testTask, Pageable pageable) {
		Page<TestTask> activities = testTaskService.findAll(testTask, pageable);

		Type type = new TypeToken<List<TestTaskDto>>() {
		}.getType();
		return ModelMapperUtils.map(activities, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TestTaskDto getOne(@PathVariable("id") Long id) {
		TestTask testTask = testTaskService.findOne(id);
		return ModelMapperUtils.map(testTask, TestTaskDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public TestTaskDto create(@RequestBody() TestTask testTask) {
		testTask = testTaskService.save(testTask);
		return ModelMapperUtils.map(testTask, TestTaskDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public TestTaskDto update(@PathVariable("id") Long id, @ModelAttribute("testTaskForUpdate") TestTask testTask) {
		testTask.setId(id);
		testTask = testTaskService.save(testTask);
		return ModelMapperUtils.map(testTask, TestTaskDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		testTaskService.delete(ids);
	}
}
