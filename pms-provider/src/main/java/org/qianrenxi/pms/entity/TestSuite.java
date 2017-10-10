package org.qianrenxi.pms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;

@Entity
@Table(name = "pms_test_suite")
public class TestSuite extends Repairable {

	private static final long serialVersionUID = -1635021803608341646L;

	public enum AccessControl {
		PRIVATE, PUBLIC,
	}

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;

	private AccessControl accessControl;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccessControl getAccessControl() {
		return accessControl;
	}

	public void setAccessControl(AccessControl accessControl) {
		this.accessControl = accessControl;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
