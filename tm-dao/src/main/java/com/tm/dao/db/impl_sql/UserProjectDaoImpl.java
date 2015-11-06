package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity.TmUserProject;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db.UserProjectDao;
import com.tm.util.db.Param;

public class UserProjectDaoImpl extends DBFacadeImpl_Sql<TmUserProject, Long> implements UserProjectDao {

	@Override
	public List<TmUserProject> byProjectId(long projectId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_PROJ_ID, projectId);
		List<TmUserProject> resultList = findByParams(GET_USERPROJ_BY_PROJ_ID, params);
		return resultList;
	}
}
