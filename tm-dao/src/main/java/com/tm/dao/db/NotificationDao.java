package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmNotification;
import com.tm.util.db.DBFacade;

public interface NotificationDao extends DBFacade<TmNotification, Long>{

	List<TmNotification> byUserId(long userId);
}
