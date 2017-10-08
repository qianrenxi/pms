package org.qianrenxi.pms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;
import org.qianrenxi.core.system.enity.User;

@Entity
@Table(name = "pms_task")
public class Task extends Repairable {
	private static final long serialVersionUID = 8800628155549907246L;

	public enum TaskType {
		/**
		 * 设计
		 */
		DESIGN,
		/**
		 * 开发
		 */
		DEVELOP,
		/**
		 * 测试
		 */
		TEST,
		/**
		 * 研究
		 */
		RESEARCH,
		/**
		 * 讨论
		 */
		DISCUSS,
		/**
		 * 界面
		 */
		INTERFACE,
		/**
		 * 事务
		 */
		BUSINESS,
		/**
		 * 其他
		 */
		OTHERS
	}

	public enum TaskStatus {
		/**
		 * 未开始
		 */
		INITIAL,
		/**
		 * 进行中
		 */
		GOING,
		/**
		 * 已完成
		 */
		COMPLETED,
		/**
		 * 已暂停、挂起
		 */
		PAUSED,
		/**
		 * 已取消
		 */
		CANCELED,
		/**
		 * 已关闭
		 */
		CLOSED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private TaskType type;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	private Integer priority;

	private Float estimate;
	private Date estimateStarted;
	private Date deadline;
	private Date actsureStarted;
	private Float usedTime;
	private Float leftTime;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;
	@ManyToOne
	private User assignedTo;
	@ManyToOne
	@JoinColumn(name = "requirement_id")
	private Requirement requirement;

	@ManyToOne
	private User completedBy;
	private Date completedDate;
	@ManyToOne
	private User canceledBy;
	private Date canceledDate;
	@ManyToOne
	private User closedBy;
	private Date closedDate;
	private String closeReason;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Float getEstimate() {
		return estimate;
	}

	public void setEstimate(Float estimate) {
		this.estimate = estimate;
	}

	public Date getEstimateStarted() {
		return estimateStarted;
	}

	public void setEstimateStarted(Date estimateStarted) {
		this.estimateStarted = estimateStarted;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getActsureStarted() {
		return actsureStarted;
	}

	public void setActsureStarted(Date actsureStarted) {
		this.actsureStarted = actsureStarted;
	}

	public Float getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Float usedTime) {
		this.usedTime = usedTime;
	}

	public Float getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Float leftTime) {
		this.leftTime = leftTime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public User getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(User completedBy) {
		this.completedBy = completedBy;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public User getCanceledBy() {
		return canceledBy;
	}

	public void setCanceledBy(User canceledBy) {
		this.canceledBy = canceledBy;
	}

	public Date getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}

	public User getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(User closedBy) {
		this.closedBy = closedBy;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	
}
