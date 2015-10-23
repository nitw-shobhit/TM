package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tm.core.entity.TmIssueHistory;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueHistoryDao;
import com.tm.model.bean.ui.IssueHistoryBean;
import com.tm.model.service.IssueHistoryService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;
import com.tm.util.exceptions.FileLoadException;
import com.tm.util.file.PropertyUtils;

public class IssueHistoryServiceImpl extends DtoAssemblerFacadeImpl<TmIssueHistory, IssueHistoryBean> implements IssueHistoryService {
	
	static Properties historyProp;
	
	static {
		try {
			historyProp = PropertyUtils.loadProperties("issue/history/activity_en.properties");
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<IssueHistoryBean> getIssueHistory(long issueId) throws DtoConversionException {
		IssueHistoryDao issueHistoryDao = (IssueHistoryDao) DaoFactory.generateService(DaoType.ISSUE_HISTORY);
		List<TmIssueHistory> issueHistoryEntityList = issueHistoryDao.byIssueId(issueId);
		List<IssueHistoryBean> issueHistoryBeanList = new ArrayList<IssueHistoryBean>();
		for(TmIssueHistory issueHistoryEntity : issueHistoryEntityList) {
			IssueHistoryBean issueHistoryBean = toBean(issueHistoryEntity);
			issueHistoryBean.setHisContent(historyProp.getProperty(issueHistoryBean.getHisContent(), DEFAULT_MESSG));
			issueHistoryBeanList.add(issueHistoryBean);
		}
		return issueHistoryBeanList;
	}
	
	@Override
	public Properties getHistoryProperties() {
		return historyProp;
	}
}
