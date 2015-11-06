package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueHistory;
import com.tm.util.db.genericdao.DBFacade;

public interface IssueHistoryDao extends DBFacade<TmIssueHistory, Long>{

	List<TmIssueHistory> byIssueId(long issueId);

}
