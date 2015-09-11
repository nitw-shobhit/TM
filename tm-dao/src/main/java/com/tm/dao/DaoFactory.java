package com.tm.dao;

import com.tm.dao.db.impl.IssueAttachmentDaoImpl;
import com.tm.dao.db.impl.IssueCommentDaoImpl;
import com.tm.dao.db.impl.IssueDaoImpl;
import com.tm.dao.db.impl.ModuleDaoImpl;
import com.tm.dao.db.impl.ProjectDaoImpl;
import com.tm.dao.db.impl.UserDaoImpl;
import com.tm.dao.db.impl.UserProjectDaoImpl;

public class DaoFactory {
	
	private DaoFactory() {
	}
	
	public static Object generateService(DaoType dType) {
		if(dType.equals(DaoType.USER)) {
			return new UserDaoImpl();
		} else if(dType.equals(DaoType.PROJECT)) {
			return new ProjectDaoImpl();
		} else if(dType.equals(DaoType.USER_PROJECT)) {
			return new UserProjectDaoImpl();
		} else if(dType.equals(DaoType.MODULE)) {
			return new ModuleDaoImpl();
		} else if(dType.equals(DaoType.ISSUE)) {
			return new IssueDaoImpl();
		} else if(dType.equals(DaoType.ISSUE_COMMENT)) {
			return new IssueCommentDaoImpl();
		} else if(dType.equals(DaoType.ISSUE_ATTACHMENT)) {
			return new IssueAttachmentDaoImpl();
		} else {
			return null;
		}
	}
}
