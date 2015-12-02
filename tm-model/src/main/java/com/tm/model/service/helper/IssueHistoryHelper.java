package com.tm.model.service.helper;

import java.sql.Timestamp;
import java.util.Date;

import com.tm.core.entity_sql.TmIssueHistory;
import com.tm.core.entity_sql.TmUserInfo;

public class IssueHistoryHelper {

	public static TmIssueHistory getHistoryEntity(TmUserInfo issueOwnerEntity, IssueHistoryType event) {
		TmIssueHistory issueHistoryEntity = new TmIssueHistory();
		issueHistoryEntity.setHisContent(event.getValue());
		issueHistoryEntity.setHisCreated(new Timestamp(new Date().getTime()));
		StringBuffer user = new StringBuffer(issueOwnerEntity.getUserName()).append(" (").append(issueOwnerEntity.getUserId()).append(")");
		issueHistoryEntity.setHisUser(user.toString());
		return issueHistoryEntity;
	}
	
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
}
