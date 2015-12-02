package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.service.LoggerService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.logger.LogLevel;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmLogger")
public class LoggerController {
	
	@Resource
	private LoggerService loggerService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getLogs")
	public @ResponseBody String getLogs() throws InternalApplicationException {
		return JsonUtils.toJson(loggerService.getLogsByLevel(LogLevel.ALL));
	}

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
}
