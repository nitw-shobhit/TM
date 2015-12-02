package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmNotificationVariable;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.NotificationVariableDao;
import com.tm.util.db.Param;

public class NotificationVariableDaoImpl extends DBFacadeImpl_Sql<TmNotificationVariable, Long> implements NotificationVariableDao {

	@Override
	public List<TmNotificationVariable> byNotificationId(long notId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_NOTIFICATION_ID, notId);
		return findByParams(GET_VARIABLES_BY_NOTIFICATION_ID, params);
	}
}
