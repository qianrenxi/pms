package org.qianrenxi.pms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;
import org.qianrenxi.core.system.enity.User;

@Entity
@Table(name = "pms_test_task")
public class TestTask extends Repairable {
	private static final long serialVersionUID = -7621842263293211811L;

	public enum TestTaskStatus {
		/**
		 * 未开始
		 */
		WAIT,
		/**
		 * 进行中
		 */
		DOING,
		/**
		 * 已完成
		 */
		DONE,
		/**
		 * 被阻塞
		 */
		BLOCKED
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer priority;
	private Date startDate;
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private TestTaskStatus status;
	private String description;

	// tracking

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "build_id")
	private Build build;
	@ManyToOne
	@JoinColumn(name = "leader_id")
	private User leader;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public TestTaskStatus getStatus() {
		return status;
	}

	public void setStatus(TestTaskStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

}
