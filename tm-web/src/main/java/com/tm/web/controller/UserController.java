package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.UserBean;
import com.tm.model.service.UserService;
import com.tm.util.cipher.CipherUtils;
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
	public @ResponseBody String changePassword(@RequestParam("password") String password) throws InternalApplicationException {
		String encryptedPassword = null;
		try {
			encryptedPassword = CipherUtils.encrypt(password);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return encryptedPassword;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
