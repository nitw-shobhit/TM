package com.tm.web.controller;

import com.tm.model.bean.ui.UserBean;

public class BaseController {

	public static UserBean getLoggedInUser() {
		return new UserBean();
	}
	
	public static String getLoggedInUserIpAddress() {
		return null;
	}
}
