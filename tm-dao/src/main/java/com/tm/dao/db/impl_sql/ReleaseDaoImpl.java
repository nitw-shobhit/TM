package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmRelease;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.ReleaseDao;
import com.tm.util.db.Param;

public class ReleaseDaoImpl extends DBFacadeImpl_Sql<TmRelease, Long> implements ReleaseDao {

	@Override
	public List<TmRelease> byModuleId(long moduleId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_MODULE_ID, moduleId);
		return findByParams(GET_RELEASES_BY_MODULE_ID, params);
	}
}