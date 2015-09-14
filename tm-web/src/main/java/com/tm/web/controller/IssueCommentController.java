package com.tm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.core.bean.IssueCommentBean;
import com.tm.model.service.IssueCommentService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmCommentIssue")
public class IssueCommentController {
	
	@Resource
	private IssueCommentService issueCommentService;
	
	@RequestMapping(method = RequestMethod.POST, value="/addCommentToIssue")
	public @ResponseBody String addCommentToIssue(@RequestParam("issueCommentBean") String jsonObj) throws InternalApplicationException {
		IssueCommentBean issueCommentBean = null;
		try {
			issueCommentBean = (IssueCommentBean) JsonUtils.toPojo(jsonObj, IssueCommentBean.class);
			issueCommentBean = issueCommentService.addCommentToIssue(issueCommentBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(issueCommentBean);
	}

	public IssueCommentService getIssueCommentService() {
		return issueCommentService;
	}

	public void setIssueCommentService(IssueCommentService issueCommentService) {
		this.issueCommentService = issueCommentService;
	} 
}
