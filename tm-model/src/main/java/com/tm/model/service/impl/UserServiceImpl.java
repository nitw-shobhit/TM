package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.tm.core.bean.UserBean;
import com.tm.core.entity.TmUserInfo;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.UserDao;
import com.tm.model.service.UserService;
import com.tm.util.cipher.CipherUtils;
import com.tm.util.exceptions.LoginValidationFailedException;

public class UserServiceImpl implements UserService {

	@Override
	public UserBean validateLogin(UserBean userBean) throws LoginValidationFailedException {
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		UserBean userBeanRet = userDao.getUserByUserId(userBean.getUserId()).toBean();
		if(userBeanRet == null) {
			throw new LoginValidationFailedException("Invalid Details");
		} else {
			String password = null;
			try {
				password = CipherUtils.decrypt(userBeanRet.getUserPass());
			} catch (Exception e) {
				throw new LoginValidationFailedException("Login credentials could not be validated at this moment", e);
			}
			if(!password.equals(userBean.getUserPass())) {
				throw new LoginValidationFailedException("Invalid Details");
			}
		}
		return userBeanRet;
	}

	@Override
	public UserBean updateUserProfile(UserBean userBean) {
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		TmUserInfo userEntity = userDao.findByPk(userBean.getId());
		updateUserEntity(userEntity, userBean);
		return userDao.merge(userEntity).toBean();
	}

	private void updateUserEntity(TmUserInfo userEntity, UserBean userBean) {
		userEntity.setUserEmail(userBean.getUserEmail());
		userEntity.setUserPhone(userBean.getUserPhone());
		userEntity.setUserPass(userBean.getUserPass());
		userEntity.setDtModified(new Timestamp(new Date().getTime()));
	}
}
