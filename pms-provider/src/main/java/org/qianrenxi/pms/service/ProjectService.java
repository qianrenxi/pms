package org.qianrenxi.pms.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.javers.core.Javers;
import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.pms.dto.ProjectDelayInfo;
import org.qianrenxi.pms.entity.Project;
import org.qianrenxi.pms.entity.Project.ProjectStatus;
import org.qianrenxi.pms.repository.jpa.ProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

@Service
public class ProjectService extends BaseService<Project, Long, ProjectJpaRepository> {

	@Autowired
	Javers javers;

	/**
	 * 查找某个产品的所有项目
	 * 
	 * @param productId
	 * @return
	 */
	public List<Project> findAllByProduct(Long productId) {
		return repository.findByProductId(productId);
	}

	/**
	 * 启动、开始项目
	 * @param projectId
	 * @param remark
	 * @param user
	 */
	public void start(Long projectId, String remark, User user) {
		Project project = getOne(projectId);
		project.setStatus(ProjectStatus.GOING);
		save(project);

		javers.commit(user.getUsername(), project,
				ImmutableMap.of("actions", "start", "comment", StringUtils.isEmpty(remark) ? "" : remark));
	}

	/**
	 * 项目延期
	 * @param projectId
	 * @param delayInfo
	 * @param user
	 */
	public void delay(Long projectId, ProjectDelayInfo delayInfo, User user) {
		Project project = getOne(projectId);
		project.setStartDate(delayInfo.getStartDate());
		project.setEndDate(delayInfo.getEndDate());
		project.setWorkingDays(delayInfo.getWorkingDays());
		project.setStatus(ProjectStatus.DELAY);
		save(project);
		
		String remark = delayInfo.getRemark();
		javers.commit(user.getUsername(), project,
				ImmutableMap.of("actions", "start", "comment", StringUtils.isEmpty(remark) ? "" : remark));
	}

	/**
	 * 挂起、暂停项目
	 * @param projectId
	 * @param remark
	 * @param user
	 */
	public void pause(Long projectId, String remark, User user) {
		Project project = getOne(projectId);
		project.setStatus(ProjectStatus.PAUSE);
		save(project);
		
		javers.commit(user.getUsername(), project,
				ImmutableMap.of("actions", "start", "comment", StringUtils.isEmpty(remark) ? "" : remark));
	}

	/**
	 * 关闭、结束项目
	 * @param projectId
	 * @param remark
	 * @param user
	 */
	public void close(Long projectId, String remark, User user) {
		Project project = getOne(projectId);
		project.setStatus(ProjectStatus.COMPLETE);
		save(project);
		
		javers.commit(user.getUsername(), project,
				ImmutableMap.of("actions", "start", "comment", StringUtils.isEmpty(remark) ? "" : remark));
	}
}
