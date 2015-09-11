package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssueAttachment;
import com.tm.util.db.DBFacade;

public interface IssueAttachmentDao extends DBFacade<TmIssueAttachment, Long>{

	List<TmIssueAttachment> byIssueId(long issueId);

}
