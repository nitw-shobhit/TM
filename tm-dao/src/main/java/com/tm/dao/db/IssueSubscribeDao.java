package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueSubscribe;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueSubscribeDao extends DBFacade_Sql<TmIssueSubscribe, Long>{

	List<TmIssueSubscribe> byIssueId(long issueId);
}
