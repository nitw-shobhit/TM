package com.tm.model.service;

import java.util.List;

import com.tm.core.entity.TmIssue;
import com.tm.model.bean.ui.IssueBean;
import com.tm.model.bean.ui.IssueHistoryBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueService extends DtoAssemblerFacade<TmIssue, IssueBean> {

	List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException;

	IssueBean addIssueToModule(IssueBean issueBean) throws DtoConversionException, DaoException;

	IssueHistoryBean acceptIssue(long issueId) throws DaoException, DtoConversionException;

	IssueHistoryBean rejectIssue(long issueId) throws DaoException, DtoConversionException;

	void reAssignIssue(long issueId, String newUserId) throws DtoConversionException;

	IssueHistoryBean completeIssue(long issueId) throws DaoException, DtoConversionException;

	void removeIssue(long issueId);

	IssueHistoryBean reOpenIssue(long issueId) throws DaoException, DtoConversionException;

	IssueHistoryBean fixIssue(long issueId) throws DaoException, DtoConversionException;
}
