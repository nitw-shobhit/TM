package com.tm.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.core.entity_sql.TmIssue;
import com.tm.core.entity_sql.TmModule;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db_sql.IssueDao;
import com.tm.dao.db_sql.ModuleDao;
import com.tm.model.bean.ui.IssueStatus;
import com.tm.report.bean.IssueStatusBean;

public class IssueStatusService {

	public List<IssueStatusBean> getIssueStatusData(int projectId) {
		
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		ModuleDao moduleDao = (ModuleDao) DaoFactory.generateDao(DaoType.MODULE);
		
		List<TmModule> moduleEntities = moduleDao.byProjectId(projectId);
		List<Integer> moduleIdList = new ArrayList<Integer>();
		for(TmModule moduleEntity : moduleEntities) {
			moduleIdList.add((int) moduleEntity.getId());
		}
		
		List<TmIssue> issueEntities = issueDao.findAll();

		Map<String, Integer> issueCountMap = new HashMap<String, Integer>();
		
		for(IssueStatus status : IssueStatus.values()) {
			issueCountMap.put(status.name(), 0);
		}
		
		for(TmIssue issueEntity : issueEntities) {
			if(moduleIdList.contains((int)issueEntity.getModId())) {
				issueCountMap.put(issueEntity.getIssStatus(), issueCountMap.get(issueEntity.getIssStatus()) + 1);
			}
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
