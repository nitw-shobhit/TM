package com.tm.core.bean;

import java.io.Serializable;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class ReleaseBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private long modId;

	@DtoField
	private String relDesc;

	@DtoField
	private String relName;

	@DtoField
	private String relStatus;

	@DtoField
	private long userId;
	
	private String userIdString;

	public ReleaseBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getModId() {
		return this.modId;
	}

	public void setModId(long modId) {
		this.modId = modId;
	}

	public String getRelDesc() {
		return this.relDesc;
	}

	public void setRelDesc(String relDesc) {
		this.relDesc = relDesc;
	}

	public String getRelName() {
		return this.relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getRelStatus() {
		return this.relStatus;
	}

	public void setRelStatus(String relStatus) {
		this.relStatus = relStatus;
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