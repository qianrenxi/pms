package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.annotation.CurrentUser;
import org.qianrenxi.core.system.security.UserToken;
import org.qianrenxi.pms.dto.TaskDto;
import org.qianrenxi.pms.dto.TaskOperateInfo;
import org.qianrenxi.pms.entity.Task;
import org.qianrenxi.pms.service.TaskService;
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
@RequestMapping("/api/tasks")
public class TaskApiController {

	@Autowired
	private TaskService taskService;

	private Type getListDtoType() {
		return new TypeToken<List<TaskDto>>() {
		}.getType();
	}

	@ModelAttribute("taskForUpdate")
	public Task taskForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return taskService.findOne(id);
		}
		return new Task();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<TaskDto> allTasks(Task task, Pageable pageable) {
		Page<Task> tasks = taskService.findAll(task, pageable);
		return ModelMapperUtils.map(tasks, getListDtoType(), pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TaskDto getOne(@PathVariable("id") Long id) {
		Task task = taskService.findOne(id);
		return ModelMapperUtils.map(task, TaskDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public TaskDto create(@RequestBody() Task task, @CurrentUser() UserToken userToken) {
		task = taskService.create(task, userToken.getUser());
		return ModelMapperUtils.map(task, TaskDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public TaskDto update(@PathVariable("id") Long id, @ModelAttribute("taskForUpdate") Task task,
			@RequestParam(name = "remark", required = false) String remark, @CurrentUser() UserToken userToken) {
		task.setId(id);
		task = taskService.update(task, userToken.getUser(), remark);
		return ModelMapperUtils.map(task, TaskDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		taskService.delete(ids);
	}

	/**
	 * 激活
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/active", method = RequestMethod.POST)
	public void active(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.active(id, operateInfo, userToken.getUser());
	}

	/**
	 * 指派
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/assign", method = RequestMethod.POST)
	public void assign(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.assign(id, operateInfo, userToken.getUser());
	}

	/**
	 * 取消
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/cancel", method = RequestMethod.POST)
	public void cancel(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.cancel(id, operateInfo, userToken.getUser());
	}

	/**
	 * 关闭
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/close", method = RequestMethod.POST)
	public void close(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.close(id, operateInfo, userToken.getUser());
	}

	/**
	 * 完成
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/complete", method = RequestMethod.POST)
	public void complete(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.complete(id, operateInfo, userToken.getUser());
	}

	/**
	 * 暂停
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/pause", method = RequestMethod.POST)
	public void pause(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.pause(id, operateInfo, userToken.getUser());
	}

	/**
	 * 继续
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/restart", method = RequestMethod.POST)
	public void restart(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.restart(id, operateInfo, userToken.getUser());
	}

	/**
	 * 开始
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
	public void start(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.start(id, operateInfo, userToken.getUser());
	}

	/**
	 * 备注、讨论
	 * 
	 * @param id
	 * @param operateInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/remark", method = RequestMethod.POST)
	public void remark(@PathVariable("id") Long id, TaskOperateInfo operateInfo, @CurrentUser() UserToken userToken) {
		taskService.remark(id, operateInfo, userToken.getUser());
	}

	/**
	 * 获得上一条和下一条需求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/near", method = RequestMethod.GET)
	public Map<String, TaskDto> getNear(@PathVariable("id") Long id) {
		Map<String, Task> near = taskService.findNear(id);

		Type type = new TypeToken<Map<String, TaskDto>>() {
		}.getType();
		return ModelMapperUtils.map(near, type);
	}
}
