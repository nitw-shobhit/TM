package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.IssueBean;
import com.tm.core.bean.IssueHistoryBean;
import com.tm.model.service.IssueService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmIssue")
public class IssueController {
	
	@Resource
	private IssueService issueService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getIssuesByModule")
	public @ResponseBody String getIssuesByModule(@RequestParam("moduleId") long moduleId) throws InternalApplicationException {
		List<IssueBean> issueBeanList = null;
		try {
			issueBeanList = issueService.getIssuesByModule(moduleId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(issueBeanList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addIssueToModule")
	public @ResponseBody String addIssueToModule(@RequestParam("issueBean") String jsonObj) throws InternalApplicationException {
		IssueBean issueBean = null;
		try {
			issueBean = (IssueBean) JsonUtils.toPojo(jsonObj, IssueBean.class);
			issueBean = issueService.addIssueToModule(issueBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(issueBean);
	} 
	
	@RequestMapping(method = RequestMethod.POST, value="/acceptIssue")
	public @ResponseBody String acceptIssue(@RequestParam("id") long issueId) throws InternalApplicationException {
		IssueHistoryBean issueHistoryBean = null;
		try {
			issueHistoryBean = issueService.acceptIssue(issueId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(issueHistoryBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/rejectIssue")
	public @ResponseBody String rejectIssue(@RequestParam("id") long issueId) throws InternalApplicationException {
		IssueHistoryBean issueHistoryBean = null;
		try {
			issueHistoryBean = issueService.rejectIssue(issueId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(issueHistoryBean);
	}
	
	public IssueService getIssueService() {
		return issueService;
	}

	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}
}
