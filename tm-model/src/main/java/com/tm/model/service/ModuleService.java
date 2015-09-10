package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.ModuleBean;
import com.tm.util.exceptions.DtoConversionException;

public interface ModuleService {

	List<ModuleBean> getProjectModules(long projectId) throws DtoConversionException;

	ModuleBean addModuleToProject(ModuleBean moduleBean) throws DtoConversionException;

}
