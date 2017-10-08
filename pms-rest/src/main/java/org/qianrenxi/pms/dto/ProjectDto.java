package org.qianrenxi.pms.dto;

import java.util.Date;

import org.qianrenxi.pms.entity.Project.ProjectStatus;
import org.qianrenxi.pms.entity.Project.ProjectType;

public class ProjectDto {

	private Long id;
	private String name;
	private String code;
	private Date startDate;
	private Date endDate;

	private Integer workingDays;
	private String teamName;
	private String description;
	private ProjectType type;
	private ProjectStatus status;
	
	// product
	private Long productId;
	private String productName;
	
	// project leader
	private Long projectLeaderId;
	private String projectLeaderUsername;
	private String projectLeaderDisplayName;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Integer getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProjectType getType() {
		return type;
	}
	public void setType(ProjectType type) {
		this.type = type;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProjectLeaderId() {
		return projectLeaderId;
	}
	public void setProjectLeaderId(Long projectLeaderId) {
		this.projectLeaderId = projectLeaderId;
	}
	public String getProjectLeaderUsername() {
		return projectLeaderUsername;
	}
	public void setProjectLeaderUsername(String projectLeaderUsername) {
		this.projectLeaderUsername = projectLeaderUsername;
	}
	public String getProjectLeaderDisplayName() {
		return projectLeaderDisplayName;
	}
	public void setProjectLeaderDisplayName(String projectLeaderDisplayName) {
		this.projectLeaderDisplayName = projectLeaderDisplayName;
	}
}
