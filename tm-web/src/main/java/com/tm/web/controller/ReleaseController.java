package com.tm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.bean.ui.ReleaseBean;
import com.tm.model.service.ReleaseService;
import com.tm.util.exceptions.InternalApplicationException;
import com.tm.util.spring.JsonUtils;

@Controller
@RequestMapping("/tmRelease")
public class ReleaseController {
	
	@Resource
	private ReleaseService releaseService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getReleasesByModule")
	public @ResponseBody String getReleasesByModule(@RequestParam("moduleId") long moduleId) throws InternalApplicationException {
		List<ReleaseBean> releaseBeanList = null;
		try {
			releaseBeanList = releaseService.getReleasesByModule(moduleId);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(releaseBeanList);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addReleaseToModule")
	public @ResponseBody String addIssueToModule(@RequestParam("releaseBean") String jsonObj) throws InternalApplicationException {
		ReleaseBean releaseBean = null;
		try {
			releaseBean = (ReleaseBean) JsonUtils.toPojo(jsonObj, ReleaseBean.class);
			releaseBean = releaseService.addReleaseToModule(releaseBean);
		} catch(Exception e) {
			throw new InternalApplicationException("Something went wrong with the application", e);
		}
		return JsonUtils.toJson(releaseBean);
	} 
	
	public ReleaseService getReleaseService() {
		return releaseService;
	}

	public void setReleaseService(ReleaseService releaseService) {
		this.releaseService = releaseService;
	}
}
