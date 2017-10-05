package org.qianrenxi.pms.entity;

import java.io.Serializable;

public class RequirementSpecPK implements Serializable {
	private static final long serialVersionUID = -6417150536512809956L;
	
	private Long requirementId;
	private Integer version;
	
	public RequirementSpecPK() {}

	public RequirementSpecPK(Long reqId, Integer version) {
		this.requirementId = reqId;
		this.version = version;
	}
	
	public Long getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
