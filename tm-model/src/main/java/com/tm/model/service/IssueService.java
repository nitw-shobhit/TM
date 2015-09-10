package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.IssueBean;
import com.tm.util.exceptions.BpmException;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueService {

	List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException;

	IssueBean addIssueToModule(IssueBean issueBean) throws BpmException, DtoConversionException;
}