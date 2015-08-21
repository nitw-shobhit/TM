package com.tm.model.service;

import com.tm.core.bean.UserBean;
import com.tm.util.exceptions.LoginValidationFailedException;

public interface UserService {

	UserBean validateLogin(UserBean userBean) throws LoginValidationFailedException;

	UserBean updateUserProfile(UserBean userBean);

}
