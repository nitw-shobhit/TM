package com.tm.dao.db.impl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.tm.core.entity.TmIssue;
import com.tm.core.entity.TmIssueAttachment;
import com.tm.core.entity.TmIssueComment;
import com.tm.core.entity.TmIssueHistory;
import com.tm.core.entity.TmIssueSubscribe;
import com.tm.core.genericdao.impl.DBFacadeImpl_Sql;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueAttachmentDao;
import com.tm.dao.db.IssueCommentDao;
import com.tm.dao.db.IssueDao;
import com.tm.dao.db.IssueHistoryDao;
import com.tm.dao.db.IssueSubscribeDao;
import com.tm.util.db.Param;
import com.tm.util.exceptions.DaoException;

public class IssueDaoImpl extends DBFacadeImpl_Sql<TmIssue, Long> implements IssueDao {

	@Override
	public List<TmIssue> byModuleId(long moduleId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_MODULE_ID, moduleId);
		return findByParams(GET_ISSUES_BY_MODULE_ID, params);
	}

	@Override
	public TmIssue addIssueToModule(TmIssue issueEntity, TmIssueComment issueCommentEntity,
			List<TmIssueAttachment> issueAttachmentEntities, TmIssueHistory issueHistoryEntity,
			List<TmIssueSubscribe> issueSubscribeEntities) throws DaoException {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			persistNoTx(issueEntity, true);
			if(issueCommentEntity != null) {
				issueCommentEntity.setIssId(issueEntity.getId());
				IssueCommentDao issueCommentDao = (IssueCommentDao) DaoFactory.generateDao(DaoType.ISSUE_COMMENT);
				issueCommentDao.persistNoTx(issueCommentEntity, true);
			}
			
			if(issueAttachmentEntities != null) {
				for(TmIssueAttachment issueAttachmentEntity : issueAttachmentEntities) {
					issueAttachmentEntity.setIssId(issueEntity.getId());
					IssueAttachmentDao issueAttachmentDao = (IssueAttachmentDao) DaoFactory.generateDao(DaoType.ISSUE_ATTACHMENT);
					issueAttachmentDao.persistNoTx(issueAttachmentEntity, true);
				}
			}
			
			if(issueSubscribeEntities != null) {
				for(TmIssueSubscribe issueSubscribeEntity : issueSubscribeEntities) {
					issueSubscribeEntity.setIssId(issueEntity.getId());
					IssueSubscribeDao issueSubscribeDao = (IssueSubscribeDao) DaoFactory.generateDao(DaoType.ISSUE_SUBSCRIBE);
					issueSubscribeDao.persistNoTx(issueSubscribeEntity, false);
				}
			}
			issueHistoryEntity.setIssId(issueEntity.getId());
			IssueHistoryDao issueHistoryDao = (IssueHistoryDao) DaoFactory.generateDao(DaoType.ISSUE_HISTORY);
			issueHistoryDao.persistNoTx(issueHistoryEntity, false);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw new DaoException(e);
		}
		return issueEntity;
	}

	@Override
	public TmIssueHistory updateIssueStatus(TmIssue issueEntity, TmIssueHistory issueHistoryEntity) throws DaoException {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			mergeNoTx(issueEntity, true);
			IssueHistoryDao issueHistoryDao = (IssueHistoryDao) DaoFactory.generateDao(DaoType.ISSUE_HISTORY);
			issueHistoryDao.persistNoTx(issueHistoryEntity, false);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw new DaoException(e);
		}
		
		return issueHistoryEntity;
	}
}
