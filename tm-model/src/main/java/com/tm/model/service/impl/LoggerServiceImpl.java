package com.tm.model.service.impl;

import java.util.List;

import com.tm.core.entity_nosql.LoggerBean;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_nosql.LoggerDao;
import com.tm.model.service.LoggerService;
import com.tm.model.service.helper.LoggerHelper;
import com.tm.util.logger.LogLevel;

public class LoggerServiceImpl implements LoggerService {

	@Override
	public void info(String logger, String message) {
		String level = LogLevel.INFO.name();
		addLog(logger, message, level);
	}

	@Override
	public void debug(String logger, String message) {
		String level = LogLevel.DEBUG.name();
		addLog(logger, message, level);
	}

	@Override
	public void trace(String logger, String message) {
		String level = LogLevel.TRACE.name();
		addLog(logger, message, level);
	}

	@Override
	public void warn(String logger, String message) {
		String level = LogLevel.WARN.name();
		addLog(logger, message, level);
	}

	@Override
	public void error(Exception exception) {
		String level = LogLevel.ERROR.name();
		addLog(exception, level);
	}

	@Override
	public void severe(Exception exception) {
		String level = LogLevel.SEVERE.name();
		addLog(exception, level);
	}
	

	@Override
	public List<LoggerBean> getLogsByLevel(LogLevel level) {
		LoggerDao loggerDao = (LoggerDao) DaoFactory.generateDao(DaoType.LOGGER);
		if(level.equals(LogLevel.ALL)) {
			return loggerDao.findAll();
		}
		return null;
	}
	
	private void addLog(Exception exception, String level) {
		LoggerBean loggerBean = LoggerHelper.getLoggerEntity(exception, level);
		LoggerDao loggerDao = (LoggerDao) DaoFactory.generateDao(DaoType.LOGGER);
		loggerDao.persist(loggerBean);
	}

	private void addLog(String logger, String message, String level) {
		LoggerBean loggerBean = LoggerHelper.getLoggerEntity(logger, message, level);
		LoggerDao loggerDao = (LoggerDao) DaoFactory.generateDao(DaoType.LOGGER);
		loggerDao.persist(loggerBean);
	}
}
