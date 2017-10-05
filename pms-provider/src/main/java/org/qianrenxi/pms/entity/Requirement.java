package org.qianrenxi.pms.entity;

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
@Table(name = "pms_requirement")
public class Requirement extends Repairable {
	private static final long serialVersionUID = -5111651626634922283L;

	public enum RequirementStage {
		/**
		 * 未开始
		 */
		WAIT,
		/**
		 * 已计划
		 */
		PLANNED,
		/**
		 * 已立项
		 */
		PROJECTED,
		/**
		 * 开发中
		 */
		DEVELOPING,
		/**
		 * 开发完成
		 */
		DEVELOPED,
		/**
		 * 测试中
		 */
		TESTING,
		/**
		 * 测试完成
		 */
		TESTED,
		/**
		 * 已验收
		 */
		VERIFIED,
		/**已发布
		 * 
		 */
		RELEASED
	}

	public enum RequirementStatus {
		/**
		 * 草稿
		 */
		DRAFT,
		/**
		 * 激活
		 */
		ACTIVE,
		/**
		 * 关闭
		 */
		CLOSED,
		/**
		 * 变更
		 */
		CHANGED
	}

//	public enum RequirementReviewResult {
//		/**
//		 * 通过
//		 */
//		PASS,
//		/**
//		 * 需求重复、重提、 变更回滚
//		 */
//		REVERT,
//		/**
//		 * 待明确
//		 */
//		CLARIFY,
//		/**
//		 * 拒绝
//		 */
//		REJECT
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Enumerated(EnumType.STRING)
	private RequirementStage stage;
	@Enumerated(EnumType.STRING)
	private RequirementStatus status;
//	@Enumerated(EnumType.STRING)
//	private RequirementReviewResult reviewResult;
	private Boolean needReview;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;
	@ManyToOne
	@JoinColumn(name = "assign_to")
	private User assignTo;

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

//	public void setReviewResult(RequirementReviewResult reviewResult) {
//		this.reviewResult = reviewResult;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public User getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(User assignTo) {
		this.assignTo = assignTo;
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
