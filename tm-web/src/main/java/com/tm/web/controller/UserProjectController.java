package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.ui.UserBean;
import com.tm.model.service.UserProjectService;
import com.tm.util.exceptions.DtoConversionException;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmUserProject")
public class UserProjectController {

	@Resource
	private UserProjectService userProjectService;

	@RequestMapping(method = RequestMethod.GET, value="/getProjectTeam")
	public @ResponseBody String getProjectTeam(@RequestParam("id") long projectId) throws InternalApplicationException {
		List<UserBean> userList = null;
		try {
			userList = userProjectService.getProjectTeam(projectId);
		} catch (DtoConversionException e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(userList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addUserToProject")
	public @ResponseBody String addUserToProject(@RequestParam("userId") long userId, @RequestParam("projectId") long projectId) {
		userProjectService.addUserToProject(userId, projectId);
		return "";
	}
	
	public UserProjectService getUserProjectService() {
		return userProjectService;
	}

	public void setUserProjectService(UserProjectService userProjectService) {
		this.userProjectService = userProjectService;
	}
}
