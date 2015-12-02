package com.tm.model.service;

import java.util.List;
import java.util.Properties;

import com.tm.core.entity_sql.TmIssueHistory;
import com.tm.model.bean.ui.IssueHistoryBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueHistoryService extends DtoAssemblerFacade<TmIssueHistory, IssueHistoryBean> {

	static String DEFAULT_MESSG = " updated the issue";
	
	List<IssueHistoryBean> getIssueHistory(long issueId) throws DtoConversionException;

	Properties getHistoryProperties();
}
