package org.qianrenxi.pms.entity;

import javax.persistence.Entity;
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

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
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

}
