package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmNotificationVariable;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface NotificationVariableDao extends DBFacade_Sql<TmNotificationVariable, Long>{

	List<TmNotificationVariable> byNotificationId(long notId);
}
