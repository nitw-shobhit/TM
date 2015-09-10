package com.tm.model.init.service;

import javax.annotation.Resource;

import com.tm.bpm.core.BpmConfig;
import com.tm.model.service.UserService;
import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;

public class StartupService {

	@Resource
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void init() throws BpmException {
        BpmConfig.singletonRuntimeManager(RequestType.getValues(), userService.getUserGroups());
        BpmConfig.getSingletonSession();
        BpmConfig.getTaskService();
	}
}
