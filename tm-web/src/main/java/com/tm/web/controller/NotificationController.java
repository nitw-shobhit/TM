package com.tm.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.NotificationBean;
import com.tm.model.service.NotificationService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmNotification")
public class NotificationController {
	
	@Resource
	private NotificationService notificationService;

	@RequestMapping(method = RequestMethod.GET, value="/getUserNotifications")
	public @ResponseBody String getUserNotifications(@RequestParam("userId") long userId) throws InternalApplicationException {
		List<NotificationBean> notificationBeanList = null;
		try {
			notificationBeanList = notificationService.getUserNotifications(userId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		
		return JsonUtils.toJson(notificationBeanList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/markNotificationsAsRead")
	public @ResponseBody String markNotificationsAsRead(@RequestParam("notificationIds") String jsonObj) throws InternalApplicationException {
		String result = null;
		try {
			@SuppressWarnings("unchecked")
			List<Integer> notificationIdList = (List<Integer>) JsonUtils.toPojo(jsonObj, ArrayList.class);
			result = notificationService.markNotificationsAsRead(notificationIdList);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deleteUserNotifications")
	public @ResponseBody void deleteUserNotifications(@RequestParam("notificationIds") String jsonObj) throws InternalApplicationException {
		try {
			@SuppressWarnings("unchecked")
			List<Integer> notificationIdList = (List<Integer>) JsonUtils.toPojo(jsonObj, ArrayList.class);
			notificationService.deleteUserNotifications(notificationIdList);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/archiveUserNotifications")
	public @ResponseBody void archiveUserNotifications(@RequestParam("notificationIds") String jsonObj) throws InternalApplicationException {
		try {
			@SuppressWarnings("unchecked")
			List<Integer> notificationIdList = (List<Integer>) JsonUtils.toPojo(jsonObj, ArrayList.class);
			notificationService.archiveUserNotifications(notificationIdList);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/unArchiveUserNotifications")
	public @ResponseBody void unArchiveUserNotifications(@RequestParam("notificationIds") String jsonObj) throws InternalApplicationException {
		try {
			@SuppressWarnings("unchecked")
			List<Integer> notificationIdList = (List<Integer>) JsonUtils.toPojo(jsonObj, ArrayList.class);
			notificationService.unArchiveUserNotifications(notificationIdList);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
	}
	
	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
}
