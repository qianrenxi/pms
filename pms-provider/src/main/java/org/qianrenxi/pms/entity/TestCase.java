package org.qianrenxi.pms.entity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;

@Entity
@Table(name = "pms_test_case")
public class TestCase extends Repairable {
	private static final long serialVersionUID = 7173647074807086295L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	/** 前置条件 */
	private String precondition;
	private String keywords;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;
	@ManyToOne
	@JoinColumn(name = "requirement_id")
	private Requirement requirement;

	@ElementCollection
	@CollectionTable(name = "pms_test_case_step")
	@OrderBy("step DESC")
	// private Set<TestCaseStep> steps = new LinkedHashSet<>();
	private List<TestCaseStep> steps = new ArrayList<>();

	// Attributes
	/** 优先级 */
	private Integer priority;
	/** 用例类型 */
	private String type;
	/** 适用阶段 */
	private String stage;
	/** 执行结果 */
	private String result;
	/** 状态 */
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrecondition() {
		return precondition;
	}

	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

/*	public Set<TestCaseStep> getSteps() {
		return steps;
	}

	public void setSteps(Set<TestCaseStep> steps) {
		this.steps = steps;
	}*/

	public Integer getPriority() {
		return priority;
	}

	public List<TestCaseStep> getSteps() {
		return steps;
	}

	public void setSteps(List<TestCaseStep> steps) {
		this.steps = steps;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
