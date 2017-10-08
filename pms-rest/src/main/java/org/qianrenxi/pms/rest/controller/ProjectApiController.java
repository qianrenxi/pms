package org.qianrenxi.pms.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.annotation.CurrentUser;
import org.qianrenxi.core.system.security.UserToken;
import org.qianrenxi.pms.dto.BuildDto;
import org.qianrenxi.pms.dto.ProjectDelayInfo;
import org.qianrenxi.pms.dto.ProjectDto;
import org.qianrenxi.pms.dto.TaskDto;
import org.qianrenxi.pms.entity.Build;
import org.qianrenxi.pms.entity.Project;
import org.qianrenxi.pms.entity.Task;
import org.qianrenxi.pms.service.BuildService;
import org.qianrenxi.pms.service.ProjectService;
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
@RequestMapping("/api/projects")
public class ProjectApiController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private BuildService buildService;

	private Type getListDtoType() {
		return new TypeToken<List<ProjectDto>>() {
		}.getType();
	}

	@ModelAttribute("projectForUpdate")
	public Project projectForUpdate(@RequestParam(name = "id", required = false) Long id) {
		if (null != id) {
			return projectService.findOne(id);
		}
		return new Project();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<ProjectDto> allProjects(Project project, Pageable pageable) {
		Page<Project> projects = projectService.findAll(project, pageable);
		return ModelMapperUtils.map(projects, getListDtoType(), pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProjectDto getOne(@PathVariable("id") Long id) {
		Project project = projectService.findOne(id);
		return ModelMapperUtils.map(project, ProjectDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ProjectDto create(@RequestBody() Project project) {
		project = projectService.save(project);
		return ModelMapperUtils.map(project, ProjectDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ProjectDto update(@PathVariable("id") Long id, @ModelAttribute("projectForUpdate") Project project) {
		project.setId(id);
		project = projectService.save(project);
		return ModelMapperUtils.map(project, ProjectDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void update(@RequestParam("ids") Long[] ids) {
		projectService.delete(ids);
	}

	/**
	 * 开始项目
	 * 
	 * @param id
	 * @param remark
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
	public void start(@PathVariable("id") Long id, String remark, @CurrentUser() UserToken userToken) {
		projectService.start(id, remark, userToken.getUser());
	}

	/**
	 * 延期项目
	 * 
	 * @param id
	 * @param delayInfo
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/delay", method = RequestMethod.POST)
	public void delay(@PathVariable("id") Long id, ProjectDelayInfo delayInfo, @CurrentUser() UserToken userToken) {
		projectService.delay(id, delayInfo, userToken.getUser());
	}

	/**
	 * 挂起、暂停项目
	 * 
	 * @param id
	 * @param remark
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/pause", method = RequestMethod.POST)
	public void pause(@PathVariable("id") Long id, String remark, @CurrentUser() UserToken userToken) {
		projectService.pause(id, remark, userToken.getUser());
	}

	/**
	 * 关闭、结束项目
	 * 
	 * @param id
	 * @param remark
	 * @param userToken
	 */
	@RequestMapping(value = "/{id}/close", method = RequestMethod.POST)
	public void close(@PathVariable("id") Long id, String remark, @CurrentUser() UserToken userToken) {
		projectService.close(id, remark, userToken.getUser());
	}

	/**
	 * 项目任务列表
	 * 
	 * @param projectId
	 * @param task
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
	public Page<TaskDto> tasks(@PathVariable("id") Long projectId, Task task, Pageable pageable) {
		Page<Task> tasks = taskService.findByProject(projectId, task, pageable);

		Type type = new TypeToken<List<TaskDto>>() {
		}.getType();
		return ModelMapperUtils.map(tasks, type, pageable);
	}

	/**
	 * 项目版本、构建列表
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "/{id}/builds", method = RequestMethod.GET)
	public List<BuildDto> builds(@PathVariable("id") Long projectId) {
		List<Build> builds = buildService.findByProjectId(projectId);

		Type type = new TypeToken<List<BuildDto>>() {
		}.getType();
		return ModelMapperUtils.map(builds, type);
	}
}
