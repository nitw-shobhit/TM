package com.tm.dao.db;

import java.util.List;

import com.tm.core.entity.TmNotificationVariable;
import com.tm.util.db.DBFacade;

public interface NotificationVariableDao extends DBFacade<TmNotificationVariable, Long>{

	List<TmNotificationVariable> byNotificationId(long notId);
}
