package com.tm.dao;

import com.tm.dao.db.impl.ProjectDaoImpl;
import com.tm.dao.db.impl.UserDaoImpl;

public class DaoFactory {
	
	private DaoFactory() {
	}
	
	public static Object generateService(DaoType dType) {
		if(dType.equals(DaoType.USER)) {
			return new UserDaoImpl();
		} else if(dType.equals(DaoType.PROJECT)) {
			return new ProjectDaoImpl();
		} else {
			return null;
		}
	}
}
