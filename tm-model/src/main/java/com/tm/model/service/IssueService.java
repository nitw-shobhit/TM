package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.IssueBean;
import com.tm.core.bean.IssueHistoryBean;
import com.tm.core.entity.TmIssue;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueService extends DtoAssemblerFacade<TmIssue, IssueBean> {

	List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException;

	IssueBean addIssueToModule(IssueBean issueBean) throws DtoConversionException, DaoException;

	IssueHistoryBean acceptIssue(long issueId) throws DaoException, DtoConversionException;

	void rejectIssue(long issueId);

	void reAssignIssue(long issueId, String newUserId) throws DtoConversionException;

	void reopenIssue(long issueId);

	void markAsFixedIssue(long issueId);

	void completeIssue(long issueId);

	void removeIssue(long issueId);
}
