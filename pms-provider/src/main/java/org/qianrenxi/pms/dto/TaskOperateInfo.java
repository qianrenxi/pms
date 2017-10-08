package org.qianrenxi.pms.dto;

import java.util.Date;

public class TaskOperateInfo {

	private String remark;
	
	private Long assignedToId;
	private Float leftTime;
	
	private String closedReason;
	
	private Float usedTime;
	private Date completedDate;
	private Long completedById;
	
	private Date actsureStarted;
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}

	public Float getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Float leftTime) {
		this.leftTime = leftTime;
	}

	public String getClosedReason() {
		return closedReason;
	}

	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}

	public Float getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Float usedTime) {
		this.usedTime = usedTime;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Long getCompletedById() {
		return completedById;
	}

	public void setCompletedById(Long completedById) {
		this.completedById = completedById;
	}

	public Date getActsureStarted() {
		return actsureStarted;
	}

	public void setActsureStarted(Date actsureStarted) {
		this.actsureStarted = actsureStarted;
	}

}
