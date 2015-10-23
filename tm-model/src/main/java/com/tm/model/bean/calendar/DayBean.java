package com.tm.model.bean.calendar;

import java.util.List;

public class DayBean {
	
	private String day;
	private List<DateBean> dates;
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public List<DateBean> getDates() {
		return dates;
	}
	
	public void setDates(List<DateBean> dates) {
		this.dates = dates;
	}
}
