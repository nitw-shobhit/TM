package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmIssueHistory;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.IssueHistoryDao;
import com.tm.util.db.Param;

public class IssueHistoryDaoImpl extends DBFacadeImpl_Sql<TmIssueHistory, Long> implements IssueHistoryDao {

	@Override
	public List<TmIssueHistory> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_HISTORY_BY_ISSUE_ID, params);
	}
}
