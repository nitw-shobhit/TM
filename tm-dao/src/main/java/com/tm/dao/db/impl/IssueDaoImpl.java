package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmIssue;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.IssueDao;
import com.tm.util.db.Param;

public class IssueDaoImpl extends DBFacadeImpl<TmIssue, Long> implements IssueDao {

	@Override
	public List<TmIssue> byModuleId(long moduleId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_MODULE_ID, moduleId);
		return findByParams(GET_ISSUES_BY_MODULE_ID, params);
	}
}
