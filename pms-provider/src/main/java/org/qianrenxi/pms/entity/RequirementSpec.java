package org.qianrenxi.pms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Auditable;

@Entity
@IdClass(RequirementSpecPK.class)
@Table(name = "pms_requirement_spec")
public class RequirementSpec extends Auditable {
	private static final long serialVersionUID = -8182259802870188701L;

	@Id
	private Long requirementId;
	@Id
	private Integer version;

	private String name;
	private String description;
	private String acceptance;

	public RequirementSpec() {
	}

	public RequirementSpec(Long requirementId, Integer version, String name, String description, String acceptance) {
		this.requirementId = requirementId;
		this.version = version;
		this.name = name;
		this.description = description;
		this.acceptance = acceptance;
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

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

}
