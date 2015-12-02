package com.tm.model.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tm.core.entity_sql.TmNotificationVariable;

public class NotificationVariableHelper {

	public static List<TmNotificationVariable> getNotificationVariables(Map<String, Object> variableMap) {
		List<TmNotificationVariable> notificationVariableEntityList = new ArrayList<TmNotificationVariable>();
		TmNotificationVariable notificationVariableEnitity;
		for (Map.Entry<String, Object> entry : variableMap.entrySet()) {
			notificationVariableEnitity = new TmNotificationVariable();
			notificationVariableEnitity.setNvlKey(entry.getKey());
			notificationVariableEnitity.setNvlVal(String.valueOf(entry.getValue()));
			notificationVariableEntityList.add(notificationVariableEnitity);
		}
		
		return notificationVariableEntityList;
	}
}
