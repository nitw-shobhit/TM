package com.tm.web.logger;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;

import com.tm.model.service.LoggerService;

@Aspect
public class TmLogger {
	
	@Resource
	private LoggerService loggerService;
	
	@Async
	@Before("execution(public String com.tm.web.controller.*.*(..))")
	public void logBegin(JoinPoint join) {
		loggerService.trace(join.getSignature().toString(), "Starting execution");
	}
	
	@Async
	@After("execution(public String com.tm.web.controller.*.*(..))")
	public void logEnd(JoinPoint join) {
		loggerService.trace(join.getSignature().toString(), "Finishing execution");
	}

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
}
