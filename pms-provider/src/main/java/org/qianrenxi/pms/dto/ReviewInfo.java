package org.qianrenxi.pms.dto;

import java.util.Date;

public class ReviewInfo {
	
	public enum ReviewResult {
		/**
		 * 通过
		 */
		PASS,
		/**
		 * 撤销变更
		 */
		REVERT,
		/**
		 * 有待明确
		 */
		CLARIFY,
		/**
		 * 拒绝
		 */
		REJECT
	}

	private Date reviewedDate;
	private ReviewResult reviewedResult;
	private Long reviewedBy;
	private Long assignToId;
	private String remark;
	
	public Date getReviewedDate() {
		return reviewedDate;
	}
	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
	}
	public ReviewResult getReviewedResult() {
		return reviewedResult;
	}
	public void setReviewedResult(ReviewResult reviewedResult) {
		this.reviewedResult = reviewedResult;
	}
	public Long getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(Long reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public Long getAssignToId() {
		return assignToId;
	}
	public void setAssignToId(Long assignToId) {
		this.assignToId = assignToId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
