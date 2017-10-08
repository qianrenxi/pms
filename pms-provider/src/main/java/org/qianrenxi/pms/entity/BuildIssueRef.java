package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BuildIssueRefPK.class)
@Table(name = "pms_build_issue_ref")
public class BuildIssueRef implements Serializable {
	private static final long serialVersionUID = -6785806374798327063L;
	@Id
	private Long buildId;
	@Id
	private Long issueId;

	public BuildIssueRef() {
	}

	public BuildIssueRef(Long buildId, Long issueId) {
		this.buildId = buildId;
		this.issueId = issueId;
	}

	public Long getBuildId() {
		return buildId;
	}

	public void setBuildId(Long buildId) {
		this.buildId = buildId;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	

}
