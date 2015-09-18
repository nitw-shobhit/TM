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
import com.tm.util.exceptions.DtoConversionException;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmProject")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getAllUserProjects")
	public @ResponseBody String getAllUserProjects(@RequestParam("id") long userId) throws InternalApplicationException {
		List<ProjectBean> projectList = null;
		try {
			projectList = projectService.getAllProjects(userId);
		} catch (DtoConversionException e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(projectList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addProject")
	public @ResponseBody String addProject(@RequestParam("projectBean") String jsonObj, @RequestParam("addDefaultModules") boolean addDefaultModules) throws InternalApplicationException {
		ProjectBean projectBean = null;
		try {
			projectBean = (ProjectBean) JsonUtils.toPojo(jsonObj, ProjectBean.class);
			projectBean = projectService.addProject(projectBean, addDefaultModules);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(projectBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/editProject")
	public @ResponseBody String editProject(@RequestParam("projectBean") String jsonObj) throws InternalApplicationException {
		ProjectBean projectBean = null;
		try {
			projectBean = (ProjectBean) JsonUtils.toPojo(jsonObj, ProjectBean.class);
			projectBean = projectService.editProject(projectBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(projectBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/disableProject")
	public @ResponseBody String disableProject(@RequestParam("id") long id) {
		projectService.disableProject(id);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/enableProject")
	public @ResponseBody String enableProject(@RequestParam("id") long id) {
		projectService.enableProject(id);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deleteProject")
	public @ResponseBody String deleteProject(@RequestParam("id") long id) {
		projectService.deleteProject(id);
		return "Success";
	}
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
