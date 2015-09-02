package com.tm.model.service;

import com.tm.bpm.core.BpmConfig;
import com.tm.model.service.impl.UserServiceImpl;
import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;

public class StartupService {

	public void init() throws BpmException {
        UserService userService = new UserServiceImpl();
        BpmConfig.singletonRuntimeManager(RequestType.getValues(), userService.getUserGroups());
        BpmConfig.getSingletonSession();
        BpmConfig.getTaskService();
	}
}
