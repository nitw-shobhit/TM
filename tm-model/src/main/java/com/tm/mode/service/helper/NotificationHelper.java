package com.tm.mode.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.tm.core.entity.TmNotification;
import com.tm.core.entity.TmNotificationVariable;
import com.tm.model.bean.ui.NotificationBean;
import com.tm.util.exceptions.DtoConversionException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.file.PropertyUtils;
import com.tm.util.string.StringUtils;

public class NotificationHelper {

static Properties notificationProp;
	
	private static String DEFAULT_MESSG = "No content";

	static {
		try {
			notificationProp = PropertyUtils.loadProperties("notification/notification_en.properties");
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
	}
	
	public static NotificationBean formatNotification(NotificationBean notificationBean,
			List<TmNotificationVariable> notificationVariableEntityList) throws DtoConversionException {
		String notificationMessage = notificationProp.getProperty(notificationBean.getNotContent());
		
		if(notificationMessage != null) {
			Map<String, String> notificationVariableMap = new HashMap<String, String>();
			for(TmNotificationVariable notificationVariableEntity : notificationVariableEntityList) {
				notificationVariableMap.put(notificationVariableEntity.getNvlKey(), notificationVariableEntity.getNvlVal());
			}
			notificationMessage = StringUtils.stringSubstitutor(notificationMessage, notificationVariableMap);
			
			String [] notificationBody = notificationMessage.split("\\|");
			notificationBean.setNotSubject(notificationBody[0]);
			notificationBean.setNotContent(notificationBody[1]);
			notificationBean.setNotFooter(notificationBody[2]);
		} else {
			notificationBean.setNotSubject(DEFAULT_MESSG);
			notificationBean.setNotContent(DEFAULT_MESSG);
			notificationBean.setNotFooter(DEFAULT_MESSG);
		}
		return notificationBean;
	}
	
	public static TmNotification getNotificationEntity(long userId, NotificationType notificationType) {
		TmNotification notificationEntity = new TmNotification();
		notificationEntity.setNotContent(notificationType.getValue());
		notificationEntity.setNotIsUnread(true);
		notificationEntity.setUserId(userId);
		
		return notificationEntity;
	}
	
	public enum NotificationType {

		NOTIFICATION_ISSUE_CREATE("notification.001");
		
		private String value;
		
		private NotificationType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
