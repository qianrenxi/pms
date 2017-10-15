package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.DocLibDto;
import org.qianrenxi.pms.entity.DocLib;
import org.qianrenxi.pms.service.DocLibService;
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
@RequestMapping("/api/docLibs")
public class DocLibApiController {
	@Autowired
	private DocLibService docLibService;

	@ModelAttribute("docLibForUpdate")
	public DocLib docLibForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return docLibService.findOne(id);
		}
		return new DocLib();
	}

	@RequestMapping(value = "page", method = RequestMethod.GET)
	public Page<DocLibDto> allDocLibs(DocLib docLib, Pageable pageable) {
		Page<DocLib> docLibs = docLibService.findAll(docLib, pageable);

		Type type = new TypeToken<List<DocLibDto>>() {
		}.getType();
		return ModelMapperUtils.map(docLibs, type, pageable);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<DocLibDto> allDocLibs() {
		List<DocLib> docLibs = (List<DocLib>) docLibService.findAll();

		Type type = new TypeToken<List<DocLibDto>>() {
		}.getType();
		return ModelMapperUtils.map(docLibs, type);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DocLibDto getOne(@PathVariable("id") Long id) {
		DocLib docLib = docLibService.findOne(id);
		return ModelMapperUtils.map(docLib, DocLibDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public DocLibDto create(@RequestBody() DocLib docLib) {
		docLib = docLibService.save(docLib);
		return ModelMapperUtils.map(docLib, DocLibDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public DocLibDto update(@PathVariable("id") Long id, @ModelAttribute("docLibForUpdate") DocLib docLib) {
		docLib.setId(id);
		docLib = docLibService.save(docLib);
		return ModelMapperUtils.map(docLib, DocLibDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		docLibService.delete(ids);
	}
}
