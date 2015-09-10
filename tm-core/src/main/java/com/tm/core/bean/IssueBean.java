package com.tm.core.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

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
	private Timestamp issDuedate;

	@DtoField
	private String issName;

	@DtoField
	private String issPriority;

	@DtoField
	private String issStatus;

	@DtoField
	private long modId;

	@DtoField
	private String userId;
	
	private List<CommentBean> issComments;
	
	private List<Blob> issAttachments;
	
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

	public Timestamp getIssDuedate() {
		return issDuedate;
	}

	public void setIssDuedate(Timestamp issDuedate) {
		this.issDuedate = issDuedate;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<CommentBean> getIssComments() {
		return issComments;
	}

	public void setIssComments(List<CommentBean> issComments) {
		this.issComments = issComments;
	}

	public List<Blob> getIssAttachments() {
		return issAttachments;
	}

	public void setIssAttachments(List<Blob> issAttachments) {
		this.issAttachments = issAttachments;
	}
}
