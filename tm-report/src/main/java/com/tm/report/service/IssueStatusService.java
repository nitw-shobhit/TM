package com.tm.report.service;

import java.util.ArrayList;
import java.util.List;

import com.tm.report.bean.IssueStatusBean;

public class IssueStatusService {

public List<IssueStatusBean> getIssueStatusData() {
		
		IssueStatusBean issueStatusBean1 = new IssueStatusBean();
		issueStatusBean1.setRepIssueStatus("OPEN");
		issueStatusBean1.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean2 = new IssueStatusBean();
		issueStatusBean2.setRepIssueStatus("ACCEPTED");
		issueStatusBean2.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean3 = new IssueStatusBean();
		issueStatusBean3.setRepIssueStatus("REJECTED");
		issueStatusBean3.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean4 = new IssueStatusBean();
		issueStatusBean4.setRepIssueStatus("REOPENED");
		issueStatusBean4.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean5 = new IssueStatusBean();
		issueStatusBean5.setRepIssueStatus("FIXED");
		issueStatusBean5.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean6 = new IssueStatusBean();
		issueStatusBean6.setRepIssueStatus("COMPLETED");
		issueStatusBean6.setRepNumIssues(20);
		
		IssueStatusBean issueStatusBean7 = new IssueStatusBean();
		issueStatusBean7.setRepIssueStatus("CANCELLED");
		issueStatusBean7.setRepNumIssues(20);
		
		List<IssueStatusBean> issueStatusBeanList = new ArrayList<IssueStatusBean>();
		issueStatusBeanList.add(issueStatusBean1);
		issueStatusBeanList.add(issueStatusBean2);
		issueStatusBeanList.add(issueStatusBean3);
		issueStatusBeanList.add(issueStatusBean4);
		issueStatusBeanList.add(issueStatusBean5);
		issueStatusBeanList.add(issueStatusBean6);
		issueStatusBeanList.add(issueStatusBean7);
		
		return issueStatusBeanList;
	}
}
