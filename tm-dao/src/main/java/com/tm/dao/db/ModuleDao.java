package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmModule;
import com.tm.util.db.DBFacade;

public interface ModuleDao extends DBFacade<TmModule, Long>{

	List<TmModule> byProjectId(long projectId);

}
