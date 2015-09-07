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

public class ModuleServiceImpl implements ModuleService {

	@Override
	public List<ModuleBean> getProjectModules(long projectId) {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateService(DaoType.MODULE);
		List<TmModule> moduleEntityList = moduleDao.getModulesByProjectId(projectId);
		List<ModuleBean> moduleBeanList = new ArrayList<ModuleBean>();
		for(TmModule moduleEntity : moduleEntityList) {
			moduleBeanList.add(moduleEntity.toBean());
		}
		return moduleBeanList;
	}

	@Override
	public ModuleBean addModuleToProject(ModuleBean moduleBean) {
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateService(DaoType.MODULE);
		TmModule moduleEntity = moduleBean.toEntity();
		moduleEntity.setVisible(true);
		moduleEntity.setModStatus(ModuleStatus.STARTED.toString());
		return moduleDao.persist(moduleEntity).toBean();
	}
}
