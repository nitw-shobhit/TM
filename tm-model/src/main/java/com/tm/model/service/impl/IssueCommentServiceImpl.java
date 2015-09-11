package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tm.core.bean.IssueCommentBean;
import com.tm.core.entity.TmIssueComment;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.db.IssueCommentDao;
import com.tm.dao.db.UserDao;
import com.tm.model.service.IssueCommentService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.exceptions.DtoConversionException;

public class IssueCommentServiceImpl extends DtoAssemblerFacadeImpl<TmIssueComment, IssueCommentBean> implements IssueCommentService {
	
	@Override
	public List<IssueCommentBean> getIssueComments(long issueId) throws DtoConversionException {
		IssueCommentDao issueCommentDao = (IssueCommentDao) DaoFactory.generateService(DaoType.ISSUE_COMMENT);
		UserDao userDao = (UserDao) DaoFactory.generateService(DaoType.USER);
		List<TmIssueComment> issueCommentEntityList = issueCommentDao.byIssueId(issueId);
		List<IssueCommentBean> issueCommentBeanList = new ArrayList<IssueCommentBean>();
		for(TmIssueComment issueCommentEntity : issueCommentEntityList) {
			IssueCommentBean issueCommentBean = toBean(issueCommentEntity);
			issueCommentBean.setUserIdString(userDao.findByPk(issueCommentBean.getUserId()).getUserId());
			issueCommentBeanList.add(issueCommentBean);
		}
		return issueCommentBeanList;
	}
}
