package com.tm.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.tm.core.bean.IssueBean;
import com.tm.core.entity.TmIssue;
import com.tm.dao.DaoFactory;
import com.tm.dao.DaoType;
import com.tm.dao.bpm.BpmDao;
import com.tm.dao.db.IssueDao;
import com.tm.model.service.IssueService;
import com.tm.util.assembler.impl.DtoAssemblerFacadeImpl;
import com.tm.util.bpm.RequestType;
import com.tm.util.exceptions.BpmException;
import com.tm.util.exceptions.DaoException;
import com.tm.util.exceptions.DtoConversionException;

public class IssueServiceImpl extends DtoAssemblerFacadeImpl<TmIssue, IssueBean> implements IssueService {

	@Override
	public List<IssueBean> getIssuesByModule(long moduleId) throws DaoException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		List<TmIssue> issueEntityList = issueDao.byModuleId(moduleId);
		List<IssueBean> issueList = new ArrayList<IssueBean>();
		for(TmIssue issueEntity : issueEntityList) {
			issueList.add(toBean(issueEntity));
		}
		return issueList;
	}

	@Override
	@Transactional
	public IssueBean addIssueToModule(IssueBean issueBean) throws BpmException, DtoConversionException {
		IssueDao issueDao = (IssueDao) DaoFactory.generateService(DaoType.ISSUE);
		BpmDao bpmDao = (BpmDao) DaoFactory.generateService(DaoType.BPM);
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put("user", issueBean.getUserId());
		try {
			long processInstanceId = bpmDao.createRequest(RequestType.ISSUE_REQUEST, processVariables);
			TmIssue issueEntity = new TmIssue();
			issueEntity.setModId(issueBean.getModId());
			issueEntity.setProcId(processInstanceId);
			issueDao.persist(issueEntity);
		} catch (Exception e) {
			throw new BpmException(e);
		} 
		return issueBean;
	}
}
