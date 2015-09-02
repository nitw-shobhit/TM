package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.UserBean;
import com.tm.model.service.UserService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmUser")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/updateUserProfile")
	public @ResponseBody String updateUserProfile(@RequestParam("userBean") String jsonObj) throws InternalApplicationException {
		UserBean userBean = null;
		try {
			userBean = (UserBean) JsonUtils.toPojo(jsonObj, UserBean.class);
			userService.updateUserProfile(userBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(userBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/changePassword")
	public @ResponseBody String changePassword(@RequestParam("password") String password, @RequestParam("id") long userId) throws InternalApplicationException {
		String updatedPassword = null;
		try {
			updatedPassword = userService.changePassword(userId, password);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return updatedPassword;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/requestAdminPrivilege")
	public @ResponseBody String requestAdminPrivilege(@RequestParam("id") long userId) throws InternalApplicationException {
		String requestId = null;
		try {
			requestId = userService.requestAdminPrivilege(userId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return requestId;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/searchUser")
	public @ResponseBody String searchUser(@RequestParam("query") String query) {
		List<UserBean> userBeans = userService.searchUsers(query);
		return JsonUtils.toJson(userBeans);
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
