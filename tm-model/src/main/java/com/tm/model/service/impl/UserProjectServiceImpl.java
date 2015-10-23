package com.tm.model.service.impl;

import java.util.List;

import com.tm.core.entity.TmUserProject;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.UserProjectDao;
import com.tm.model.bean.ui.UserBean;
import com.tm.model.service.UserProjectService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class UserProjectServiceImpl extends DtoAssemblerFacadeImpl<TmUserProject, UserBean> implements UserProjectService {

	@Override
	public List<UserBean> getProjectTeam(long projectId) throws DtoConversionException {
		UserProjectDao userProjectDao = (UserProjectDao) DaoFactory.generateService(DaoType.USER_PROJECT);
		List<TmUserProject> userProjList = userProjectDao.byProjectId(projectId);
		return new UserServiceImpl().getUsersFromUserProjectList(userProjList);
	}

	@Override
	public void addUserToProject(long userId, long projectId) {
		UserProjectDao userProjectDao = (UserProjectDao) DaoFactory.generateService(DaoType.USER_PROJECT);
		TmUserProject userProject = new TmUserProject();
		userProject.setProjId(projectId);
		userProject.setUserId(userId);
		userProjectDao.persist(userProject, false);
	}

}
