package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.ProjectBean;

public interface ProjectService {

	List<ProjectBean> getAllProjects(Long userId);

	ProjectBean addProject(ProjectBean projectBean);

	void disableProject(long id);

	void enableProject(long id);
	
	void deleteProject(long id);

	ProjectBean editProject(ProjectBean projectBean);
}
