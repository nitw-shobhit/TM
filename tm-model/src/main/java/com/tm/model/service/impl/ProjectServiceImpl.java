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
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class ProjectServiceImpl extends DtoAssemblerFacadeImpl<TmProject, ProjectBean> implements ProjectService {

	@Override
	public List<ProjectBean> getAllProjects(Long userId) throws DtoConversionException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		List<TmProject> projectEntities = projectDao.byUserId(userId);
		List<ProjectBean> projectBeanList = new ArrayList<ProjectBean>();
		for(TmProject projectEntity : projectEntities) {
			projectBeanList.add(toBean(projectEntity));
		}
		
		return projectBeanList;
	}

	@Override
	public ProjectBean addProject(ProjectBean projectBean) throws DtoConversionException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = toEntity(projectBean);
		projectEntity.setDtCreated(new Timestamp(new Date().getTime()));
		projectEntity.setVisible(true);
		projectDao.persist(projectEntity);
		return toBean(projectEntity);
	}
	
	@Override
	public ProjectBean editProject(ProjectBean projectBean) throws DtoConversionException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateService(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(projectBean.getId());
		projectEntity.setProjName(projectBean.getProjName());
		projectEntity.setProjDesc(projectBean.getProjDesc());
		projectDao.merge(projectEntity);
		return toBean(projectEntity);
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
