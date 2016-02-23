package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.core.entity_sql.TmCalendar;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.CalendarDao;
import com.tm.model.bean.ui.CalendarBean;
import com.tm.model.service.CalendarService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.date.calendar.CalendarUtils;
import com.tm.util.date.calendar.beans.Calendar;
import com.tm.util.exceptions.DtoConversionException;

public class CalendarServiceImpl extends DtoAssemblerFacadeImpl<TmCalendar, CalendarBean> implements CalendarService {

	@Override
	public Calendar createCalendar(int month, int year) {
		return CalendarUtils.createCalendar(year, month);
	}

	@Override
	public Map<String, List<CalendarBean>> getCalendar(long userId) throws DtoConversionException {
		CalendarDao calendarDao = (CalendarDao) DaoFactory.generateDao(DaoType.CALENDAR);
		List<TmCalendar> calendarEntityList = calendarDao.byUserId(userId);
		Map<String, List<CalendarBean>> calendarMap = new HashMap<String, List<CalendarBean>>();
		for(TmCalendar calendarEntity : calendarEntityList) {
			Timestamp eventDate = calendarEntity.getEventDate();
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTimeInMillis(eventDate.getTime());
			StringBuffer temp = new StringBuffer(String.valueOf(cal.get(java.util.Calendar.DATE)));
			
			int month = cal.get(java.util.Calendar.MONTH) + 1;
			if(month < 10) {
				temp.append("0");
			}
			temp.append(month);
			temp.append(cal.get(java.util.Calendar.YEAR));
			List<CalendarBean> tempCalendarBeanList = null;
			String key = temp.toString();
			if(calendarMap.containsKey(key)) {
				tempCalendarBeanList = calendarMap.get(key);
			} else {
				tempCalendarBeanList = new ArrayList<CalendarBean>();
			}
			
			tempCalendarBeanList.add(toBean(calendarEntity));
			calendarMap.put(key, tempCalendarBeanList);
		}
		
		return calendarMap;
	}
}
