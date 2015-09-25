package com.tm.dao;

import com.tm.dao.db.impl.IssueAttachmentDaoImpl;
import com.tm.dao.db.impl.IssueCommentDaoImpl;
import com.tm.dao.db.impl.IssueDaoImpl;
import com.tm.dao.db.impl.IssueHistoryDaoImpl;
import com.tm.dao.db.impl.ModuleDaoImpl;
import com.tm.dao.db.impl.ProjectDaoImpl;
import com.tm.dao.db.impl.UserDaoImpl;
import com.tm.dao.db.impl.UserProjectDaoImpl;

public class DaoFactory {
	
	
	private DaoFactory() {
	}
	
	private static class DaoFactoryHelper {
		private static final UserDaoImpl userDaoImpl = new UserDaoImpl();
		private static final ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
		private static final UserProjectDaoImpl userProjectDaoImpl = new UserProjectDaoImpl();
		private static final ModuleDaoImpl moduleDaoImpl = new ModuleDaoImpl();
		private static final IssueDaoImpl issueDaoImpl = new IssueDaoImpl();
		private static final IssueCommentDaoImpl issueCommentDaoImpl = new IssueCommentDaoImpl();
		private static final IssueAttachmentDaoImpl issueAttachmentDaoImpl = new IssueAttachmentDaoImpl();
		private static final IssueHistoryDaoImpl issueHistoryDaoImpl = new IssueHistoryDaoImpl();
	}
	
	public static Object generateService(DaoType dType) {
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
		} else {
			return null;
		}
	}
}
