package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueSubscribe;
import com.tm.util.db.DBFacade;

public interface IssueSubscribeDao extends DBFacade<TmIssueSubscribe, Long>{

	List<TmIssueSubscribe> byIssueId(long issueId);
}
