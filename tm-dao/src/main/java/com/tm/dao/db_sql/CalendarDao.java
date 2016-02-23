package com.tm.dao.db_sql;

import java.util.List;

import com.tm.core.entity_sql.TmCalendar;
import com.tm.util.db.genericdao.DBFacade_Sql;

public interface CalendarDao extends DBFacade_Sql<TmCalendar, Long>{

	List<TmCalendar> byUserId(long userId);
}
