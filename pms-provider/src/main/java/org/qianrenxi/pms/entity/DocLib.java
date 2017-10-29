package org.qianrenxi.pms.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;

@Entity
@Table(name="pms_doc_lib")
public class DocLib extends Repairable {
	private static final long serialVersionUID = -8543054674321099322L;
	
	public enum DocLibType {
		PRODUCT, PROJECT, CUSTOM
	}
	
	public enum DocLibSourceType {
		SIMPLE, FILE_SYSTEM, SVN, GIT
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String code;
	
	@Enumerated(EnumType.STRING)
	private DocLibType type;
	@Enumerated(EnumType.STRING)
	private DocLibSourceType sourceType;
	
	private String uri;
	private String username;
	private String password;
	private String branch;
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public DocLibType getType() {
		return type;
	}
	public void setType(DocLibType type) {
		this.type = type;
	}
	public DocLibSourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(DocLibSourceType sourceType) {
		this.sourceType = sourceType;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
