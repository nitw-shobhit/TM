package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.ProjectBean;
import com.tm.model.service.ProjectService;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.exceptions.LoginValidationFailedException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmProject")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getAllUserProjects")
	public @ResponseBody String getAllUserProjects(@RequestParam("id") long userId) throws LoginValidationFailedException, FileLoadException, CipherException {
		List<ProjectBean> projectList = projectService.getAllProjects(userId);
		return JsonUtils.toJson(projectList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addProject")
	public @ResponseBody String addProject(@RequestParam("projectBean") String jsonObj) throws LoginValidationFailedException, FileLoadException, CipherException, InternalApplicationException {
		ProjectBean projectBean = null;
		try {
			projectBean = (ProjectBean) JsonUtils.toPojo(jsonObj, ProjectBean.class);
			projectBean = projectService.addProject(projectBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(projectBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/disableProject")
	public @ResponseBody String disableProject(@RequestParam("id") long id) throws LoginValidationFailedException, FileLoadException, CipherException {
		projectService.disableProject(id);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deleteProject")
	public @ResponseBody String deleteProject(@RequestParam("id") long id) throws LoginValidationFailedException, FileLoadException, CipherException {
		projectService.deleteProject(id);
		return null;
	}
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
