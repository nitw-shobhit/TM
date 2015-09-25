package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmIssueHistory;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.IssueHistoryDao;
import com.tm.util.db.Param;

public class IssueHistoryDaoImpl extends DBFacadeImpl<TmIssueHistory, Long> implements IssueHistoryDao {

	@Override
	public List<TmIssueHistory> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_HISTORY_BY_ISSUE_ID, params);
	}
}
