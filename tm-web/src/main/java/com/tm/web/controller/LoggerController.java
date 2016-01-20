package com.tm.web.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.entity_nosql.LoggerBean;
import com.tm.model.service.LoggerService;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.file.PropertyUtils;
import com.tm.util.logger.LogLevel;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmLogger")
public class LoggerController {
	
	@Resource
	private LoggerService loggerService;
	
	private static String isLoggingEnabled;
	static {
		try {
			isLoggingEnabled = PropertyUtils.loadProperties("application.properties").getProperty("tm.logs.enabled");
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getLogs")
	public @ResponseBody String getLogs() throws InternalApplicationException {
		if(isLoggingEnabled.equals("0"))
			return JsonUtils.toJson(new ArrayList<LoggerBean>());
		return JsonUtils.toJson(loggerService.getLogsByLevel(LogLevel.ALL));
	}

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
}
