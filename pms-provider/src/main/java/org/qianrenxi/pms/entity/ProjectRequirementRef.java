package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ProjectRequirementRefPK.class)
@Table(name = "pms_project_requirement_ref")
public class ProjectRequirementRef implements Serializable {
	private static final long serialVersionUID = 6271216599830784230L;

	@Id
	private Long projectId;
	@Id
	private Long requirementId;

	public ProjectRequirementRef() {
	}

	public ProjectRequirementRef(Long projectId, Long requirementId) {
		setProjectId(projectId);
		setRequirementId(requirementId);
	}

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
