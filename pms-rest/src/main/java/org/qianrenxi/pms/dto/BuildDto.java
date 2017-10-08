package org.qianrenxi.pms.dto;

import java.util.Date;

public class BuildDto {
	private Long id;
	private String name;
	private String tag;
	private String repositoryUrl;
	private String downloadUrl;
	private String description;

	// private Product product;
	private Long productId;
	private String productName;

	// private Project project;
	private Long projectId;
	private String projectName;

	// private User buildedBy;
	private Long buildedById;
	private String buildedByUsername;
	private String buildedByDisplayName;

	private Date buildedDate;

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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRepositoryUrl() {
		return repositoryUrl;
	}

	public void setRepositoryUrl(String repositoryUrl) {
		this.repositoryUrl = repositoryUrl;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getBuildedById() {
		return buildedById;
	}

	public void setBuildedById(Long buildedById) {
		this.buildedById = buildedById;
	}

	public String getBuildedByUsername() {
		return buildedByUsername;
	}

	public void setBuildedByUsername(String buildedByUsername) {
		this.buildedByUsername = buildedByUsername;
	}

	public String getBuildedByDisplayName() {
		return buildedByDisplayName;
	}

	public void setBuildedByDisplayName(String buildedByDisplayName) {
		this.buildedByDisplayName = buildedByDisplayName;
	}

	public Date getBuildedDate() {
		return buildedDate;
	}

	public void setBuildedDate(Date buildedDate) {
		this.buildedDate = buildedDate;
	}
}
