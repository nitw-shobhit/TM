package com.tm.model.bean.ui;

import java.io.Serializable;
import java.sql.Timestamp;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public class IssueHistoryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String hisContent;

	@DtoField
	private Timestamp hisCreated;
	
	@DtoField
	private String hisUser;

	@DtoField
	private long issId;

	public IssueHistoryBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHisContent() {
		return this.hisContent;
	}

	public void setHisContent(String hisContent) {
		this.hisContent = hisContent;
	}

	public Timestamp getHisCreated() {
		return this.hisCreated;
	}

	public void setHisCreated(Timestamp hisCreated) {
		this.hisCreated = hisCreated;
	}

	public long getIssId() {
		return this.issId;
	}

	public void setIssId(long issId) {
		this.issId = issId;
	}

	public String getHisUser() {
		return hisUser;
	}

	public void setHisUser(String hisUser) {
		this.hisUser = hisUser;
	}
}