package com.tm.model.service;

import com.tm.core.bean.CalendarBean;

public interface CalendarService {

	CalendarBean getCalendar(int month, int year);
}
