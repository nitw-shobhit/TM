package com.tm.model.service;

import java.util.List;

import com.tm.core.bean.IssueCommentBean;
import com.tm.core.entity.TmIssueComment;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;

public interface IssueCommentService extends DtoAssemblerFacade<TmIssueComment, IssueCommentBean> {

	List<IssueCommentBean> getIssueComments(long issueId) throws DtoConversionException;

	IssueCommentBean addCommentToIssue(IssueCommentBean issueCommentBean) throws DtoConversionException;
}
