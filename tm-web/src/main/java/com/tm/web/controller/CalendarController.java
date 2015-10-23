package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.calendar.CalendarBean;
import com.tm.model.service.CalendarService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmCalendar")
public class CalendarController {
	
	@Resource
	private CalendarService calendarService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getCalendar")
	public @ResponseBody String getCalendar(@RequestParam("month") int month, @RequestParam("year") int year) throws InternalApplicationException {
		CalendarBean calendarBean = null;
		try {
			calendarBean = calendarService.getCalendar(month, year);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(calendarBean);
	}
	
	public CalendarService getCalendarService() {
		return calendarService;
	}

	public void setCalendarService(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
}
