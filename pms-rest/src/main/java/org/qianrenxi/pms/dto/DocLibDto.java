package org.qianrenxi.pms.dto;

import java.util.Date;

import org.qianrenxi.pms.entity.DocLib.DocLibSourceType;
import org.qianrenxi.pms.entity.DocLib.DocLibType;

public class DocLibDto {
	private Long id;
	private String name;
	private String code;
	
	private DocLibType type;
	private DocLibSourceType sourceType;
	
	private String uri;
	private String username;
	private String password;
	private String branch;

	// private Product product;
	private Long productId;
	private String productName;

	// private Project project;
	private Long projectId;
	private String projectName;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DocLibType getType() {
		return type;
	}

	public void setType(DocLibType type) {
		this.type = type;
	}

	public DocLibSourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(DocLibSourceType sourceType) {
		this.sourceType = sourceType;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}
