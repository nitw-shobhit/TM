package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tm.model.service.ModuleService;

@Controller
@RequestMapping("/tmModule")
public class ModuleController {

	@Resource
	private ModuleService moduleService;

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
}
