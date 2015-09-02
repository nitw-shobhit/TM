package com.tm.dao.bpm;

import java.util.List;
import java.util.Map;

import org.kie.api.task.model.TaskSummary;

import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;

public interface BpmDao {

	long createRequest(RequestType requestType, Map<String, Object> data) throws BpmException;
	
	List<TaskSummary> getUserTasks(String userId) throws BpmException;
}
