package com.tm.model.service;

import com.tm.model.bean.calendar.CalendarBean;

public interface CalendarService {

	CalendarBean getCalendar(int month, int year);
}
