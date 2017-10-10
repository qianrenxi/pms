package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TestResultItem extends TestCaseStep implements Serializable {

	private static final long serialVersionUID = 350655400574894580L;

	private String result;
	private String actually;

	// 附件、图片

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getActually() {
		return actually;
	}

	public void setActually(String actually) {
		this.actually = actually;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((actually == null) ? 0 : actually.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestResultItem other = (TestResultItem) obj;
		if (actually == null) {
			if (other.actually != null)
				return false;
		} else if (!actually.equals(other.actually))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

}
