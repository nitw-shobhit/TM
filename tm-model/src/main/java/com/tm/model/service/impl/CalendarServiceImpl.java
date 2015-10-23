package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tm.core.bean.CalendarBean;
import com.tm.core.bean.DateBean;
import com.tm.core.bean.DayBean;
import com.tm.model.service.CalendarService;

public class CalendarServiceImpl implements CalendarService {

	private static final String MONTHS[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private static final String DAYS[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	@Override
	public CalendarBean getCalendar(int month, int year) {
		CalendarBean calendarBean = new CalendarBean();
		Calendar calendar = Calendar.getInstance();
		int currentDate = calendar.get(Calendar.DATE);
		calendar.set(year, month, 1);
		
		int totalDates = calendar.getActualMaximum(Calendar.DATE);
		
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		
		List<DateBean> dates;
		DateBean dateBean;
		List<DayBean> days = new ArrayList<DayBean>();
		DayBean dayBean;
		for(int index1 = 0; index1 < 7; index1 ++) {
			dayBean = new DayBean();
			dayBean.setDay(DAYS[index1]);
			dates = new ArrayList<DateBean>();
			for(int index2 = 0; index2 < 6; index2 ++) {
				dateBean = new DateBean();
				int temp = index2 * 7 - firstDay + index1 + 1;
				if(temp < 0 || temp > totalDates) {
					dateBean.setValue(0);
				} else {
					dateBean.setValue(temp);
				}
				dates.add(dateBean);
			}
			dayBean.setDates(dates);
			days.add(dayBean);
		}
		
		calendarBean.setDays(days);
		calendarBean.setToday(currentDate);
		calendarBean.setMonth(MONTHS[month]);
		calendarBean.setYear(year);
		return calendarBean;
	}
}
