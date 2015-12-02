package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmModule;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface ModuleDao extends DBFacade_Sql<TmModule, Long>{

	List<TmModule> byProjectId(long projectId);

}
