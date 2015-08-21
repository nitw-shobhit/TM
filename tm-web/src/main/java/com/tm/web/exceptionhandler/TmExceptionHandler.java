package com.tm.web.exceptionhandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.tm.util.exceptions.ApplicationException;

public class TmExceptionHandler extends SimpleMappingExceptionResolver {
	
	@Resource
	private SessionLocaleResolver localeResolver;
	
	@Resource
	private MessageSource messageSource;
	
	private static final String UNKNOWN_ERROR_CODE = "1000";
	private static final String DEFAULT_ERROR_MESSG = "Error message not defined!";

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		//TODO Use Logger
		ex.printStackTrace();
		ModelAndView mav = new ModelAndView();
		String errorCode = UNKNOWN_ERROR_CODE;
		if(ex instanceof ApplicationException) {
			errorCode = ((ApplicationException)ex).getErrorCode();
		}
		mav.addObject("ErrorCode", errorCode);
		mav.addObject("ErrorMessage", messageSource.getMessage(errorCode, null, DEFAULT_ERROR_MESSG, localeResolver.resolveLocale(request)));
		
		mav.setViewName(determineViewName(ex, request));
		return mav;
	}	
	
	public SessionLocaleResolver getLocaleResolver() {
		return localeResolver;
	}

	public void setLocaleResolver(SessionLocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
