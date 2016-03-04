package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueAttachment;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface IssueAttachmentDao extends DBFacade_Sql<TmIssueAttachment, Long>{

	List<TmIssueAttachment> byIssueId(long issueId);

}
