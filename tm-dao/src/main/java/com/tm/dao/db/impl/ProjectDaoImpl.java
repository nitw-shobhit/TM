package com.tm.dao.db.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.tm.core.entity.TmModule;
import com.tm.core.entity.TmProject;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.ModuleDao;
import com.tm.dao.db.ProjectDao;
import com.tm.util.db.Param;
import com.tm.util.exceptions.DaoException;

public class ProjectDaoImpl extends DBFacadeImpl<TmProject, Long> implements ProjectDao {

	@Override
	public List<TmProject> byUserId(Long id) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, id);
		List<TmProject> resultList = findByParams(GET_PROJECT_BY_USER, params);
		return resultList;
	}

	@Override
	public TmProject addProjectEntity(TmProject projectEntity, List<TmModule> moduleEntities) throws DaoException {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			persistNoTx(projectEntity, true);
			ModuleDao moduleDao = (ModuleDao) DaoFactory.generateService(DaoType.MODULE);
			for(TmModule moduleEntity : moduleEntities) {
				moduleEntity.setProjId(projectEntity.getId());
				moduleDao.persistNoTx(moduleEntity, true);
			}
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw new DaoException(e);
		}
		return projectEntity;
	}
}
