package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmIssueAttachment;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueAttachmentDao extends DBFacade_Sql<TmIssueAttachment, Long>{

	List<TmIssueAttachment> byIssueId(long issueId);

}
