package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmIssueComment;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.IssueCommentDao;
import com.tm.util.db.Param;

public class IssueCommentDaoImpl extends DBFacadeImpl_Sql<TmIssueComment, Long> implements IssueCommentDao {

	@Override
	public List<TmIssueComment> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_COMMENTS_BY_ISSUE_ID, params);
	}

}
