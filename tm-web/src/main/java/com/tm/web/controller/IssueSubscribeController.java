package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.ui.IssueSubscribeBean;
import com.tm.model.service.IssueSubscribeService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmSubscribeIssue")
public class IssueSubscribeController {
	
	@Resource
	private IssueSubscribeService issueSubscribeService;
	
	@RequestMapping(method = RequestMethod.POST, value="/addSubscription")
	public @ResponseBody String addSubscription(@RequestParam("userId") long userId,
			@RequestParam("issueId") long issueId) throws InternalApplicationException {
		IssueSubscribeBean issueSubscribeBean = null;
		try {
			issueSubscribeBean = issueSubscribeService.addSubscription(userId, issueId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		
		return JsonUtils.toJson(issueSubscribeBean);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/removeSubscription")
	public @ResponseBody void removeSubscription(@RequestParam("issueSubscribeId") long id) throws InternalApplicationException {
			issueSubscribeService.removeSubscription(id);
	}

	public IssueSubscribeService getIssueSubscribeService() {
		return issueSubscribeService;
	}

	public void setIssueSubscribeService(IssueSubscribeService issueSubscribeService) {
		this.issueSubscribeService = issueSubscribeService;
	}
}
