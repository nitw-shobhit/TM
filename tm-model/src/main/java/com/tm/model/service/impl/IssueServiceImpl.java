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
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		IssueCommentDao issueCommentDao = (IssueCommentDao) DaoFactory.generateService(DaoType.ISSUE_COMMENT);
		IssueAttachmentDao issueAttachmentDao = (IssueAttachmentDao) DaoFactory.generateService(DaoType.ISSUE_ATTACHMENT);
		IssueBean returnIssueBean = null;
		//Issue
		issueBean.setUserId(userService.getUserByUserId(issueBean.getUserIdString()).getId());
		issueBean.setIssStatus(IssueStatus.OPEN.toString());
		TmIssue issueEntity = toEntity(issueBean);
		issueDao.persist(issueEntity);
		returnIssueBean = toBean(issueEntity);
		returnIssueBean.setUserIdString(issueBean.getUserIdString());
		String issueOwner = userDao.findByPk(issueBean.getIssOwner()).getUserId();
		returnIssueBean.setIssOwnerString(issueOwner);
		//Issue Comment
		if(issueBean.getIssComments() != null && !issueBean.getIssComments().isEmpty()) {
			IssueCommentBean issueCommentBean = issueBean.getIssComments().get(0);
			issueCommentBean.setIssId(issueEntity.getId());
			TmIssueComment issueCommentEntity = issueCommentService.toEntity(issueCommentBean);
			issueCommentDao.persist(issueCommentEntity);
			issueCommentBean = issueCommentService.toBean(issueCommentEntity);
			issueCommentBean.setUserIdString(issueOwner);
			returnIssueBean.addIssueComment(issueCommentBean);
		}
		//Issue Attachment
		if(issueBean.getIssAttachments() != null) {
			for(IssueAttachmentBean issueAttachmentBean : issueBean.getIssAttachments()) {
				issueAttachmentBean.setIssId(issueEntity.getId());
				TmIssueAttachment issueAttachmentEntity = issueAttachmentService.toEntity(issueAttachmentBean);
				issueAttachmentDao.persist(issueAttachmentEntity);
				issueAttachmentBean = issueAttachmentService.toBean(issueAttachmentEntity);
				issueAttachmentBean.setUserIdString(issueOwner);
				returnIssueBean.addIssueAttachment(issueAttachmentBean);
			}
		}
		return returnIssueBean;
	}

	@Override
	public void acceptIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.ACCEPTED.toString());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void rejectIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.REJECTED.toString());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void reAssignIssue(long issueId, String newUserId) throws DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.OPEN.toString());
		issueEntity.setUserId(userService.getUserByUserId(newUserId).getId());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void reopenIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.REOPENED.toString());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void markAsFixedIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.FIXED.toString());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void completeIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.COMPLETED.toString());
		issueDao.merge(issueEntity);
	}
	
	@Override
	public void removeIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.CANCELLED.toString());
		issueEntity.setVisible(false);
		issueDao.merge(issueEntity);
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
