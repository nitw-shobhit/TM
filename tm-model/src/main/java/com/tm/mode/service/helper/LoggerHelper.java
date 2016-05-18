package com.tm.mode.service.helper;

import java.sql.Timestamp;
import java.util.Date;

import com.tm.core.entity.LoggerBean;

public class LoggerHelper {

	public static LoggerBean getLoggerEntity(String logger, String message, String level) {
		LoggerBean loggerBean = new LoggerBean();
		loggerBean.setId(new Date().getTime());
		loggerBean.setLog_level(level);
		loggerBean.setLog_logger(logger);
		loggerBean.setLog_message(message);
		loggerBean.setLog_signed_user("Test User");
		loggerBean.setLog_ip_address("127.0.0.1");
		loggerBean.setDt_created(new Timestamp(new Date().getTime()).toString());
		return loggerBean;
	}

	public static LoggerBean getLoggerEntity(Exception exception, String level) {
		return null;
	}
}
