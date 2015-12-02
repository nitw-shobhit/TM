package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.core.entity_sql.TmUserInfo;
import com.tm.core.entity_sql.TmUserProject;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.UserDao;
import com.tm.model.bean.ui.UserBean;
import com.tm.model.service.UserService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.cipher.CipherUtils;
import com.tm.util.exceptions.CipherException;
import com.tm.util.exceptions.DtoConversionException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.LoginValidationFailedException;

public class UserServiceImpl extends DtoAssemblerFacadeImpl<TmUserInfo, UserBean> implements UserService {

	@Override
	public UserBean validateLogin(UserBean userBean) throws LoginValidationFailedException, DtoConversionException {
		UserBean userBeanRet = getUserByUserId(userBean.getUserId());
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
	public UserBean updateUserProfile(UserBean userBean) throws DtoConversionException {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo userEntity = userDao.findByPk(userBean.getId());
		updateUserEntity(userEntity, userBean);
		return toBean(userDao.merge(userEntity, true));
	}
	
	private void updateUserEntity(TmUserInfo userEntity, UserBean userBean) {
		userEntity.setUserEmail(userBean.getUserEmail());
		userEntity.setUserPhone(userBean.getUserPhone());
		userEntity.setUserPass(userBean.getUserPass());
	}

	@Override
	public String changePassword(long id, String password) throws FileLoadException, CipherException {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo userEntity = userDao.findByPk(id);
		String encryptedPassword = CipherUtils.encrypt(password);
		userEntity.setUserPass(encryptedPassword);
		userDao.merge(userEntity, true);
		return encryptedPassword;
	}

	@Override
	public String requestAdminPrivilege(long userId) {
		return null;
	}

	@Override
	public Map<String, String> getUserGroups() {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		List<TmUserInfo> userEntityList = userDao.findAll();
		Map<String, String> userGroups = new HashMap<String, String>();
		for(TmUserInfo userEntity : userEntityList) {
			userGroups.put(userEntity.getUserId(), userEntity.getUserGroupId());
		}
		return userGroups;
	}

	@Override
	public List<UserBean> getAllUsers() throws DtoConversionException {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		List<TmUserInfo> userEntityList = userDao.findAll();
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for(TmUserInfo userEntity : userEntityList) {
			userBeanList.add(toBean(userEntity));
		}
		return userBeanList;
	}
	
	public List<UserBean> getUsersFromUserProjectList(List<TmUserProject> userProjList) throws DtoConversionException {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		List<UserBean> userList = new ArrayList<UserBean>();
		for(TmUserProject userProj : userProjList) {
			userList.add(toBean(userDao.findByPk(userProj.getUserId())));
		}
		return userList;
	}

	@Override
	public UserBean getUserByUserId(String userId)
			throws DtoConversionException {
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		return toBean(userDao.byUserId(userId));
	}
}
