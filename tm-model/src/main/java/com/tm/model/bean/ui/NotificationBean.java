package com.tm.model.bean.ui;

import java.io.Serializable;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.tm.model.bean.BaseBean;

@Dto
public class NotificationBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String notContent;

	@DtoField
	private boolean notIsUnread;

	@DtoField
	private long userId;
	
	private String notSubject;
	
	private String notFooter;
	
	public NotificationBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotContent() {
		return this.notContent;
	}

	public void setNotContent(String notContent) {
		this.notContent = notContent;
	}

	public boolean getNotIsUnread() {
		return this.notIsUnread;
	}

	public void setNotIsUnread(boolean notIsUnread) {
		this.notIsUnread = notIsUnread;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNotSubject() {
		return notSubject;
	}

	public void setNotSubject(String notSubject) {
		this.notSubject = notSubject;
	}

	public String getNotFooter() {
		return notFooter;
	}

	public void setNotFooter(String notFooter) {
		this.notFooter = notFooter;
	}
}