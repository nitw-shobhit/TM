package com.tm.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.core.entity.TmIssue;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueDao;
import com.tm.model.bean.ui.IssueStatus;
import com.tm.report.bean.IssueStatusBean;

public class IssueStatusService {

	public List<IssueStatusBean> getIssueStatusData(int projectId) {
		
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		
		List<TmIssue> issueEntities = issueDao.findAll();

		Map<String, Integer> issueCountMap = new HashMap<String, Integer>();
		
		for(IssueStatus status : IssueStatus.values()) {
			issueCountMap.put(status.name(), 0);
		}
		
		for(TmIssue issueEntity : issueEntities) {
			issueCountMap.put(issueEntity.getIssStatus(), issueCountMap.get(issueEntity.getIssStatus()) + 1);
		}
		
		List<IssueStatusBean> issueStatusBeanList = new ArrayList<IssueStatusBean>();
		
		for(Map.Entry<String, Integer> entry : issueCountMap.entrySet()) {
			IssueStatusBean issueStatusBean = new IssueStatusBean();
			issueStatusBean.setRepIssueStatus(entry.getKey());
			issueStatusBean.setRepNumIssues(entry.getValue());
			issueStatusBeanList.add(issueStatusBean);
		}
		
		return issueStatusBeanList;
	}
}
