package org.qianrenxi.pms.dto;

import org.qianrenxi.pms.entity.Requirement.RequirementStage;
import org.qianrenxi.pms.entity.Requirement.RequirementStatus;

public class RequirementDto {

	private Long id;
	private String name;
	private String description;
	private Float estimate;
	private String acceptance;
	private String keywords;
	private Integer version;

	// 动态可配置属性
	private Integer priority;
	private String source;
	private String sourceRemark;
	private String closeReason;

	private RequirementStage stage;
	private RequirementStatus status;
	// private RequirementReviewResult reviewResult;
	private Boolean needReview;

	// private Product product;
	// private Module module;
	// private Plan plan;

	private Long productId;
	private String productName;

	private Long moduleId;
	private String moduleName;

	private Long planId;
	private String planName;
	
	private Long assignToId;
	private String assignToDisplayName;
	
	private Long createdById;
	private String createdByDisplayName;
	private Long lastModifiedById;
	private String lastModifiedByDisplayName;

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

	public Float getEstimate() {
		return estimate;
	}

	public void setEstimate(Float estimate) {
		this.estimate = estimate;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceRemark() {
		return sourceRemark;
	}

	public void setSourceRemark(String sourceRemark) {
		this.sourceRemark = sourceRemark;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public RequirementStage getStage() {
		return stage;
	}

	public void setStage(RequirementStage stage) {
		this.stage = stage;
	}

	public RequirementStatus getStatus() {
		return status;
	}

	public void setStatus(RequirementStatus status) {
		this.status = status;
	}

//	public RequirementReviewResult getReviewResult() {
//		return reviewResult;
//	}
//
//	public void setReviewResult(RequirementReviewResult reviewResult) {
//		this.reviewResult = reviewResult;
//	}

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

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public String getCreatedByDisplayName() {
		return createdByDisplayName;
	}

	public void setCreatedByDisplayName(String createdByDisplayName) {
		this.createdByDisplayName = createdByDisplayName;
	}

	public Long getLastModifiedById() {
		return lastModifiedById;
	}

	public void setLastModifiedById(Long lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	public String getLastModifiedByDisplayName() {
		return lastModifiedByDisplayName;
	}

	public void setLastModifiedByDisplayName(String lastModifiedByDisplayName) {
		this.lastModifiedByDisplayName = lastModifiedByDisplayName;
	}

	public Long getAssignToId() {
		return assignToId;
	}

	public void setAssignToId(Long assignToId) {
		this.assignToId = assignToId;
	}

	public String getAssignToDisplayName() {
		return assignToDisplayName;
	}

	public void setAssignToDisplayName(String assignToDisplayName) {
		this.assignToDisplayName = assignToDisplayName;
	}

	public Boolean getNeedReview() {
		return needReview;
	}

	public void setNeedReview(Boolean needReview) {
		this.needReview = needReview;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
