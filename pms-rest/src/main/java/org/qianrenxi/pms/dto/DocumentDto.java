package org.qianrenxi.pms.dto;

import java.util.Date;

public class DocumentDto {
	private Long id;
	// TODO: add category / folder
	private String name;
	private String keyword;
	private String format;
	private String originalContent;
	private String content;
	// TODO: attachments
	// TODO: accessControl

	// private DocLib docLib;
	private Long docLibId;
	private String docLibName;

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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getDocLibId() {
		return docLibId;
	}
	public void setDocLibId(Long docLibId) {
		this.docLibId = docLibId;
	}
	public String getDocLibName() {
		return docLibName;
	}
	public void setDocLibName(String docLibName) {
		this.docLibName = docLibName;
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
	public String getOriginalContent() {
		return originalContent;
	}
	public void setOriginalContent(String originalContent) {
		this.originalContent = originalContent;
	}
}
