package com.tm.model.service;

import java.util.List;

import com.tm.core.entity_sql.TmUserProject;
import com.tm.model.bean.ui.UserBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface UserProjectService extends DtoAssemblerFacade<TmUserProject, UserBean> {

	List<UserBean> getProjectTeam(long projectId) throws DtoConversionException;

	void addUserToProject(long userId, long projectId);

}
