package org.qianrenxi.pms.entity;

import java.io.Serializable;

public class TestSuiteCaseRefPK implements Serializable {

	private static final long serialVersionUID = 7453752720449313549L;

	private Long suiteId;
	private Long caseId;

	public Long getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(Long suiteId) {
		this.suiteId = suiteId;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
}
