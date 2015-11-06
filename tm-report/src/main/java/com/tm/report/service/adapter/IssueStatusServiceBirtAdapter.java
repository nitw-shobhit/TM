package com.tm.report.service.adapter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.tm.report.bean.IssueStatusBean;
import com.tm.report.service.IssueStatusService;


public class IssueStatusServiceBirtAdapter {
	
	Iterator<IssueStatusBean> iterator;
	
	public void open(Object appContext, Map<String, Object> dataSetParamValues) {
		List<IssueStatusBean> issueStatusBeanList = new IssueStatusService().getIssueStatusData((Integer)(dataSetParamValues.get("project_id")));
		iterator = issueStatusBeanList.iterator();
	}
	
	public Object next() {
		if(iterator.hasNext()) {
			return iterator.next();
		}
		
		return null;
	}
	
	public void close() {
		iterator = null;
	}
}
