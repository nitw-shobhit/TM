package com.tm.model.service.helper;

public enum IssueHistoryType {

	ISSUE_HISTORY_CREATE("issue.history.001"),
	ISSUE_HISTORY_ACCEPT("issue.history.002"),
	ISSUE_HISTORY_REJECT("issue.history.003"),
	ISSUE_HISTORY_REASSIGN("issue.history.004"),
	ISSUE_HISTORY_REOPEN("issue.history.005"),
	ISSUE_HISTORY_MARK_FIXED("issue.history.006"),
	ISSUE_HISTORY_COMPLETE("issue.history.007"),
	ISSUE_HISTORY_CANCEL("issue.history.008"),
	ISSUE_HISTORY_SUBSCRIBE("issue.history.009"),
	ISSUE_HISTORY_UNSUBSCRIBE("issue.history.010"),
	ISSUE_HISTORY_COMMENT("issue.history.011"),
	ISSUE_HISTORY_ATTACH("issue.history.012");
	
	private String value;
	
	private IssueHistoryType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
