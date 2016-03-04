package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueHistory;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueHistoryDao extends DBFacade_Sql<TmIssueHistory, Long>{

	List<TmIssueHistory> byIssueId(long issueId);

}
