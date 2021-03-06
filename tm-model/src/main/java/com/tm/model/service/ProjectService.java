package com.tm.model.service;

import java.util.List;

import com.tm.core.entity.TmProject;
import com.tm.model.bean.ui.ProjectBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public interface ProjectService extends DtoAssemblerFacade<TmProject, ProjectBean> {

	List<ProjectBean> getAllProjects(Long userId) throws DtoConversionException;

	ProjectBean addProject(ProjectBean projectBean, boolean addDefaultModules) throws DtoConversionException, DaoException;

	void disableProject(long id);

	void enableProject(long id);
	
	void deleteProject(long id);

	ProjectBean editProject(ProjectBean projectBean) throws DtoConversionException;
}
