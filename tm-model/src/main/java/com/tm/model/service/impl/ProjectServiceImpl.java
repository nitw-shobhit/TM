package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tm.core.bean.ProjectBean;
import com.tm.core.entity.TmProject;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.ProjectDao;
import com.tm.model.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<ProjectBean> getAllProjects(Long userId) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		List<TmProject> projectEntities = projectDao.getProjectsByUserId(userId);
		List<ProjectBean> projectBeanList = new ArrayList<ProjectBean>();
		for(TmProject projectEntity : projectEntities) {
			projectBeanList.add(projectEntity.toBean());
		}
		
		return projectBeanList;
	}

	@Override
	public ProjectBean addProject(ProjectBean projectBean) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectBean.toEntity();
		projectEntity.setDtCreated(new Timestamp(new Date().getTime()));
		projectEntity.setVisible(true);
		projectDao.persist(projectEntity);
		return projectEntity.toBean();
	}
	
	@Override
	public ProjectBean editProject(ProjectBean projectBean) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(projectBean.getId());
		projectEntity.setProjName(projectBean.getProjName());
		projectEntity.setProjDesc(projectBean.getProjDesc());
		projectDao.merge(projectEntity);
		return projectEntity.toBean();
	}
	
	@Override
	public void disableProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectEntity.setVisible(false);
		projectDao.merge(projectEntity);
	}
	
	@Override
	public void enableProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectEntity.setVisible(true);
		projectDao.merge(projectEntity);
	}

	@Override
	public void deleteProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectDao.remove(projectEntity);
	}
}
