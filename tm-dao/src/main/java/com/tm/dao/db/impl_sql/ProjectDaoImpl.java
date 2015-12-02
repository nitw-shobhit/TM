package com.tm.dao.db.impl_sql;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.tm.core.entity_sql.TmModule;
import com.tm.core.entity_sql.TmProject;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.ModuleDao;
import com.tm.dao.db_sql.ProjectDao;
import com.tm.util.db.Param;
import com.tm.util.exceptions.DaoException;

public class ProjectDaoImpl extends DBFacadeImpl_Sql<TmProject, Long> implements ProjectDao {

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
			ModuleDao moduleDao = (ModuleDao) DaoFactory.generateDao(DaoType.MODULE);
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
