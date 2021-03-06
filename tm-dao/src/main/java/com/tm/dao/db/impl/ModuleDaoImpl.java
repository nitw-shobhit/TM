package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmModule;
import com.tm.core.genericdao.impl.DBFacadeImpl_Sql;
import com.tm.dao.db.ModuleDao;
import com.tm.util.db.Param;

public class ModuleDaoImpl extends DBFacadeImpl_Sql<TmModule, Long> implements ModuleDao {

	@Override
	public List<TmModule> byProjectId(long projectId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_PROJ_ID, projectId);
		return findByParams(GET_MODULES_BY_PROJ_ID, params);
	}

}
