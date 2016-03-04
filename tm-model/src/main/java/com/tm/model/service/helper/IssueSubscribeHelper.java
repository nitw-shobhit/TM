package com.tm.model.service.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tm.core.entity.TmIssueSubscribe;

public class IssueSubscribeHelper {

	public static List<TmIssueSubscribe> getIssueSubscribeEntity(long userIdOwner, long userIdAssignee) {
		TmIssueSubscribe issueSubscribeEntityOwner = new TmIssueSubscribe();
		issueSubscribeEntityOwner.setSubCreated(new Timestamp(new Date().getTime()));
		issueSubscribeEntityOwner.setUserId(userIdOwner);
		
		TmIssueSubscribe issueSubscribeEntityAssignee = new TmIssueSubscribe();
		issueSubscribeEntityAssignee.setSubCreated(new Timestamp(new Date().getTime()));
		issueSubscribeEntityAssignee.setUserId(userIdAssignee);
		
		List<TmIssueSubscribe> issueSubscribeEntityList = new ArrayList<TmIssueSubscribe>();
		issueSubscribeEntityList.add(issueSubscribeEntityOwner);
		issueSubscribeEntityList.add(issueSubscribeEntityAssignee);
		
		return issueSubscribeEntityList;
	}
}
