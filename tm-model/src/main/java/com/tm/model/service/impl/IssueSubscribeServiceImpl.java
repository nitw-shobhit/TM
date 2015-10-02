package com.tm.model.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tm.core.bean.IssueSubscribeBean;
import com.tm.core.entity.TmIssueSubscribe;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueSubscribeDao;
import com.tm.dao.db.UserDao;
import com.tm.model.service.IssueSubscribeService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class IssueSubscribeServiceImpl extends DtoAssemblerFacadeImpl<TmIssueSubscribe, IssueSubscribeBean> implements IssueSubscribeService {

	@Override
	public List<IssueSubscribeBean> getIssueSubscribers(long issueId) throws DtoConversionException {
		IssueSubscribeDao issueSubscribeDao = (IssueSubscribeDao) DaoFactory.generateService(DaoType.ISSUE_SUBSCRIBE);
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<TmIssueSubscribe> issueSubscribeEntityList = issueSubscribeDao.byIssueId(issueId);
		List<IssueSubscribeBean> issueSubscribeBeanList = new ArrayList<IssueSubscribeBean>();
		for(TmIssueSubscribe issueSubscribeEntity : issueSubscribeEntityList) {
			IssueSubscribeBean issueSubscribeBean = toBean(issueSubscribeEntity);
			issueSubscribeBean.setUserIdString(userDao.findByPk(issueSubscribeBean.getUserId()).getUserId());
			issueSubscribeBeanList.add(issueSubscribeBean);
		}
		return issueSubscribeBeanList;
	}

	@Override
	public IssueSubscribeBean addSubscription(long userId, long issueId) throws DtoConversionException {
		IssueSubscribeDao issueSubscribeDao = (IssueSubscribeDao) DaoFactory.generateService(DaoType.ISSUE_SUBSCRIBE);
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		TmIssueSubscribe issueSubscribeEntity = new TmIssueSubscribe();
		issueSubscribeEntity.setIssId(issueId);
		issueSubscribeEntity.setUserId(userId);
		issueSubscribeEntity.setSubCreated(new Timestamp(new Date().getTime()));
		issueSubscribeDao.persist(issueSubscribeEntity, false);
		IssueSubscribeBean issueSubscribeBean = toBean(issueSubscribeEntity);
		issueSubscribeBean.setUserIdString(userDao.findByPk(issueSubscribeBean.getUserId()).getUserId());
		return issueSubscribeBean;
	}

	@Override
	public void removeSubscription(long id) {
		IssueSubscribeDao issueSubscribeDao = (IssueSubscribeDao) DaoFactory.generateService(DaoType.ISSUE_SUBSCRIBE);
		TmIssueSubscribe issueSubscribeEntity = issueSubscribeDao.findByPk(id);
		issueSubscribeDao.remove(issueSubscribeEntity);
	}
}
