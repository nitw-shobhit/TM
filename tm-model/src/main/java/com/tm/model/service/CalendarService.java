package com.tm.model.service;

import java.util.List;
import java.util.Map;

import com.tm.core.entity_sql.TmCalendar;
import com.tm.model.bean.ui.CalendarBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.date.calendar.beans.Calendar;
import com.tm.util.exceptions.DtoConversionException;

public interface CalendarService extends DtoAssemblerFacade<TmCalendar, CalendarBean> {

	Calendar createCalendar(int month, int year);

	Map<String, List<CalendarBean>> getCalendar(long userId) throws DtoConversionException;
}
