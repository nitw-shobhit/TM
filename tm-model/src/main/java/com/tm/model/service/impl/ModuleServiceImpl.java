package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.entity_sql.TmModule;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.ModuleDao;
import com.tm.model.bean.ui.ModuleBean;
import com.tm.model.bean.ui.ModuleStatus;
import com.tm.model.service.ModuleService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class ModuleServiceImpl extends DtoAssemblerFacadeImpl<TmModule, ModuleBean> implements ModuleService {

	@Override
	public List<ModuleBean> getProjectModules(long projectId) throws DtoConversionException {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateDao(DaoType.MODULE);
		List<TmModule> moduleEntityList = moduleDao.byProjectId(projectId);
		List<ModuleBean> moduleBeanList = new ArrayList<ModuleBean>();
		for(TmModule moduleEntity : moduleEntityList) {
			moduleBeanList.add(toBean(moduleEntity));
		}
		return moduleBeanList;
	}

	@Override
	public ModuleBean addModuleToProject(ModuleBean moduleBean) throws DtoConversionException {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateDao(DaoType.MODULE);
		TmModule moduleEntity = toEntity(moduleBean);
		moduleEntity.setModStatus(ModuleStatus.STARTED.toString());
		return toBean(moduleDao.persist(moduleEntity, true));
	}

	@Override
	public void deleteModule(long id) {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateDao(DaoType.MODULE);
		TmModule moduleEntity = moduleDao.findByPk(id);
		moduleDao.remove(moduleEntity);
	}
}
