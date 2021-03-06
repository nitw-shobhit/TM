package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmModule;
import com.tm.core.entity.TmProject;
import com.tm.util.db.genericdao.DBFacade_Sql;
import com.tm.util.exceptions.DaoException;

public interface ProjectDao extends DBFacade_Sql<TmProject, Long>{

	List<TmProject> byUserId(Long id);

	TmProject addProjectEntity(TmProject projectEntity, List<TmModule> createDefaultModuleEntities) throws DaoException;
}
