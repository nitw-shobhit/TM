package com.tm.dao.bpm;

import java.util.List;
import java.util.Map;

import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;

import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;

public interface BpmDao {

	long createRequest(RequestType requestType, Map<String, Object> data) throws BpmException;
	
	List<TaskSummary> getUserTasks(String userId) throws BpmException;
	
	Task getTaskById(long taskId) throws BpmException;
	
	ProcessInstance getProcessInstanceById(long processInstanceId) throws BpmException;
}
