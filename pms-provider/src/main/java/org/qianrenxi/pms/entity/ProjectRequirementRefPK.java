package org.qianrenxi.pms.entity;

import java.io.Serializable;

public class ProjectRequirementRefPK implements Serializable {
	private static final long serialVersionUID = -8054998854481190556L;

	private Long projectId;
	private Long requirementId;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}
}
