package com.tm.dao.bpm.impl;

import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.kie.api.runtime.KieSession;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;

import com.tm.bpm.core.BpmConfig;
import com.tm.dao.bpm.BpmDao;
import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;

public class BpmDaoImpl implements BpmDao {

	@Override
	public long createRequest(RequestType requestType, Map<String, Object> data) throws BpmException {
		UserTransaction ut = null;
		long processInstanceId = 0;
		try {
			ut = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			ut.begin();
			KieSession ksession = BpmConfig.getSingletonSession();
			BpmConfig.getTaskService();
			processInstanceId = ksession.startProcess(requestType.getId(), data).getId();
			ut.commit();
		} catch (Exception e) {
			throw new BpmException(e);
		} 
		return processInstanceId;
	}

	@Override
	public List<TaskSummary> getUserTasks(String userId) throws BpmException {
		TaskService taskService = BpmConfig.getTaskService();
		return taskService.getTasksAssignedAsPotentialOwner(userId, "en-UK");
	}
}
