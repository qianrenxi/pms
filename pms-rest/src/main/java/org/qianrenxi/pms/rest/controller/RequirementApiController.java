package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.annotation.CurrentUser;
import org.qianrenxi.core.system.security.UserToken;
import org.qianrenxi.pms.dto.RequirementDto;
import org.qianrenxi.pms.dto.RequirementSpecDto;
import org.qianrenxi.pms.dto.ReviewInfo;
import org.qianrenxi.pms.entity.Requirement;
import org.qianrenxi.pms.entity.RequirementSpec;
import org.qianrenxi.pms.entity.RequirementSpecPK;
import org.qianrenxi.pms.service.RequirementService;
import org.qianrenxi.pms.service.RequirementSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;

@RestController
@RequestMapping("/api/requirements")
public class RequirementApiController {

	@Autowired
	private RequirementService requirementService;

	@Autowired
	private RequirementSpecService requirementSpecService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<RequirementDto> allRequirements(Requirement requirement, Pageable pageable) {
		Page<Requirement> requirements = requirementService.findAll(requirement, pageable);

		Type type = new TypeToken<List<RequirementDto>>() {
		}.getType();
		return ModelMapperUtils.map(requirements, type, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RequirementDto getOne(@PathVariable("id") Long id) {
		Requirement requirement = requirementService.findOne(id);

		return ModelMapperUtils.map(requirement, RequirementDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public RequirementDto create(@RequestBody() Requirement requirement, Long productId,
			@CurrentUser() UserToken userToken) {
		requirement = requirementService.create(requirement, userToken.getUser());

		return ModelMapperUtils.map(requirement, RequirementDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public RequirementDto update(@PathVariable("id") Long id, Requirement requirement,
			@RequestParam(name = "remark", required = false) String remark, @CurrentUser() UserToken userToken) {
		requirement.setId(id);
		requirement = requirementService.update(requirement, userToken.getUser(), remark);

		return ModelMapperUtils.map(requirement, RequirementDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@RequestParam("ids") Long[] ids) {
		requirementService.delete(ids);
	}

	/**
	 * 获得上一条和下一条需求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/near", method = RequestMethod.GET)
	public Map<String, RequirementDto> getNear(@PathVariable("id") Long id) {
		Map<String, Requirement> near = requirementService.findNear(id);

		Map<String, RequirementDto> nearDto = new HashMap<>();
		for (Entry<String, Requirement> item : near.entrySet()) {
			RequirementDto requirementDto = null;
			if (null != item.getValue()) {
				requirementDto = ModelMapperUtils.map(item.getValue(), RequirementDto.class);
				nearDto.put(item.getKey(), requirementDto);
			}
		}

		return nearDto;
	}

	/**
	 * 需求变更
	 * 
	 * @param id
	 * @param requirement
	 * @param userToken
	 * @return
	 */
	@RequestMapping(value = "/{id}/change", method = RequestMethod.POST)
	public RequirementDto change(@PathVariable("id") Long id, Requirement requirement,
			@RequestParam(name = "remark", required = false) String remark, @CurrentUser() UserToken userToken) {
		requirement.setId(id);
		requirement = requirementService.change(requirement, userToken.getUser(), remark);

		return ModelMapperUtils.map(requirement, RequirementDto.class);
	}

	/**
	 * 获得一个需求版本信息
	 * 
	 * @param requirementId
	 * @param version
	 * @return
	 */
	@RequestMapping(value = "/{id}/spec/{version}", method = RequestMethod.GET)
	public RequirementSpecDto getSpec(@PathVariable("id") Long requirementId,
			@PathVariable("version") Integer version) {
		RequirementSpecPK specPK = new RequirementSpecPK(requirementId, version);
		RequirementSpec spec = requirementSpecService.getOne(specPK);

		return ModelMapperUtils.map(spec, RequirementSpecDto.class);
	}

	/**
	 * 评审
	 * 
	 * @param id
	 * @param reviewInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/review", method = RequestMethod.POST)
	public void review(@PathVariable("id") Long id, ReviewInfo reviewInfo, @CurrentUser() UserToken userToken) {
		requirementService.review(id, reviewInfo, userToken.getUser());
	}

	/**
	 * 关闭
	 * 
	 * @param id
	 * @param reason
	 * @param remark
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/close", method = RequestMethod.POST)
	public void close(@PathVariable("id") Long id, @RequestParam(name = "reason") String reason,
			@RequestParam(name = "remark", required = false) String remark, @CurrentUser() UserToken userToken) {
		requirementService.close(id, reason, remark, userToken.getUser());
	}

	/**
	 * 添加备注、评论
	 * @param id
	 * @param remark
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/remark", method = RequestMethod.POST)
	public void remark(@PathVariable("id") Long id, @RequestParam("remark") String remark,
			@CurrentUser() UserToken userToken) {
		requirementService.remark(id, remark, userToken.getUser());
	}
	
	/**
	 * 更新日志
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/changeLog", method = RequestMethod.GET)
	public Map<String, ?> changeLog(@PathVariable("id") Long id){
		return ImmutableMap.of("changeLog", requirementService.changeLog(id));
	} 
}
