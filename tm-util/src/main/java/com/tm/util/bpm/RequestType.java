package com.tm.util.bpm;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum RequestType {

	ADMIN_PRIVILEGE_REQUEST("com.tm.flow.admin_privilege_request", "Admin_Privilege_Request"),
	ISSUE_REQUEST("com.tm.flow.issue_request", "Issue_Request");
	
	private String id;
	private String name;
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	private RequestType(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static List<String> getValues() {
		EnumSet<RequestType> requestEnumValues = EnumSet.allOf(RequestType.class);
		List<String> values = new ArrayList<String>();
		for(RequestType requestType : requestEnumValues) {
			values.add(requestType.getName());
		}
		return values;
	}
}
