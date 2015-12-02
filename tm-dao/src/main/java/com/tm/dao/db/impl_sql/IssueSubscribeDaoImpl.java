package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmIssueSubscribe;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.IssueSubscribeDao;
import com.tm.util.db.Param;

public class IssueSubscribeDaoImpl extends DBFacadeImpl_Sql<TmIssueSubscribe, Long> implements IssueSubscribeDao {

	@Override
	public List<TmIssueSubscribe> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_SUBSCRIBER_BY_ISSUE_ID, params);
	}
}
