package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.bean.ModuleBean;
import com.tm.core.bean.ModuleStatus;
import com.tm.core.entity.TmModule;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.ModuleDao;
import com.tm.model.service.ModuleService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class ModuleServiceImpl extends DtoAssemblerFacadeImpl<TmModule, ModuleBean> implements ModuleService {

	@Override
	public List<ModuleBean> getProjectModules(long projectId) throws DtoConversionException {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateService(DaoType.MODULE);
		List<TmModule> moduleEntityList = moduleDao.byProjectId(projectId);
		List<ModuleBean> moduleBeanList = new ArrayList<ModuleBean>();
		for(TmModule moduleEntity : moduleEntityList) {
			moduleBeanList.add(toBean(moduleEntity));
		}
		return moduleBeanList;
	}

	@Override
	public ModuleBean addModuleToProject(ModuleBean moduleBean) throws DtoConversionException {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateService(DaoType.MODULE);
		TmModule moduleEntity = toEntity(moduleBean);
		moduleEntity.setVisible(true);
		moduleEntity.setModStatus(ModuleStatus.STARTED.toString());
		return toBean(moduleDao.persist(moduleEntity));
	}
}
