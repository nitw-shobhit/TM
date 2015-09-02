package com.tm.model.service;

import java.util.List;

import com.tm.bpm.core.beans.TaskBean;
import com.tm.util.exceptions.BpmException;

public interface BpmService {

	List<TaskBean> getUserTasks(String userId) throws BpmException;
}
