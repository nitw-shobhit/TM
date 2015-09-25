package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmIssue;
import com.tm.core.entity.TmIssueAttachment;
import com.tm.core.entity.TmIssueComment;
import com.tm.core.entity.TmIssueHistory;
import com.tm.util.db.DBFacade;
import com.tm.util.exceptions.DaoException;

public interface IssueDao extends DBFacade<TmIssue, Long>{

	List<TmIssue> byModuleId(long moduleId);

	TmIssue addIssueToModule(TmIssue issueEntity, TmIssueComment issueCommentEntity,
			List<TmIssueAttachment> issAttachmentEntities, TmIssueHistory issueHistoryEntity) throws DaoException;

	TmIssueHistory updateIssueStatus(TmIssue issueEntity, TmIssueHistory issueHistoryEntity) throws DaoException;

}
