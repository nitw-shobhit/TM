package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmRelease;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.ReleaseDao;
import com.tm.util.db.Param;

public class ReleaseDaoImpl extends DBFacadeImpl<TmRelease, Long> implements ReleaseDao {

	@Override
	public List<TmRelease> byModuleId(long moduleId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_MODULE_ID, moduleId);
		return findByParams(GET_RELEASES_BY_MODULE_ID, params);
	}
}
