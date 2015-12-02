package com.tm.dao.db.impl_sql;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.tm.core.entity_sql.TmIssue;
import com.tm.core.entity_sql.TmIssueAttachment;
import com.tm.core.entity_sql.TmIssueComment;
import com.tm.core.entity_sql.TmIssueHistory;
import com.tm.core.entity_sql.TmIssueSubscribe;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.IssueAttachmentDao;
import com.tm.dao.db_sql.IssueCommentDao;
import com.tm.dao.db_sql.IssueDao;
import com.tm.dao.db_sql.IssueHistoryDao;
import com.tm.dao.db_sql.IssueSubscribeDao;
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
