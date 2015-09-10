package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.UserBean;
import com.tm.util.exceptions.DtoConversionException;

public interface UserProjectService {

	List<UserBean> getProjectTeam(long projectId) throws DtoConversionException;

	void addUserToProject(long userId, long projectId);

}
