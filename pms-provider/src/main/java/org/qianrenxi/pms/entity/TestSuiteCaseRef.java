package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TestSuiteCaseRefPK.class)
@Table(name = "pms_test_suite_case_ref")
public class TestSuiteCaseRef implements Serializable {
	private static final long serialVersionUID = 1416316161749005983L;

	@Id
	private Long suiteId;
	@Id
	private Long caseId;

	public TestSuiteCaseRef() {
	}

	public TestSuiteCaseRef(Long suiteId, Long caseId) {
		super();
		this.suiteId = suiteId;
		this.caseId = caseId;
	}

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
