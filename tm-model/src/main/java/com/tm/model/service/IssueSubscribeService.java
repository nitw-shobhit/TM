package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.IssueSubscribeBean;
import com.tm.core.entity.TmIssueSubscribe;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueSubscribeService extends DtoAssemblerFacade<TmIssueSubscribe, IssueSubscribeBean> {

	List<IssueSubscribeBean> getIssueSubscribers(long id) throws DtoConversionException;

	IssueSubscribeBean addSubscription(long userId, long issueId) throws DtoConversionException;

	void removeSubscription(long id);
}
