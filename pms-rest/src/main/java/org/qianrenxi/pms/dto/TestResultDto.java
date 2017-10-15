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
	
	// createdBy
	private Long createdById;
	private String createdByUsername;
	private String createdByDisplayName;
	private Date createdDate;

	// lastModifiedBy
	private Long lastModifiedById;
	private String lastModifiedByUsername;
	private String lastModifiedByDisplayName;
	private Date lastModifiedDate;

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

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByDisplayName() {
		return createdByDisplayName;
	}

	public void setCreatedByDisplayName(String createdByDisplayName) {
		this.createdByDisplayName = createdByDisplayName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastModifiedById() {
		return lastModifiedById;
	}

	public void setLastModifiedById(Long lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	public String getLastModifiedByUsername() {
		return lastModifiedByUsername;
	}

	public void setLastModifiedByUsername(String lastModifiedByUsername) {
		this.lastModifiedByUsername = lastModifiedByUsername;
	}

	public String getLastModifiedByDisplayName() {
		return lastModifiedByDisplayName;
	}

	public void setLastModifiedByDisplayName(String lastModifiedByDisplayName) {
		this.lastModifiedByDisplayName = lastModifiedByDisplayName;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
