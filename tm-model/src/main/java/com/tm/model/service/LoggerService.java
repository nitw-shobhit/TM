package com.tm.model.service;

import java.util.List;

import com.tm.core.entity_nosql.LoggerBean;
import com.tm.util.logger.LogLevel;


public interface LoggerService {

	void info(String logger, String message);
	
	void debug(String logger, String message);
	
	void trace(String logger, String message);
	
	void warn(String logger, String message);
	
	void error(Exception exception);
	
	void severe(Exception exception);
	
	List<LoggerBean> getLogsByLevel(LogLevel level);
}
