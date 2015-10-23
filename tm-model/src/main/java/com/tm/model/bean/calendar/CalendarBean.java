package com.tm.model.bean.calendar;

import java.util.List;

public class CalendarBean {

	private String month;
	private int year;
	private List<DayBean> days;
	private int today;
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<DayBean> getDays() {
		return days;
	}
	
	public void setDays(List<DayBean> days) {
		this.days = days;
	}

	public int getToday() {
		return today;
	}

	public void setToday(int today) {
		this.today = today;
	}
}
