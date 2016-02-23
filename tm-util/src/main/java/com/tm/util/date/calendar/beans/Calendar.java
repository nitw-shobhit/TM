package com.tm.util.date.calendar.beans;

import java.util.List;

public class Calendar {

	private String month;
	private int year;
	private List<Day> days;
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
	
	public List<Day> getDays() {
		return days;
	}
	
	public void setDays(List<Day> days) {
		this.days = days;
	}

	public int getToday() {
		return today;
	}

	public void setToday(int today) {
		this.today = today;
	}
}
