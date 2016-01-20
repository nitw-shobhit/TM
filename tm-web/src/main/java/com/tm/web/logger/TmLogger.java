package com.tm.web.logger;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;

import com.tm.model.service.LoggerService;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.file.PropertyUtils;

@Aspect
public class TmLogger {
	
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
	
	@Async
	@Before("execution(public String com.tm.web.controller.*.*(..))")
	public void logBegin(JoinPoint join) {
		if(isLoggingEnabled.equals("1"))
			loggerService.trace(join.getSignature().toString(), "Starting execution");
	}
	
	@Async
	@After("execution(public String com.tm.web.controller.*.*(..))")
	public void logEnd(JoinPoint join) {
		if(isLoggingEnabled.equals("1"))
			loggerService.trace(join.getSignature().toString(), "Finishing execution");
	}

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
}
