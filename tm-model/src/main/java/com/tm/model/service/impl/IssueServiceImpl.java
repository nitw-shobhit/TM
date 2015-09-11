package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.tm.core.bean.IssueAttachmentBean;
import com.tm.core.bean.IssueBean;
import com.tm.core.bean.IssueCommentBean;
import com.tm.core.bean.IssueStatus;
import com.tm.core.entity.TmIssue;
import com.tm.core.entity.TmIssueAttachment;
import com.tm.core.entity.TmIssueComment;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueAttachmentDao;
import com.tm.dao.db.IssueCommentDao;
import com.tm.dao.db.IssueDao;
import com.tm.dao.db.UserDao;
import com.tm.model.service.IssueAttachmentService;
import com.tm.model.service.IssueCommentService;
import com.tm.model.service.IssueService;
import com.tm.model.service.UserService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public class IssueServiceImpl extends DtoAssemblerFacadeImpl<TmIssue, IssueBean> implements IssueService {

	@Resource
	private UserService userService;
	
	@Resource
	private IssueAttachmentService issueAttachmentService;
	
	@Resource
	private IssueCommentService issueCommentService;
	
	@Override
	public List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<TmIssue> issueEntityList = issueDao.byModuleId(moduleId);
		List<IssueBean> issueList = new ArrayList<IssueBean>();
		for(TmIssue issueEntity : issueEntityList) {
			IssueBean issueBean = toBean(issueEntity);
			issueBean.setIssAttachments(issueAttachmentService.getIssueAttachments(issueBean.getId()));
			issueBean.setIssComments(issueCommentService.getIssueComments(issueBean.getId()));
			issueBean.setUserIdString(userDao.findByPk(issueBean.getUserId()).getUserId());
			issueBean.setIssOwnerString(userDao.findByPk(issueBean.getIssOwner()).getUserId());
			issueList.add(issueBean);
		}
		return issueList;
	}

	@Override
	public IssueBean addIssueToModule(IssueBean issueBean) throws DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		IssueCommentDao issueCommentDao = (IssueCommentDao) DaoFactory.generateService(DaoType.ISSUE_COMMENT);
		IssueAttachmentDao issueAttachmentDao = (IssueAttachmentDao) DaoFactory.generateService(DaoType.ISSUE_ATTACHMENT);
		IssueBean returnIssueBean = null;
		//Issue
		issueBean.setUserId(userService.getUserByUserId(issueBean.getUserIdString()).getId());
		issueBean.setIssStatus(IssueStatus.OPEN.toString());
		issueBean.setVisible(true);
		TmIssue issueEntity = toEntity(issueBean);
		issueDao.persist(issueEntity);
		returnIssueBean = toBean(issueEntity);
		//Issue Comment
		if(issueBean.getIssComments() != null && !issueBean.getIssComments().isEmpty()) {
			IssueCommentBean issueCommentBean = issueBean.getIssComments().get(0);
			issueCommentBean.setIssId(issueEntity.getId());
			issueCommentBean.setVisible(true);
			TmIssueComment issueCommentEntity = issueCommentService.toEntity(issueCommentBean);
			issueCommentDao.persist(issueCommentEntity);
			returnIssueBean.addIssueComment(issueCommentService.toBean(issueCommentEntity));
		}
		//Issue Attachment
		if(issueBean.getIssAttachments() != null) {
			for(IssueAttachmentBean issueAttachmentBean : issueBean.getIssAttachments()) {
				issueAttachmentBean.setIssId(issueEntity.getId());
				issueAttachmentBean.setVisible(true);
				TmIssueAttachment issueAttachmentEntity = issueAttachmentService.toEntity(issueAttachmentBean);
				issueAttachmentDao.persist(issueAttachmentEntity);
				returnIssueBean.addIssueAttachment(issueAttachmentService.toBean(issueAttachmentEntity));
			}
		}
		return returnIssueBean;
	}

	public IssueAttachmentService getIssueAttachmentService() {
		return issueAttachmentService;
	}

	public void setIssueAttachmentService(
			IssueAttachmentService issueAttachmentService) {
		this.issueAttachmentService = issueAttachmentService;
	}

	public IssueCommentService getIssueCommentService() {
		return issueCommentService;
	}

	public void setIssueCommentService(IssueCommentService issueCommentService) {
		this.issueCommentService = issueCommentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
