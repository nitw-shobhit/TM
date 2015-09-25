package com.tm.model.service.helper;

import java.sql.Timestamp;
import java.util.Date;

import com.tm.core.entity.TmIssueHistory;
import com.tm.core.entity.TmUserInfo;

public class IssueHelper {

	public static TmIssueHistory getHistoryEntity(TmUserInfo issueOwnerEntity, IssueHistoryType event) {
		TmIssueHistory issueHistoryEntity = new TmIssueHistory();
		issueHistoryEntity.setHisContent(event.getValue());
		issueHistoryEntity.setHisCreated(new Timestamp(new Date().getTime()));
		StringBuffer user = new StringBuffer(issueOwnerEntity.getUserName()).append(" (").append(issueOwnerEntity.getUserId()).append(")");
		issueHistoryEntity.setHisUser(user.toString());
		return issueHistoryEntity;
	}
}
