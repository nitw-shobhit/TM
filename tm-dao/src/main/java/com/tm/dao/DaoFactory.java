package com.tm.dao;

import com.tm.dao.db.CalendarDao;
import com.tm.dao.db.IssueAttachmentDao;
import com.tm.dao.db.IssueCommentDao;
import com.tm.dao.db.IssueDao;
import com.tm.dao.db.IssueHistoryDao;
import com.tm.dao.db.IssueSubscribeDao;
import com.tm.dao.db.LoggerDao;
import com.tm.dao.db.ModuleDao;
import com.tm.dao.db.NotificationDao;
import com.tm.dao.db.NotificationVariableDao;
import com.tm.dao.db.ProjectDao;
import com.tm.dao.db.ReleaseDao;
import com.tm.dao.db.UserDao;
import com.tm.dao.db.UserProjectDao;
import com.tm.dao.db.impl.AuditDaoImpl;
import com.tm.dao.db.impl.CalendarDaoImpl;
import com.tm.dao.db.impl.IssueAttachmentDaoImpl;
import com.tm.dao.db.impl.IssueCommentDaoImpl;
import com.tm.dao.db.impl.IssueDaoImpl;
import com.tm.dao.db.impl.IssueHistoryDaoImpl;
import com.tm.dao.db.impl.IssueSubscribeDaoImpl;
import com.tm.dao.db.impl.LoggerDaoImpl;
import com.tm.dao.db.impl.ModuleDaoImpl;
import com.tm.dao.db.impl.NotificationDaoImpl;
import com.tm.dao.db.impl.NotificationVariableDaoImpl;
import com.tm.dao.db.impl.ProjectDaoImpl;
import com.tm.dao.db.impl.ReleaseDaoImpl;
import com.tm.dao.db.impl.UserDaoImpl;
import com.tm.dao.db.impl.UserProjectDaoImpl;

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
		private static final CalendarDao calendarDaoImpl = new CalendarDaoImpl();
		
		private static final LoggerDao loggerDaoImpl = new LoggerDaoImpl();
		private static final AuditDaoImpl auditDaoImpl = new AuditDaoImpl();
	}
	
	public static Object generateDao(DaoType dType) {
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
		} else if(dType.equals(DaoType.LOGGER)) {
			return DaoFactoryHelper.loggerDaoImpl;
		} else if(dType.equals(DaoType.AUDIT)) {
			return DaoFactoryHelper.auditDaoImpl;
		} else if(dType.equals(DaoType.CALENDAR)) {
			return DaoFactoryHelper.calendarDaoImpl;
		} else {
			return null;
		}
	}
}
