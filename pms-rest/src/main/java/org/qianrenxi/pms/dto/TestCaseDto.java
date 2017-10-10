package org.qianrenxi.pms.dto;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.qianrenxi.pms.entity.TestCaseStep;

public class TestCaseDto {

	private Long id;
	private String name;
	/** 前置条件 */
	private String precondition;
	private String keywords;

	// private Product product;
	private Long productId;
	private String productName;
	// private Module module;
	private Long moduleId;
	private String moduleName;
	// private Requirement requirement;
	private Long requirementId;
	private String requirementName;

	private Set<TestCaseStep> steps = new LinkedHashSet<>();

	// Attributes
	/** 优先级 */
	private Integer priority;
	/** 用例类型 */
	private String type;
	/** 适用阶段 */
	private String stage;
	/** 执行结果 */
	private String result;
	/** 状态 */
	private String status;

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

	public String getPrecondition() {
		return precondition;
	}

	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public Set<TestCaseStep> getSteps() {
		return steps;
	}

	public void setSteps(Set<TestCaseStep> steps) {
		this.steps = steps;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
