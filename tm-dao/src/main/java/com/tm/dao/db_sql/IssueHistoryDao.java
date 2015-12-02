package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmIssueHistory;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueHistoryDao extends DBFacade_Sql<TmIssueHistory, Long>{

	List<TmIssueHistory> byIssueId(long issueId);

}
