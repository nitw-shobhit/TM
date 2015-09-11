package com.tm.model.init.service;

import javax.annotation.Resource;

import com.tm.model.service.UserService;

public class StartupService {

	@Resource
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void init() {
	}
}
