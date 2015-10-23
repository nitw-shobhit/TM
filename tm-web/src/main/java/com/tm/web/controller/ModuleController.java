package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.ui.ModuleBean;
import com.tm.model.service.ModuleService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmModule")
public class ModuleController {

	@Resource
	private ModuleService moduleService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getProjectModules")
	public @ResponseBody String getProjectModules(@RequestParam("id") long projectId) throws InternalApplicationException {
		List<ModuleBean> moduleBeanList = null;
		try {
			moduleBeanList = moduleService.getProjectModules(projectId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(moduleBeanList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addModuleToProject")
	public @ResponseBody String addModuleToProject(@RequestParam("moduleBean") String jsonObj) throws InternalApplicationException {
		ModuleBean moduleBean = null;
		try {
			moduleBean = (ModuleBean) JsonUtils.toPojo(jsonObj, ModuleBean.class);
			moduleBean = moduleService.addModuleToProject(moduleBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(moduleBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deleteModule")
	public @ResponseBody void deleteModule(@RequestParam("id") long id) throws InternalApplicationException {
		moduleService.deleteModule(id);
	}
	
	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
}
