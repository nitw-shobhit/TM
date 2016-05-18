package com.tm.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.entity.TmNotification;
import com.tm.core.entity.TmNotificationVariable;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.NotificationDao;
import com.tm.dao.db.NotificationVariableDao;
import com.tm.mode.service.helper.NotificationHelper;
import com.tm.model.bean.ui.NotificationBean;
import com.tm.model.service.NotificationService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class NotificationServiceImpl extends DtoAssemblerFacadeImpl<TmNotification, NotificationBean> implements NotificationService {

	@Override
	public List<NotificationBean> getUserNotifications(long userId) throws DtoConversionException {
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		NotificationVariableDao notificationVariableDao = (NotificationVariableDao) DaoFactory.generateDao(DaoType.NOTIFICATION_VARIABLE);
		List<TmNotification> notificationEntityList = notificationDao.byUserId(userId);
		List<NotificationBean> notificationBeanList = new ArrayList<NotificationBean>();
		for(TmNotification notificationEntity : notificationEntityList) {
			NotificationBean notificationBean = toBean(notificationEntity);
			List<TmNotificationVariable> notificationVariableEntityList = notificationVariableDao.byNotificationId(notificationBean.getId());
			notificationBean = NotificationHelper.formatNotification(notificationBean, notificationVariableEntityList);
			notificationBeanList.add(notificationBean);
		}
		return notificationBeanList;
	}
	
	@Override
	public void deleteUserNotifications(List<Integer> notificationIdList) {
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		for(int notificationId : notificationIdList) {
			notificationDao.remove(notificationDao.findByPk((long)notificationId));
		}
	}

	@Override
	public String markNotificationsAsRead(List<Integer> notificationIdList) {
		String result = "Fail";
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		for(int notificationId : notificationIdList) {
			TmNotification notificationEntity = notificationDao.findByPk((long) notificationId);
			if(notificationEntity.isNotIsUnread()) {
				notificationEntity.setNotIsUnread(false);
				notificationDao.merge(notificationEntity, true);
				if(result.equals("Fail")) {
					result = "Success";
				}
			}
		}
		
		return result;
	}

	@Override
	public void archiveUserNotifications(List<Integer> notificationIdList) {
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		for(int notificationId : notificationIdList) {
			TmNotification notificationEntity = notificationDao.findByPk((long) notificationId);
			notificationEntity.setVisible(false);
			notificationDao.merge(notificationEntity, true);
		}
	}
	
	@Override
	public void unArchiveUserNotifications(List<Integer> notificationIdList) {
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		for(int notificationId : notificationIdList) {
			TmNotification notificationEntity = notificationDao.findByPk((long) notificationId);
			notificationEntity.setVisible(true);
			notificationDao.merge(notificationEntity, true);
		}
	}
}
