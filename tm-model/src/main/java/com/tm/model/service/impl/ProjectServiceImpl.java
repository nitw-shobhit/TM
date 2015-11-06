package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.tm.core.entity.TmProject;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.ProjectDao;
import com.tm.model.bean.ui.ProjectBean;
import com.tm.model.service.ModuleService;
import com.tm.model.service.ProjectService;
import com.tm.model.service.helper.ModuleHelper;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public class ProjectServiceImpl extends DtoAssemblerFacadeImpl<TmProject, ProjectBean> implements ProjectService {

	@Resource
	private ModuleService moduleService;
	
	@Override
	public List<ProjectBean> getAllProjects(Long userId) throws DtoConversionException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		List<TmProject> projectEntities = projectDao.byUserId(userId);
		List<ProjectBean> projectBeanList = new ArrayList<ProjectBean>();
		for(TmProject projectEntity : projectEntities) {
			projectBeanList.add(toBean(projectEntity));
		}
		
		return projectBeanList;
	}

	@Override
	public ProjectBean addProject(ProjectBean projectBean, boolean addDefaultModules) throws DtoConversionException, DaoException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		TmProject projectEntity = toEntity(projectBean);
		if(addDefaultModules) {
			projectEntity = projectDao.addProjectEntity(projectEntity, ModuleHelper.createDefaultModuleEntities(projectEntity.getId()));
		} else {
			projectDao.persist(projectEntity, true);
		}
		return toBean(projectEntity);
	}
	
	@Override
	public ProjectBean editProject(ProjectBean projectBean) throws DtoConversionException {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(projectBean.getId());
		projectEntity.setProjName(projectBean.getProjName());
		projectEntity.setProjDesc(projectBean.getProjDesc());
		projectDao.merge(projectEntity, true);
		return toBean(projectEntity);
	}
	
	@Override
	public void disableProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectEntity.setVisible(false);
		projectDao.merge(projectEntity, true);
	}
	
	@Override
	public void enableProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectEntity.setVisible(true);
		projectDao.merge(projectEntity, true);
	}

	@Override
	public void deleteProject(long id) {
		ProjectDao projectDao = (ProjectDao) DaoFactory.generateDao(DaoType.PROJECT);
		TmProject projectEntity = projectDao.findByPk(id);
		projectDao.remove(projectEntity);
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
}
