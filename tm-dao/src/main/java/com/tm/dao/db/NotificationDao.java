package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmNotification;
import com.tm.core.entity.TmNotificationVariable;
import com.tm.util.db.genericdao.DBFacade;
import com.tm.util.exceptions.DaoException;

public interface NotificationDao extends DBFacade<TmNotification, Long>{

	List<TmNotification> byUserId(long userId);
	
	TmNotification addNotification(TmNotification notificationEntity, List<TmNotificationVariable> notificationVariableEntityList) throws DaoException;
}
