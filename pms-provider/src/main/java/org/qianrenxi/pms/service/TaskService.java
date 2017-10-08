package org.qianrenxi.pms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.javers.core.Javers;
import org.javers.core.changelog.SimpleTextChangeLog;
import org.javers.core.diff.Change;
import org.javers.repository.jql.QueryBuilder;
import org.qianrenxi.core.common.service.BaseService;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.pms.dto.TaskOperateInfo;
import org.qianrenxi.pms.entity.Task;
import org.qianrenxi.pms.entity.Task.TaskStatus;
import org.qianrenxi.pms.repository.jpa.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;

@Service
public class TaskService extends BaseService<Task, Long, TaskJpaRepository> {

	@Autowired
	Javers javers;
	
	// 执行创建
	private Task processCreate(Task task, User user){
		task.setStatus(TaskStatus.INITIAL);
		return save(task);
	}
	
	// 执行更新
	private Task processUpdate(Task task, User user){
		return save(task);
	}
	
	
	/**
	 * 创建
	 * 
	 * @param task
	 * @param user
	 * @return
	 */
	public Task create(Task task, User user) {
		task = processCreate(task, user);
		
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", ""));
		
		return task;
	}

	/**
	 * 更新
	 * 
	 * @param task
	 * @param user
	 * @return
	 */
	public Task update(Task task, User user, String remark) {
		task = processUpdate(task, user);
		
		remark = StringUtils.isEmpty(remark) ? "" : remark;
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
		
		return task;
	}

	/**
	 * 激活
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void active(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setAssignedTo(new User(operateInfo.getAssignedToId()));
		task.setLeftTime(operateInfo.getLeftTime());
		task.setStatus(TaskStatus.GOING);

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 指派
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void assign(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setAssignedTo(new User(operateInfo.getAssignedToId()));
		task.setLeftTime(operateInfo.getLeftTime());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 取消
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void cancel(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.CANCELED);
		task.setCanceledBy(user);
		task.setCanceledDate(new Date());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 关闭
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void close(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.CLOSED);
		task.setClosedBy(user);
		task.setCanceledDate(new Date());
		task.setCloseReason(operateInfo.getClosedReason());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 完成
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void complete(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.COMPLETED);
		task.setUsedTime(operateInfo.getUsedTime());
		task.setAssignedTo(new User(operateInfo.getAssignedToId()));
		task.setCompletedBy(new User(operateInfo.getCompletedById()));
		task.setCompletedDate(operateInfo.getCompletedDate());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 暂停、挂起
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void pause(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.PAUSED);

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 继续
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void restart(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.GOING);
		task.setActsureStarted(operateInfo.getActsureStarted());
		task.setUsedTime(operateInfo.getUsedTime());
		task.setLeftTime(operateInfo.getLeftTime());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 开始
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void start(Long taskId, TaskOperateInfo operateInfo, User user) {
		Task task = getOne(taskId);
		task.setStatus(TaskStatus.GOING);
		task.setActsureStarted(operateInfo.getActsureStarted());
		task.setUsedTime(operateInfo.getUsedTime());
		task.setLeftTime(operateInfo.getLeftTime());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 备注、讨论
	 * 
	 * @param taskId
	 * @param operateInfo
	 * @param user
	 */
	public void remark(Long taskId, TaskOperateInfo operateInfo, User user) {
		if (StringUtils.isEmpty(operateInfo.getRemark())) {
			return;
		}

		Task task = getOne(taskId);
		task.setLastModifiedBy(user);
		task.setLastModifiedDate(new Date());

		save(task);

		String remark = StringUtils.isEmpty(operateInfo.getRemark()) ? "" : operateInfo.getRemark();
		javers.commit(user.getUsername(), task, ImmutableMap.of("actions", "", "comment", remark));
	}

	/**
	 * 按项目查找任务
	 * 
	 * @param projectId
	 * @param task
	 * @param pageable
	 * @return
	 */
	public Page<Task> findByProject(Long projectId, Task task, Pageable pageable) {
		Specifications<Task> specifications = Specifications.where(TaskSpecification.getBaseSpecification(task))
				.and(TaskSpecification.getProjectSpecification(projectId));

		return repository.findAll(specifications, pageable);
	}

	/**
	 * 同项目上一条
	 * @param projectId
	 * @param taskId
	 * @return
	 */
	public Task findPrev(Long projectId, Long taskId) {
		return repository.findPrev(taskId, projectId);
	}

	/**
	 * 同项目下一条
	 * @param projectId
	 * @param taskId
	 * @return
	 */
	public Task findNext(Long projectId, Long taskId) {
		return repository.findPrev(taskId, projectId);
	}

	/**
	 * 同一项目下临近的（上一条、下一条）任务
	 * @param taskId
	 * @return
	 */
	public Map<String, Task> findNear(Long taskId) {
		Task self = getOne(taskId);
		if (null != self && null != self.getProject()) {
			Long projectId = self.getProject().getId();
			Task prev = findPrev(projectId, taskId);
			Task next = findNext(projectId, taskId);

			Map<String, Task> near = new HashMap<>();
			near.put("prev", prev);
			near.put("next", next);

			return near;
		}
		return ImmutableMap.of();

	}
	
	/**
	 * 更新日志
	 * 
	 * @param id
	 * @return
	 */
	public String changeLog(Long id) {
		List<Change> changes = javers.findChanges(QueryBuilder.byInstanceId(id, Task.class).build());
		String changeLog = javers.processChangeList(changes, new SimpleTextChangeLog());
		return changeLog;
	}
}
