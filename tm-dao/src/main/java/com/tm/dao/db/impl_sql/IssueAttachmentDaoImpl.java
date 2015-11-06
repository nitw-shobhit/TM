package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity.TmIssueAttachment;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db.IssueAttachmentDao;
import com.tm.util.db.Param;

public class IssueAttachmentDaoImpl extends DBFacadeImpl_Sql<TmIssueAttachment, Long> implements IssueAttachmentDao {

	@Override
	public List<TmIssueAttachment> byIssueId(long issueId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_ISSUE_ID, issueId);
		return findByParams(GET_ATTACHMENTS_BY_ISSUE_ID, params);
	}

}
