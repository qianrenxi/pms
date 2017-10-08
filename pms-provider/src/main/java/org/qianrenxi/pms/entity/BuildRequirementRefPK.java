package org.qianrenxi.pms.entity;

import java.io.Serializable;

public class BuildRequirementRefPK implements Serializable {

	private static final long serialVersionUID = -3076619887694796934L;
	
	private Long buildId;
	private Long requirementId;
	
	public Long getBuildId() {
		return buildId;
	}
	public void setBuildId(Long buildId) {
		this.buildId = buildId;
	}
	public Long getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}

	
}
