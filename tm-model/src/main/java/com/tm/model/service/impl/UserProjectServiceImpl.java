package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.bean.UserBean;
import com.tm.core.entity.TmUserProject;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.UserDao;
import com.tm.dao.db.UserProjectDao;
import com.tm.model.service.UserProjectService;

public class UserProjectServiceImpl implements UserProjectService {

	@Override
	public List<UserBean> getProjectTeam(long projectId) {
		UserProjectDao userProjectDao = (UserProjectDao) DaoFactory.generateService(DaoType.USER_PROJECT);
		List<TmUserProject> userProjList = userProjectDao.getUserProjectByProjId(projectId);
		List<UserBean> userList = new ArrayList<UserBean>();
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		for(TmUserProject userProj : userProjList) {
			userList.add(userDao.findByPk(userProj.getUserId()).toBean());
		}
		return userList;
	}

}
