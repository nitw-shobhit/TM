package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.UserBean;
import com.tm.model.service.UserService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.exceptions.LoginValidationFailedException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmLogin")
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value="/validateLogin")
	public @ResponseBody String validateLogin(@RequestParam("userBean") String jsonObj) throws LoginValidationFailedException, InternalApplicationException {
		UserBean userBean = null;
		UserBean userBeanRet = null;
		try {
			userBean = (UserBean) JsonUtils.toPojo(jsonObj, UserBean.class);
			userBeanRet = userService.validateLogin(userBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(userBeanRet);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getUserDetails")
	public @ResponseBody String getUserDetails(@ModelAttribute("UserBean") UserBean userBean) throws InternalApplicationException {
		return JsonUtils.toJson(userBean);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
