package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.annotation.CurrentUser;
import org.qianrenxi.core.system.security.UserToken;
import org.qianrenxi.pms.dto.RequirementDto;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.service.BuildRequirementRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/builds/{buildId}/requirements")
public class BuildRequirementApiController {

	@Autowired
	private BuildRequirementRefService buildRequirementRefService;

	private Type getRequirementDtoListType() {
		return new TypeToken<List<RequirementDto>>() {
		}.getType();
	}

	/**
	 * 已关联需求
	 * 
	 * @param buildId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = { "", "/linked" }, method = RequestMethod.GET)
	public Page<RequirementDto> linked(@PathVariable("buildId") Long buildId, Requirement requirement,
			Pageable pageable) {
		Page<Requirement> requirements = buildRequirementRefService.findLinkedRequirements(buildId, requirement,
				pageable);

		return ModelMapperUtils.map(requirements, getRequirementDtoListType(), pageable);
	}

	/**
	 * 未关联需求
	 * 
	 * @param buildId
	 * @param requirement
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/notLinked", method = RequestMethod.GET)
	public Page<RequirementDto> notLinked(@PathVariable("buildId") Long buildId, Requirement requirement,
			Pageable pageable) {
		Page<Requirement> requirements = buildRequirementRefService.findNotLinkedRequirements(buildId, requirement,
				pageable);

		return ModelMapperUtils.map(requirements, getRequirementDtoListType(), pageable);
	}

	/**
	 * 关联需求
	 * @param buildId
	 * @param requirementIds
	 */
	@RequestMapping(value = "/link", method = RequestMethod.POST)
	public void link(@PathVariable("buildId") Long buildId, @RequestParam("requirementIds") Long[] requirementIds,
			@CurrentUser() UserToken userToken) {
		buildRequirementRefService.link(buildId, requirementIds, userToken.getUser());
	}
	
	/**
	 * 取消关联
	 * @param buildId
	 * @param requirementIds
	 */
	@RequestMapping(value = "/unlink", method = RequestMethod.POST)
	public void unlink(@PathVariable("buildId") Long buildId, @RequestParam("requirementIds") Long[] requirementIds,
			@CurrentUser() UserToken userToken) {
		buildRequirementRefService.unlink(buildId, requirementIds, userToken.getUser());
	}
}
