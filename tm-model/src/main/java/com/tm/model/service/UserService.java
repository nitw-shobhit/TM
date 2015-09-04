package com.tm.model.service;

import java.util.List;
import java.util.Map;

import com.tm.core.bean.UserBean;
import com.tm.util.exceptions.BpmException;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.LoginValidationFailedException;

public interface UserService {

	UserBean validateLogin(UserBean userBean) throws LoginValidationFailedException;

	UserBean updateUserProfile(UserBean userBean);

	List<UserBean> searchUsers(String query);

	String changePassword(long id, String password) throws FileLoadException, CipherException;
	
	String requestAdminPrivilege(long userId) throws BpmException;
	
	Map<String, String> getUserGroups();

	List<UserBean> getAllUsers();
}
