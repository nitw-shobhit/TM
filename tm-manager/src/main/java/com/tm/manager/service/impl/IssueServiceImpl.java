package com.tm.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.tm.core.entity.TmIssue;
import com.tm.core.entity.TmIssueAttachment;
import com.tm.core.entity.TmIssueComment;
import com.tm.core.entity.TmIssueHistory;
import com.tm.core.entity.TmIssueSubscribe;
import com.tm.core.entity.TmNotification;
import com.tm.core.entity.TmNotificationVariable;
import com.tm.core.entity.TmUserInfo;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueDao;
import com.tm.dao.db.NotificationDao;
import com.tm.dao.db.UserDao;
import com.tm.mode.service.helper.IssueHistoryHelper;
import com.tm.mode.service.helper.IssueSubscribeHelper;
import com.tm.mode.service.helper.NotificationHelper;
import com.tm.mode.service.helper.NotificationVariableHelper;
import com.tm.model.bean.ui.IssueAttachmentBean;
import com.tm.model.bean.ui.IssueBean;
import com.tm.model.bean.ui.IssueCommentBean;
import com.tm.model.bean.ui.IssueHistoryBean;
import com.tm.model.bean.ui.IssueStatus;
import com.tm.model.bean.ui.IssueSubscribeBean;
import com.tm.model.service.IssueAttachmentService;
import com.tm.model.service.IssueCommentService;
import com.tm.model.service.IssueHistoryService;
import com.tm.model.service.IssueService;
import com.tm.model.service.IssueSubscribeService;
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
	
	@Resource
	private IssueHistoryService issueHistoryService;
	
	@Resource
	private IssueSubscribeService issueSubscribeService;
	
	@Override
	public List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		List<TmIssue> issueEntityList = issueDao.byModuleId(moduleId);
		List<IssueBean> issueList = new ArrayList<IssueBean>();
		for(TmIssue issueEntity : issueEntityList) {
			IssueBean issueBean = toBean(issueEntity);
			issueBean.setIssAttachments(issueAttachmentService.getIssueAttachments(issueBean.getId()));
			issueBean.setIssComments(issueCommentService.getIssueComments(issueBean.getId()));
			issueBean.setIssHistory(issueHistoryService.getIssueHistory(issueBean.getId()));
			issueBean.setIssSubscribe(issueSubscribeService.getIssueSubscribers(issueBean.getId()));
			issueBean.setUserIdString(userDao.findByPk(issueBean.getUserId()).getUserId());
			issueBean.setIssOwnerString(userDao.findByPk(issueBean.getIssOwner()).getUserId());
			issueBean.setIssStatusCoordinates(IssueStatus.valueOf(issueBean.getIssStatus()).getCoordinates());
			issueList.add(issueBean);
		}
		return issueList;
	}

	@Override
	public IssueBean addIssueToModule(IssueBean issueBean) throws DtoConversionException, DaoException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		NotificationDao notificationDao = (NotificationDao) DaoFactory.generateDao(DaoType.NOTIFICATION);
		
		long userAssigneeId = userService.getUserByUserId(issueBean.getUserIdString()).getId();
		issueBean.setUserId(userAssigneeId);
		issueBean.setIssStatus(IssueStatus.OPEN.toString());
		
		// ISSUE ENTITY
		TmIssue issueEntity = toEntity(issueBean);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueBean.getIssOwner());
		String issueOwner = issueOwnerEntity.getUserId();
		
		// ISSUE COMMENT ENTITY
		TmIssueComment issueCommentEntity = null;
		if(issueBean.getIssComments() != null && !issueBean.getIssComments().isEmpty()) {
			issueCommentEntity = issueCommentService.toEntity(issueBean.getIssComments().get(0));
		}
		
		// ISSUE ATTACHMENT ENTITY
		List<TmIssueAttachment> issueAttachmentEntityList = null;
		if(issueBean.getIssAttachments() != null) {
			issueAttachmentEntityList = new ArrayList<TmIssueAttachment>();
			for(IssueAttachmentBean issueAttachmentBean : issueBean.getIssAttachments()) {
				issueAttachmentBean.setUserId(issueBean.getIssOwner());
				issueAttachmentEntityList.add(issueAttachmentService.toEntity(issueAttachmentBean));
			}
		}
		
		// ISSUE HISTORY ENTITY
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_CREATE);
		
		// ISSUE SUBSCRIBE ENTITY
		List<TmIssueSubscribe> issueSubscribeEntityList = IssueSubscribeHelper.getIssueSubscribeEntity(issueBean.getIssOwner(), issueBean.getUserId());
		
		// ISSUE BEAN
		IssueBean returnIssueBean = toBean(issueDao.addIssueToModule(issueEntity, issueCommentEntity,
				issueAttachmentEntityList, issueHistoryEntity, issueSubscribeEntityList));
		returnIssueBean.setUserIdString(issueBean.getUserIdString());
		returnIssueBean.setIssOwnerString(issueOwner);
		returnIssueBean.setIssStatusCoordinates(IssueStatus.valueOf(returnIssueBean.getIssStatus()).getCoordinates());
		
		// ISSUE COMMENT BEAN
		List<IssueCommentBean> issueCommentBeanList = new ArrayList<IssueCommentBean>();
		IssueCommentBean issueCommentBean = issueCommentService.toBean(issueCommentEntity);
		issueCommentBean.setUserIdString(issueOwner);
		issueCommentBeanList.add(issueCommentBean);
		
		// ISSUE HISTORY BEAN
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties().getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_CREATE.getValue(), IssueHistoryService.DEFAULT_MESSG));
		List<IssueHistoryBean> issueHistoryBeanList = new ArrayList<IssueHistoryBean>();
		issueHistoryBeanList.add(issueHistoryBean);
		
		// ISSUE SUBSCRIBE BEAN
		List<IssueSubscribeBean> issueSubscribeBeanList = new ArrayList<IssueSubscribeBean>();
		for(TmIssueSubscribe issueSubscribeEntity : issueSubscribeEntityList) {
			IssueSubscribeBean issueSubscribeBean = issueSubscribeService.toBean(issueSubscribeEntity);
			if(issueSubscribeBean.getUserId() == issueBean.getIssOwner()) {
				issueSubscribeBean.setUserIdString(issueOwner);
			} else {
				issueSubscribeBean.setUserIdString(issueBean.getUserIdString());
			}
			issueSubscribeBeanList.add(issueSubscribeBean);
		}
		
		returnIssueBean.setIssComments(issueCommentBeanList);
		returnIssueBean.setIssAttachments(issueBean.getIssAttachments());
		returnIssueBean.setIssHistory(issueHistoryBeanList);
		returnIssueBean.setIssSubscribe(issueSubscribeBeanList);
		
		//SEND NOTIFICATION
		TmNotification notificationEntity = NotificationHelper.getNotificationEntity(userAssigneeId, NotificationHelper.NotificationType.NOTIFICATION_ISSUE_CREATE);
		
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("issueId", returnIssueBean.getId());
		variableMap.put("issueOwner", returnIssueBean.getIssOwnerString());
		
		List<TmNotificationVariable> notificationVariableEntityList = NotificationVariableHelper.getNotificationVariables(variableMap);
		
		notificationDao.addNotification(notificationEntity, notificationVariableEntityList);
		
		return returnIssueBean;
	}

	@Override
	public IssueHistoryBean acceptIssue(long issueId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.ACCEPTED.toString());
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueEntity.getIssOwner());
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_ACCEPT);
		issueHistoryEntity.setIssId(issueId);
		issueHistoryEntity = issueDao.updateIssueStatus(issueEntity, issueHistoryEntity);
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties()
				.getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_ACCEPT.getValue(), IssueHistoryService.DEFAULT_MESSG));
		return issueHistoryBean;
	}
	
	@Override
	public IssueHistoryBean rejectIssue(long issueId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.REJECTED.toString());
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueEntity.getIssOwner());
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_REJECT);
		issueHistoryEntity.setIssId(issueId);
		issueHistoryEntity = issueDao.updateIssueStatus(issueEntity, issueHistoryEntity);
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties()
				.getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_REJECT.getValue(), IssueHistoryService.DEFAULT_MESSG));
		return issueHistoryBean;
	}
	
	@Override
	public void reAssignIssue(long issueId, String newUserId) throws DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.OPEN.toString());
		issueEntity.setUserId(userService.getUserByUserId(newUserId).getId());
		issueDao.merge(issueEntity, true);
	}
	

	@Override
	public IssueHistoryBean reOpenIssue(long issueId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.REOPENED.toString());
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueEntity.getIssOwner());
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_REOPEN);
		issueHistoryEntity.setIssId(issueId);
		issueHistoryEntity = issueDao.updateIssueStatus(issueEntity, issueHistoryEntity);
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties()
				.getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_REOPEN.getValue(), IssueHistoryService.DEFAULT_MESSG));
		return issueHistoryBean;
	}

	@Override
	public IssueHistoryBean fixIssue(long issueId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.FIXED.toString());
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueEntity.getIssOwner());
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_MARK_FIXED);
		issueHistoryEntity.setIssId(issueId);
		issueHistoryEntity = issueDao.updateIssueStatus(issueEntity, issueHistoryEntity);
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties()
				.getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_MARK_FIXED.getValue(), IssueHistoryService.DEFAULT_MESSG));
		return issueHistoryBean;
	}
	
	@Override
	public IssueHistoryBean completeIssue(long issueId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.COMPLETED.toString());
		UserDao userDao = (UserDao) DaoFactory.generateDao(DaoType.USER);
		TmUserInfo issueOwnerEntity = userDao.findByPk(issueEntity.getIssOwner());
		TmIssueHistory issueHistoryEntity = IssueHistoryHelper.getHistoryEntity(issueOwnerEntity, IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_COMPLETE);
		issueHistoryEntity.setIssId(issueId);
		issueHistoryEntity = issueDao.updateIssueStatus(issueEntity, issueHistoryEntity);
		IssueHistoryBean issueHistoryBean = issueHistoryService.toBean(issueHistoryEntity);
		issueHistoryBean.setHisContent(issueHistoryService.getHistoryProperties()
				.getProperty(IssueHistoryHelper.IssueHistoryType.ISSUE_HISTORY_COMPLETE.getValue(), IssueHistoryService.DEFAULT_MESSG));
		return issueHistoryBean;
	}
	
	@Override
	public void removeIssue(long issueId) {
		IssueDao issueDao = (IssueDao) DaoFactory.generateDao(DaoType.ISSUE);
		TmIssue issueEntity = issueDao.findByPk(issueId);
		issueEntity.setIssStatus(IssueStatus.CANCELLED.toString());
		issueEntity.setVisible(false);
		issueDao.merge(issueEntity, true);
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

	public IssueHistoryService getIssueHistoryService() {
		return issueHistoryService;
	}

	public void setIssueHistoryService(IssueHistoryService issueHistoryService) {
		this.issueHistoryService = issueHistoryService;
	}

	public IssueSubscribeService getIssueSubscribeService() {
		return issueSubscribeService;
	}

	public void setIssueSubscribeService(IssueSubscribeService issueSubscribeService) {
		this.issueSubscribeService = issueSubscribeService;
	}
}
