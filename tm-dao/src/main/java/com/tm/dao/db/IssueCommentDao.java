package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueComment;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueCommentDao extends DBFacade_Sql<TmIssueComment, Long>{

	List<TmIssueComment> byIssueId(long issueId);
}
