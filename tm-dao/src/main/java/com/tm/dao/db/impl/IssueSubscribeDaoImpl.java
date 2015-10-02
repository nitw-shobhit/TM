package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmIssueSubscribe;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.IssueSubscribeDao;
import com.tm.util.db.Param;

public class IssueSubscribeDaoImpl extends DBFacadeImpl<TmIssueSubscribe, Long> implements IssueSubscribeDao {

	@Override
	public List<TmIssueSubscribe> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_SUBSCRIBER_BY_ISSUE_ID, params);
	}
}
