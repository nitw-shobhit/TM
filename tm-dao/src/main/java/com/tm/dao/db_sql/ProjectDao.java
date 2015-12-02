package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmModule;
import com.tm.core.entity_sql.TmProject;
import com.tm.util.db.genericdao.DBFacade_Sql;
import com.tm.util.exceptions.DaoException;

public interface ProjectDao extends DBFacade_Sql<TmProject, Long>{

	List<TmProject> byUserId(Long id);

	TmProject addProjectEntity(TmProject projectEntity, List<TmModule> createDefaultModuleEntities) throws DaoException;
}
