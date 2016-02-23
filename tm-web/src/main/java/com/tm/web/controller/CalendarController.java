package com.tm.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.ui.CalendarBean;
import com.tm.model.service.CalendarService;
import com.tm.util.date.calendar.beans.Calendar;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmCalendar")
public class CalendarController {
	
	@Resource
	private CalendarService calendarService;
	
	@RequestMapping(method = RequestMethod.GET, value="/createCalendar")
	public @ResponseBody String createCalendar(@RequestParam("month") int month, @RequestParam("year") int year) throws InternalApplicationException {
		Calendar calendar = null;
		try {
			calendar = calendarService.createCalendar(month, year);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(calendar);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getCalendar")
	public @ResponseBody String getCalendar(@RequestParam("userId") long userId) throws InternalApplicationException {
		Map<String, List<CalendarBean>> calendarBeanMap = null;
		try {
			calendarBeanMap = calendarService.getCalendar(userId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(calendarBeanMap);
	}
	
	public CalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
}
