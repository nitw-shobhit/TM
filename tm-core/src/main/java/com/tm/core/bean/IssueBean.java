package com.tm.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class IssueBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@DtoField
	private long id;

	@DtoField
	private String issDesc;

	@DtoField
	private String issName;

	@DtoField
	private String issPriority;

	@DtoField
	private String issStatus;

	@DtoField
	private long modId;

	@DtoField
	private long userId;
	
	private String userIdString;
	
	@DtoField
	private long issOwner;
	
	private String issOwnerString;
	
	private List<IssueCommentBean> issComments;
	
	private List<IssueAttachmentBean> issAttachments;
	
	private List<IssueHistoryBean> issHistory;
	
	private List<IssueSubscribeBean> issSubscribe;
	
	private Map<String, Integer> issStatusCoordinates;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIssDesc() {
		return issDesc;
	}

	public void setIssDesc(String issDesc) {
		this.issDesc = issDesc;
	}

	public String getIssName() {
		return issName;
	}

	public void setIssName(String issName) {
		this.issName = issName;
	}

	public String getIssPriority() {
		return issPriority;
	}

	public void setIssPriority(String issPriority) {
		this.issPriority = issPriority;
	}

	public String getIssStatus() {
		return issStatus;
	}

	public void setIssStatus(String issStatus) {
		this.issStatus = issStatus;
	}

	public long getModId() {
		return modId;
	}

	public void setModId(long modId) {
		this.modId = modId;
	}

	public List<IssueCommentBean> getIssComments() {
		return issComments;
	}

	public void setIssComments(List<IssueCommentBean> issComments) {
		this.issComments = issComments;
	}

	public List<IssueAttachmentBean> getIssAttachments() {
		return issAttachments;
	}

	public void setIssAttachments(List<IssueAttachmentBean> issAttachments) {
		this.issAttachments = issAttachments;
	}

	public void addIssueComment(IssueCommentBean issueCommentBean) {
		if(this.issComments == null) {
			this.issComments = new ArrayList<IssueCommentBean>();
		}
		this.issComments.add(issueCommentBean);
	}

	public void addIssueAttachment(IssueAttachmentBean issAttachmentBean) {
		if(this.issAttachments == null) {
			this.issAttachments = new ArrayList<IssueAttachmentBean>();
		}
		this.issAttachments.add(issAttachmentBean);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserIdString() {
		return userIdString;
	}

	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}

	public long getIssOwner() {
		return issOwner;
	}

	public void setIssOwner(long issOwner) {
		this.issOwner = issOwner;
	}

	public String getIssOwnerString() {
		return issOwnerString;
	}

	public void setIssOwnerString(String issOwnerString) {
		this.issOwnerString = issOwnerString;
	}

	public List<IssueHistoryBean> getIssHistory() {
		return issHistory;
	}

	public void setIssHistory(List<IssueHistoryBean> issHistory) {
		this.issHistory = issHistory;
	}

	public List<IssueSubscribeBean> getIssSubscribe() {
		return issSubscribe;
	}

	public void setIssSubscribe(List<IssueSubscribeBean> issSubscribe) {
		this.issSubscribe = issSubscribe;
	}

	public Map<String, Integer> getIssStatusCoordinates() {
		return issStatusCoordinates;
	}

	public void setIssStatusCoordinates(Map<String, Integer> issStatusCoordinates) {
		this.issStatusCoordinates = issStatusCoordinates;
	}
}
