package org.qianrenxi.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class TestCaseStep implements Serializable {
	private static final long serialVersionUID = 6263702558860374652L;

	public enum StepType {
		GROUP, ITEM
	}

	@Column(nullable = false)
	private Float step;
	@Column(nullable = false)
	private String action;
	private String expect;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StepType type;

	public Float getStep() {
		return step;
	}

	public void setStep(Float step) {
		this.step = step;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public StepType getType() {
		return type;
	}

	public void setType(StepType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((expect == null) ? 0 : expect.hashCode());
		result = prime * result + ((step == null) ? 0 : step.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestCaseStep other = (TestCaseStep) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (expect == null) {
			if (other.expect != null)
				return false;
		} else if (!expect.equals(other.expect))
			return false;
		if (step == null) {
			if (other.step != null)
				return false;
		} else if (!step.equals(other.step))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
