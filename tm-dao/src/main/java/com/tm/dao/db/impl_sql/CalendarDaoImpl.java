package com.tm.dao.db.impl_sql;

import java.util.List;

import com.tm.core.entity_sql.TmCalendar;
import com.tm.core.genericdao.impl_sql.DBFacadeImpl_Sql;
import com.tm.dao.db_sql.CalendarDao;
import com.tm.util.db.Param;

public class CalendarDaoImpl extends DBFacadeImpl_Sql<TmCalendar, Long> implements CalendarDao {

	@Override
	public List<TmCalendar> byUserId(long userId) {
		Param [] params = new Param[1];
		params[0] = new Param(PARAM_USER_ID, userId);
		return findByParams(GET_CALENDAR_BY_USER_ID, params);
	}

}
