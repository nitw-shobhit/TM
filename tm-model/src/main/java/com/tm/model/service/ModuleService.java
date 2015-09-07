package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.ModuleBean;

public interface ModuleService {

	List<ModuleBean> getProjectModules(long projectId);

	ModuleBean addModuleToProject(ModuleBean moduleBean);

}
