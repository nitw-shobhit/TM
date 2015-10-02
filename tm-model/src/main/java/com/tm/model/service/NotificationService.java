package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.NotificationBean;
import com.tm.core.entity.TmNotification;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;


public interface NotificationService extends DtoAssemblerFacade<TmNotification, NotificationBean> {

	List<NotificationBean> getUserNotifications(long userId) throws DtoConversionException;

	void deleteUserNotifications(List<Integer> notificationIdList);

	String markNotificationsAsRead(List<Integer> notificationIdList);

	void archiveUserNotifications(List<Integer> notificationIdList);

	void unArchiveUserNotifications(List<Integer> notificationIdList);
}
