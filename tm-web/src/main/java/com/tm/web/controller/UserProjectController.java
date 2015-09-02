package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.UserBean;
import com.tm.model.service.UserProjectService;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.LoginValidationFailedException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmUserProject")
public class UserProjectController {

	@Resource
	private UserProjectService userProjectService;

	@RequestMapping(method = RequestMethod.GET, value="/getProjectTeam")
	public @ResponseBody String getProjectTeam(@RequestParam("id") long projectId) throws LoginValidationFailedException, FileLoadException, CipherException {
		List<UserBean> userList = userProjectService.getProjectTeam(projectId);
		return JsonUtils.toJson(userList);
	}
	
	public UserProjectService getUserProjectService() {
		return userProjectService;
	}

	public void setUserProjectService(UserProjectService userProjectService) {
		this.userProjectService = userProjectService;
	}
}
