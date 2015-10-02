package com.tm.dao.db.impl;

import java.util.List;

import com.tm.core.entity.TmNotification;
import com.tm.core.entity.manager.DBFacadeImpl;
import com.tm.dao.db.NotificationDao;
import com.tm.util.db.Param;

public class NotificationDaoImpl extends DBFacadeImpl<TmNotification, Long> implements NotificationDao {

	@Override
	public List<TmNotification> byUserId(long userId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, userId);
		return findByParams(GET_NOTIFICATIONS_BY_USER_ID, params);
	}
}
