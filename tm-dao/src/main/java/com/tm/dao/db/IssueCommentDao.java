package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueComment;
import com.tm.util.db.genericdao.DBFacade;

public interface IssueCommentDao extends DBFacade<TmIssueComment, Long>{

	List<TmIssueComment> byIssueId(long issueId);
}
