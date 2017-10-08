package org.qianrenxi.pms.entity;

import java.io.Serializable;

public class BuildIssueRefPK implements Serializable{

	private static final long serialVersionUID = -2574250422548397957L;
	
	private Long buildId;
	private Long issueId;
	
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
