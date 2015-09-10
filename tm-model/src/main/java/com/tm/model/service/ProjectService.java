package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.ProjectBean;
import com.tm.util.exceptions.DtoConversionException;

public interface ProjectService {

	List<ProjectBean> getAllProjects(Long userId) throws DtoConversionException;

	ProjectBean addProject(ProjectBean projectBean) throws DtoConversionException;

	void disableProject(long id);

	void enableProject(long id);
	
	void deleteProject(long id);

	ProjectBean editProject(ProjectBean projectBean) throws DtoConversionException;
}
