package org.qianrenxi.pms.dto;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.qianrenxi.pms.entity.TestResultItem;

public class TestResultDto {

	private Long id;
	private String result;

	// private TestCase testCase;
	private Long testCaseId;
	private String testCaseName;

	// private TestTask testTask;
	private Long testTaskId;
	private String testTaskName;

	// private User executedBy;
	private Long executedById;
	private String executedByUsername;
	private String executedByDisplayName;
	private Date executedDate;

	private Set<TestResultItem> details = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(Long testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public Long getTestTaskId() {
		return testTaskId;
	}

	public void setTestTaskId(Long testTaskId) {
		this.testTaskId = testTaskId;
	}

	public String getTestTaskName() {
		return testTaskName;
	}

	public void setTestTaskName(String testTaskName) {
		this.testTaskName = testTaskName;
	}

	public Long getExecutedById() {
		return executedById;
	}

	public void setExecutedById(Long executedById) {
		this.executedById = executedById;
	}

	public String getExecutedByUsername() {
		return executedByUsername;
	}

	public void setExecutedByUsername(String executedByUsername) {
		this.executedByUsername = executedByUsername;
	}

	public String getExecutedByDisplayName() {
		return executedByDisplayName;
	}

	public void setExecutedByDisplayName(String executedByDisplayName) {
		this.executedByDisplayName = executedByDisplayName;
	}

	public Date getExecutedDate() {
		return executedDate;
	}

	public void setExecutedDate(Date executedDate) {
		this.executedDate = executedDate;
	}

	public Set<TestResultItem> getDetails() {
		return details;
	}

	public void setDetails(Set<TestResultItem> details) {
		this.details = details;
	}
}
