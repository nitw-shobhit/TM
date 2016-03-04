package com.tm.model.service;

import java.util.List;

import com.tm.core.entity.TmModule;
import com.tm.model.bean.ui.ModuleBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface ModuleService extends DtoAssemblerFacade<TmModule, ModuleBean> {

	List<ModuleBean> getProjectModules(long projectId) throws DtoConversionException;

	ModuleBean addModuleToProject(ModuleBean moduleBean) throws DtoConversionException;

	void deleteModule(long id);

}
