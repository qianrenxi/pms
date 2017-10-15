package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.pms.dto.IssueDto;
import org.qianrenxi.pms.entity.Issue;
import org.qianrenxi.pms.service.IssueService;
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
@RequestMapping("/api/issues")
public class IssueApiController {

	@Autowired
	private IssueService issueService;

	@ModelAttribute("issueForUpdate")
	public Issue issueForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return issueService.findOne(id);
		}
		return new Issue();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<IssueDto> allIssues(Issue issue, Pageable pageable) {
		Page<Issue> issues = issueService.findAll(issue, pageable);
		
		Type type = new TypeToken<List<IssueDto>>() {}.getType();
		return ModelMapperUtils.map(issues, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public IssueDto getOne(@PathVariable("id") Long id) {
		Issue issue = issueService.findOne(id);
		return ModelMapperUtils.map(issue, IssueDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public IssueDto create(@RequestBody() Issue issue) {
		issue = issueService.save(issue);
		return ModelMapperUtils.map(issue, IssueDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public IssueDto update(@PathVariable("id") Long id, @ModelAttribute("issueForUpdate") Issue issue) {
		issue.setId(id);
		issue = issueService.save(issue);
		return ModelMapperUtils.map(issue, IssueDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		issueService.delete(ids);
	}
}
