package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.UserBean;

public interface UserProjectService {

	List<UserBean> getProjectTeam(long projectId);

	void addUserToProject(long userId, long projectId);

}
