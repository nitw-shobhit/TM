package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tm.core.bean.UserBean;
import com.tm.model.service.UserService;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.exceptions.LoginValidationFailedException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmLogin")
@SessionAttributes("UserBean")
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/validateLogin")
	public ModelAndView validateLogin(@ModelAttribute("userBean") UserBean userBean) throws LoginValidationFailedException, FileLoadException, CipherException {
		UserBean userBeanRet = userService.validateLogin(userBean);
		ModelAndView mav = new ModelAndView("dashboard");
		mav.addObject("UserBean", userBeanRet);
		return mav;
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
