package org.qianrenxi.pms.dto;

import java.util.Date;

import org.qianrenxi.pms.entity.Task.TaskStatus;
import org.qianrenxi.pms.entity.Task.TaskType;

public class TaskDto {

	private Long id;
	private String name;
	private String description;
	private TaskType type;
	private TaskStatus status;

	private Integer priority;

	private Float estimate;
	private Date estimateStarted;
	private Date deadline;
	private Date actsureStarted;
	private Float usedTime;
	private Float leftTime;
	
	// project
	private Long projectId;
	private String projectName;
	
	// module
	
	// assignedTo
	private Long assignedToId;
	private String assignedToUsername;
	private String assignedToDisplayName;
	
	// requirement
	private Long requirementId;
	private String requirementName;
	private String requirementDescipriton;
	private String requirementAcceptance;
	
	
	// completedBy
	private Long completedById;
	private String completedByUsername;
	private String completedByDisplayName;
	private Date completedDate;
	
	// canceledBy
	private Long canceledById;
	private String canceledByUsername;
	private String canceledByDisplayName;
	private Date canceledDate;
	
	// closedBy
	private Long closedById;
	private String closedByUsername;
	private String closedByDisplayName;
	private Date closedDate;
	
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
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Long getAssignedToId() {
		return assignedToId;
	}
	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}
	public String getAssignedToUsername() {
		return assignedToUsername;
	}
	public void setAssignedToUsername(String assignedToUsername) {
		this.assignedToUsername = assignedToUsername;
	}
	public String getAssignedToDisplayName() {
		return assignedToDisplayName;
	}
	public void setAssignedToDisplayName(String assignedToDisplayName) {
		this.assignedToDisplayName = assignedToDisplayName;
	}
	public Long getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}
	public String getRequirementName() {
		return requirementName;
	}
	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}
	public String getRequirementDescipriton() {
		return requirementDescipriton;
	}
	public void setRequirementDescipriton(String requirementDescipriton) {
		this.requirementDescipriton = requirementDescipriton;
	}
	public String getRequirementAcceptance() {
		return requirementAcceptance;
	}
	public void setRequirementAcceptance(String requirementAcceptance) {
		this.requirementAcceptance = requirementAcceptance;
	}
	public Long getCompletedById() {
		return completedById;
	}
	public void setCompletedById(Long completedById) {
		this.completedById = completedById;
	}
	public String getCompletedByUsername() {
		return completedByUsername;
	}
	public void setCompletedByUsername(String completedByUsername) {
		this.completedByUsername = completedByUsername;
	}
	public String getCompletedByDisplayName() {
		return completedByDisplayName;
	}
	public void setCompletedByDisplayName(String completedByDisplayName) {
		this.completedByDisplayName = completedByDisplayName;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	public Long getCanceledById() {
		return canceledById;
	}
	public void setCanceledById(Long canceledById) {
		this.canceledById = canceledById;
	}
	public String getCanceledByUsername() {
		return canceledByUsername;
	}
	public void setCanceledByUsername(String canceledByUsername) {
		this.canceledByUsername = canceledByUsername;
	}
	public String getCanceledByDisplayName() {
		return canceledByDisplayName;
	}
	public void setCanceledByDisplayName(String canceledByDisplayName) {
		this.canceledByDisplayName = canceledByDisplayName;
	}
	public Date getCanceledDate() {
		return canceledDate;
	}
	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}
	public Long getClosedById() {
		return closedById;
	}
	public void setClosedById(Long closedById) {
		this.closedById = closedById;
	}
	public String getClosedByUsername() {
		return closedByUsername;
	}
	public void setClosedByUsername(String closedByUsername) {
		this.closedByUsername = closedByUsername;
	}
	public String getClosedByDisplayName() {
		return closedByDisplayName;
	}
	public void setClosedByDisplayName(String closedByDisplayName) {
		this.closedByDisplayName = closedByDisplayName;
	}
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
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
