package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.kie.api.task.model.TaskSummary;

import com.tm.bpm.core.beans.TaskBean;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.bpm.BpmDao;
import com.tm.model.service.BpmService;
import com.tm.util.exceptions.BpmException;

public class BpmServiceImpl implements BpmService {

	@Override
	public List<TaskBean> getUserTasks(String userId) throws BpmException {
		BpmDao bpmDao = (BpmDao) DaoFactory.generateService(DaoType.BPM);
		List<TaskSummary> taskEntityList = bpmDao.getUserTasks(userId);
		List<TaskBean> taskBeanList = new ArrayList<TaskBean>();
		for(TaskSummary taskSummary : taskEntityList) {
			TaskBean taskBean = new TaskBean();
			taskBean.setProcessInstanceId(taskSummary.getProcessInstanceId());
			taskBean.setProcessName(taskSummary.getProcessId());
			taskBean.setTaskCompletedOn(null);
			taskBean.setTaskCreatedBy(taskSummary.getCreatedById());
			taskBean.setTaskCreatedOn(new Timestamp(taskSummary.getCreatedOn().getTime()));
			taskBean.setTaskDescription(taskSummary.getDescription());
			taskBean.setTaskId(taskSummary.getId());
			taskBean.setTaskName(taskSummary.getName());
			taskBean.setTaskOwner(taskSummary.getActualOwnerId());
			taskBean.setTaskPriority(taskSummary.getPriority());
			taskBean.setTaskStatus(taskSummary.getStatus().toString());
			taskBeanList.add(taskBean);
		}
		
		return taskBeanList;
	}
}
