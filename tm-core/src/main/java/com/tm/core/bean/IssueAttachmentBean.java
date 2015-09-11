package com.tm.core.bean;

import java.io.Serializable;
import java.sql.Blob;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class IssueAttachmentBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private Blob attContent;

	@DtoField
	private long issId;

	@DtoField
	private long userId;
	
	private String userIdString;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Blob getAttContent() {
		return attContent;
	}

	public void setAttContent(Blob attContent) {
		this.attContent = attContent;
	}

	public long getIssId() {
		return issId;
	}

	public void setIssId(long issId) {
		this.issId = issId;
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
	
}
