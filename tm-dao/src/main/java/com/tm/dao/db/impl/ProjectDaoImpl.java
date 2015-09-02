package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmProject;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.ProjectDao;
import com.tm.util.db.Param;

public class ProjectDaoImpl extends DBFacadeImpl<TmProject, Long> implements ProjectDao {

	@Override
	public List<TmProject> getProjectsByUserId(Long id) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, id);
		List<TmProject> resultList = findByParams(GET_PROJECT_BY_USER, params);
		return resultList;
	}
}
