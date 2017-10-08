package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BuildRequirementRefPK.class)
@Table(name = "pms_build_requirement_ref")
public class BuildRequirementRef implements Serializable {
	private static final long serialVersionUID = 5224433955777625154L;
	
	@Id
	private Long buildId;
	@Id
	private Long requirementId;

	public BuildRequirementRef() {
	}
	
	public BuildRequirementRef(Long buildId, Long requirementId) {
		setBuildId(buildId);
		setRequirementId(requirementId);
	}

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
