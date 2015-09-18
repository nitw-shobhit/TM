package com.tm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.tm.util.exceptions.UnauthorizedException;

public class AuthorizeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		String url = httpRequest.getRequestURL().toString();
		
		if(!url.contains("/validateLogin.do")) {
			String userId = validateCookies(httpRequest);
			if(userId == null) {
				try {
					throw new UnauthorizedException("User not authorized");
				} catch (UnauthorizedException e) {
					e.printStackTrace();
				}
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	private String validateCookies(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("tmCookie")) {
				return cookie.getValue();
			}
		}
		
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
