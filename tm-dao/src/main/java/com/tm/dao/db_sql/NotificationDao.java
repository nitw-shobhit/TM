package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmNotification;
import com.tm.core.entity_sql.TmNotificationVariable;
import com.tm.util.db.genericdao.DBFacade_Sql;
import com.tm.util.exceptions.DaoException;

public interface NotificationDao extends DBFacade_Sql<TmNotification, Long>{

	List<TmNotification> byUserId(long userId);
	
	TmNotification addNotification(TmNotification notificationEntity, List<TmNotificationVariable> notificationVariableEntityList) throws DaoException;
}
