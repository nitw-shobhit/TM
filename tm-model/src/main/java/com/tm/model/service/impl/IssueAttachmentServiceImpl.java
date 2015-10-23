package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.entity.TmIssueAttachment;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueAttachmentDao;
import com.tm.dao.db.UserDao;
import com.tm.model.bean.ui.IssueAttachmentBean;
import com.tm.model.service.IssueAttachmentService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class IssueAttachmentServiceImpl extends DtoAssemblerFacadeImpl<TmIssueAttachment, IssueAttachmentBean> implements IssueAttachmentService {

	@Override
	public List<IssueAttachmentBean> getIssueAttachments(long issueId) throws DtoConversionException {
		IssueAttachmentDao issueAttachmentDao = (IssueAttachmentDao) DaoFactory.generateService(DaoType.ISSUE_ATTACHMENT);
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<TmIssueAttachment> issueAttachmentEntityList = issueAttachmentDao.byIssueId(issueId);
		List<IssueAttachmentBean> issueAttachmentBeanList = new ArrayList<IssueAttachmentBean>();
		for(TmIssueAttachment issueAttachmentEntity : issueAttachmentEntityList) {
			IssueAttachmentBean issueAttachmentBean = toBean(issueAttachmentEntity);
			issueAttachmentBean.setUserIdString(userDao.findByPk(issueAttachmentBean.getUserId()).getUserId());
			issueAttachmentBeanList.add(issueAttachmentBean);
		}
		return issueAttachmentBeanList;
	}
}
