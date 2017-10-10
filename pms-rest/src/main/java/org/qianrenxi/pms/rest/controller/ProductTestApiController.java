package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.annotation.CurrentUser;
import org.qianrenxi.core.system.security.UserToken;
import org.qianrenxi.pms.dto.IssueDto;
import org.qianrenxi.pms.dto.TestCaseDto;
import org.qianrenxi.pms.dto.TestSuiteDto;
import org.qianrenxi.pms.dto.TestTaskDto;
import org.qianrenxi.pms.entity.Issue;
import org.qianrenxi.pms.entity.TestCase;
import org.qianrenxi.pms.entity.TestSuite;
import org.qianrenxi.pms.entity.TestTask;
import org.qianrenxi.pms.service.IssueService;
import org.qianrenxi.pms.service.TestCaseService;
import org.qianrenxi.pms.service.TestSuiteService;
import org.qianrenxi.pms.service.TestTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/{productId}/test")
public class ProductTestApiController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private TestCaseService testCaseService;
	
	@Autowired
	private TestTaskService testTaskService;
	
	@Autowired
	private TestSuiteService testSuiteService;
	
	@RequestMapping(value="issues", method = RequestMethod.GET)
	public Page<IssueDto> getIssues(@PathVariable("productId") Long productId, Issue issue, Pageable pageable,
			@CurrentUser() UserToken userToken) {
		Page<Issue> issues = issueService.findByProduct(productId, issue, pageable);
		
		Type type = new TypeToken<List<IssueDto>>() {}.getType();
		return ModelMapperUtils.map(issues, type, pageable);
	}
	
	@RequestMapping(value="cases", method = RequestMethod.GET)
	public Page<TestCaseDto> getTestCases(@PathVariable("productId") Long productId, TestCase testCase, Pageable pageable,
			@CurrentUser() UserToken userToken) {
		Page<TestCase> testCases = testCaseService.findByProduct(productId, testCase, pageable);
		
		Type type = new TypeToken<List<TestCaseDto>>() {}.getType();
		return ModelMapperUtils.map(testCases, type, pageable);
	}
	
	@RequestMapping(value="tasks", method = RequestMethod.GET)
	public Page<TestTaskDto> getTestTasks(@PathVariable("productId") Long productId, TestTask testTask, Pageable pageable,
			@CurrentUser() UserToken userToken) {
		Page<TestTask> testTasks = testTaskService.findByProduct(productId, testTask, pageable);
		
		Type type = new TypeToken<List<TestTaskDto>>() {}.getType();
		return ModelMapperUtils.map(testTasks, type, pageable);
	}
	
	@RequestMapping(value="suites", method = RequestMethod.GET)
	public Page<TestSuiteDto> getTestSuites(@PathVariable("productId") Long productId, TestSuite testSuite, Pageable pageable,
			@CurrentUser() UserToken userToken) {
		Page<TestSuite> testSuites = testSuiteService.findByProduct(productId, testSuite, pageable);
		
		Type type = new TypeToken<List<TestSuiteDto>>() {}.getType();
		return ModelMapperUtils.map(testSuites, type, pageable);
	}
}
