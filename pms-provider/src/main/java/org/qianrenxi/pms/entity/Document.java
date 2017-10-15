package org.qianrenxi.pms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.qianrenxi.core.system.enity.Repairable;

@Entity
@Table(name = "pms_document")
public class Document extends Repairable {
	private static final long serialVersionUID = 7152818430928135002L;

	@Id
	@GeneratedValue
	private Long id;
	// TODO: add category / folder
	private String name;
	private String keyword;
	private String format;
	@Lob
	private String content;
	// TODO: attachments
	// TODO: accessControl
	
	@ManyToOne
	@JoinColumn(name="doc_lib_id")
	private DocLib docLib;

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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DocLib getDocLib() {
		return docLib;
	}

	public void setDocLib(DocLib docLib) {
		this.docLib = docLib;
	}
}
