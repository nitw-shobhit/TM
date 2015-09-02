package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.core.bean.UserBean;
import com.tm.core.entity.TmUserInfo;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.bpm.BpmDao;
import com.tm.dao.db.UserDao;
import com.tm.model.service.UserService;
import com.tm.util.bpm.RequestType;
import com.tm.util.cipher.CipherUtils;
import com.tm.util.exceptions.BpmException;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.FileLoadException;
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

	@Override
	public List<UserBean> searchUsers(String query) {
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		List<TmUserInfo> userEntityList = userDao.getUsersByQuery(query);
		for(TmUserInfo userEntity : userEntityList) {
			userBeanList.add(userEntity.toBean());
		}
		return userBeanList;
	}
	
	private void updateUserEntity(TmUserInfo userEntity, UserBean userBean) {
		userEntity.setUserEmail(userBean.getUserEmail());
		userEntity.setUserPhone(userBean.getUserPhone());
		userEntity.setUserPass(userBean.getUserPass());
		userEntity.setDtModified(new Timestamp(new Date().getTime()));
	}

	@Override
	public String changePassword(long id, String password) throws FileLoadException, CipherException {
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		TmUserInfo userEntity = userDao.findByPk(id);
		String encryptedPassword = CipherUtils.encrypt(password);
		userEntity.setUserPass(encryptedPassword);
		userDao.merge(userEntity);
		return encryptedPassword;
	}

	@Override
	public String requestAdminPrivilege(long userId) throws BpmException {
		BpmDao bpmDao = (BpmDao) DaoFactory.generateService(DaoType.BPM);
		Map<String, Object> data = new HashMap<String, Object>(); 
		data.put("manager", "A10000");
		long requestId = bpmDao.createRequest(RequestType.ADMIN_PRIVILEGE_REQUEST, data);
		return String.valueOf(requestId);
	}

	@Override
	public Map<String, String> getUserGroups() {
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<TmUserInfo> userEntityList = userDao.findAll("TmUserInfo.findAll");
		Map<String, String> userGroups = new HashMap<String, String>();
		for(TmUserInfo userEntity : userEntityList) {
			userGroups.put(userEntity.getUserId(), userEntity.getUserGroupId());
		}
		return userGroups;
	}
}
