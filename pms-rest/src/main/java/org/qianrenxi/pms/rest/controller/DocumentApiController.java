package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.DocumentDto;
import org.qianrenxi.pms.entity.Document;
import org.qianrenxi.pms.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docs")
public class DocumentApiController {
	@Autowired
	private DocumentService documentService;

	@ModelAttribute("documentForUpdate")
	public Document documentForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return documentService.findOne(id);
		}
		return new Document();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<DocumentDto> allDocuments(Document document, Pageable pageable) {
		Page<Document> documents = documentService.findAll(document, pageable);

		Type type = new TypeToken<List<DocumentDto>>() {
		}.getType();
		return ModelMapperUtils.map(documents, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DocumentDto getOne(@PathVariable("id") Long id) {
		Document document = documentService.findOne(id);
		return ModelMapperUtils.map(document, DocumentDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public DocumentDto create(@RequestBody() Document document) {
		document = documentService.save(document);
		return ModelMapperUtils.map(document, DocumentDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public DocumentDto update(@PathVariable("id") Long id, @ModelAttribute("documentForUpdate") Document document) {
		document.setId(id);
		document = documentService.save(document);
		return ModelMapperUtils.map(document, DocumentDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		documentService.delete(ids);
	}
}
