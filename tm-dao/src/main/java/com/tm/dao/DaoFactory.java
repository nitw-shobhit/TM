package com.tm.dao;

import com.tm.dao.db.IssueAttachmentDao;
import com.tm.dao.db.IssueCommentDao;
import com.tm.dao.db.IssueDao;
import com.tm.dao.db.IssueHistoryDao;
import com.tm.dao.db.IssueSubscribeDao;
import com.tm.dao.db.ModuleDao;
import com.tm.dao.db.NotificationDao;
import com.tm.dao.db.NotificationVariableDao;
import com.tm.dao.db.ProjectDao;
import com.tm.dao.db.ReleaseDao;
import com.tm.dao.db.UserDao;
import com.tm.dao.db.UserProjectDao;
import com.tm.dao.db.impl_sql.IssueAttachmentDaoImpl;
import com.tm.dao.db.impl_sql.IssueCommentDaoImpl;
import com.tm.dao.db.impl_sql.IssueDaoImpl;
import com.tm.dao.db.impl_sql.IssueHistoryDaoImpl;
import com.tm.dao.db.impl_sql.IssueSubscribeDaoImpl;
import com.tm.dao.db.impl_sql.ModuleDaoImpl;
import com.tm.dao.db.impl_sql.NotificationDaoImpl;
import com.tm.dao.db.impl_sql.NotificationVariableDaoImpl;
import com.tm.dao.db.impl_sql.ProjectDaoImpl;
import com.tm.dao.db.impl_sql.ReleaseDaoImpl;
import com.tm.dao.db.impl_sql.UserDaoImpl;
import com.tm.dao.db.impl_sql.UserProjectDaoImpl;
import com.tm.util.db.genericdao.DBFacade;

public class DaoFactory {
	
	
	private DaoFactory() {
	}
	
	private static class DaoFactoryHelper {
		private static final UserDao userDaoImpl = new UserDaoImpl();
		private static final ProjectDao projectDaoImpl = new ProjectDaoImpl();
		private static final UserProjectDao userProjectDaoImpl = new UserProjectDaoImpl();
		private static final ModuleDao moduleDaoImpl = new ModuleDaoImpl();
		private static final IssueDao issueDaoImpl = new IssueDaoImpl();
		private static final IssueCommentDao issueCommentDaoImpl = new IssueCommentDaoImpl();
		private static final IssueAttachmentDao issueAttachmentDaoImpl = new IssueAttachmentDaoImpl();
		private static final IssueHistoryDao issueHistoryDaoImpl = new IssueHistoryDaoImpl();
		private static final IssueSubscribeDao issueSubscribeDaoImpl = new IssueSubscribeDaoImpl();
		private static final NotificationDao notificationDaoImpl = new NotificationDaoImpl();
		private static final NotificationVariableDao notificationVariableDaoImpl = new NotificationVariableDaoImpl();
		private static final ReleaseDao releaseDaoImpl = new ReleaseDaoImpl();
	}
	
	public static DBFacade<?, ?> generateDao(DaoType dType) {
		if(dType.equals(DaoType.USER)) {
			return DaoFactoryHelper.userDaoImpl;
		} else if(dType.equals(DaoType.PROJECT)) {
			return DaoFactoryHelper.projectDaoImpl;
		} else if(dType.equals(DaoType.USER_PROJECT)) {
			return DaoFactoryHelper.userProjectDaoImpl;
		} else if(dType.equals(DaoType.MODULE)) {
			return DaoFactoryHelper.moduleDaoImpl;
		} else if(dType.equals(DaoType.ISSUE)) {
			return DaoFactoryHelper.issueDaoImpl;
		} else if(dType.equals(DaoType.ISSUE_COMMENT)) {
			return DaoFactoryHelper.issueCommentDaoImpl;
		} else if(dType.equals(DaoType.ISSUE_ATTACHMENT)) {
			return DaoFactoryHelper.issueAttachmentDaoImpl;
		} else if(dType.equals(DaoType.ISSUE_HISTORY)) {
			return DaoFactoryHelper.issueHistoryDaoImpl;
		} else if(dType.equals(DaoType.ISSUE_SUBSCRIBE)) {
			return DaoFactoryHelper.issueSubscribeDaoImpl;
		} else if(dType.equals(DaoType.NOTIFICATION)) {
			return DaoFactoryHelper.notificationDaoImpl;
		} else if(dType.equals(DaoType.NOTIFICATION_VARIABLE)) {
			return DaoFactoryHelper.notificationVariableDaoImpl;
		} else if(dType.equals(DaoType.RELEASE)) {
			return DaoFactoryHelper.releaseDaoImpl;
		} else {
			return null;
		}
	}
}
