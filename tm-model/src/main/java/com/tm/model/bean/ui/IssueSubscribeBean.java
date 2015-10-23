package com.tm.model.bean.ui;

import java.io.Serializable;
import java.sql.Timestamp;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class IssueSubscribeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private long issId;

	@DtoField
	private Timestamp subCreated;

	@DtoField
	private long userId;
	
	private String userIdString;

	public IssueSubscribeBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIssId() {
		return this.issId;
	}

	public void setIssId(long issId) {
		this.issId = issId;
	}

	public Timestamp getSubCreated() {
		return this.subCreated;
	}

	public void setSubCreated(Timestamp subCreated) {
		this.subCreated = subCreated;
	}

	public long getUserId() {
		return this.userId;
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