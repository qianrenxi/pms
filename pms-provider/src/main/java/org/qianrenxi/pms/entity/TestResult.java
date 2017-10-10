package org.qianrenxi.pms.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;
import org.qianrenxi.core.system.enity.User;

@Entity
@Table(name = "pms_test_execute_result")
public class TestResult extends Repairable {
	private static final long serialVersionUID = -5411941131097760805L;

	@Id
	@GeneratedValue
	private Long id;
	private String result;

	@ManyToOne
	@JoinColumn(name = "test_case_id")
	private TestCase testCase;
	@ManyToOne
	@JoinColumn(name = "test_task_id")
	private TestTask testTask;

	@ManyToOne
	@JoinColumn(name = "executed_by")
	private User executedBy;
	private Date executedDate;

	@ElementCollection
	@CollectionTable(name = "pms_test_execute_detail")
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

	public TestCase getTestCase() {
		return testCase;
	}

	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}

	public TestTask getTestTask() {
		return testTask;
	}

	public void setTestTask(TestTask testTask) {
		this.testTask = testTask;
	}

	public User getExecutedBy() {
		return executedBy;
	}

	public void setExecutedBy(User executedBy) {
		this.executedBy = executedBy;
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
