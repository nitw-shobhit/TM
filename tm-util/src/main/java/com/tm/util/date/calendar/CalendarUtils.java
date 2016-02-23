package com.tm.util.date.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tm.util.date.calendar.beans.Date;
import com.tm.util.date.calendar.beans.Day;

public class CalendarUtils {

	private static final String MONTHS[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private static final String DAYS[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	public static com.tm.util.date.calendar.beans.Calendar createCalendar(int year, int month) {
		com.tm.util.date.calendar.beans.Calendar calendar = new com.tm.util.date.calendar.beans.Calendar();
		Calendar temp = Calendar.getInstance();
		int currentDate = temp.get(Calendar.DATE);
		temp.set(year, month, 1);
		
		int totalDates = temp.getActualMaximum(Calendar.DATE);
		
		int firstDay = temp.get(Calendar.DAY_OF_WEEK) - 1;
		
		List<Date> dates;
		Date date;
		List<Day> days = new ArrayList<Day>();
		Day day;
		for(int index1 = 0; index1 < 7; index1 ++) {
			day = new Day();
			day.setDay(DAYS[index1]);
			dates = new ArrayList<Date>();
			for(int index2 = 0; index2 < 6; index2 ++) {
				date = new Date();
				int temp1 = index2 * 7 - firstDay + index1 + 1;
				if(temp1 < 0 || temp1 > totalDates) {
					date.setValue(0);
				} else {
					date.setValue(temp1);
				}
				dates.add(date);
			}
			day.setDates(dates);
			days.add(day);
		}
		
		calendar.setDays(days);
		calendar.setToday(currentDate);
		calendar.setMonth(MONTHS[month]);
		calendar.setYear(year);
		return calendar;
	}
}
