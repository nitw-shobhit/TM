package com.tm.model.service;

import java.util.List;

import com.tm.core.entity_sql.TmIssueAttachment;
import com.tm.model.bean.ui.IssueAttachmentBean;
import com.tm.util.assembler.DtoAssemblerFacade;
import com.tm.util.exceptions.DtoConversionException;


public interface IssueAttachmentService extends DtoAssemblerFacade<TmIssueAttachment, IssueAttachmentBean> {
	
	List<IssueAttachmentBean> getIssueAttachments(long issueId) throws DtoConversionException;
}
