package com.tm.model.bean;

import java.sql.Timestamp;

import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

public class BaseBean {

	@DtoField
	protected boolean visible;
	
	@DtoField
	protected Timestamp dtCreated;
	
	@DtoField
	protected Timestamp dtModified;

	public Timestamp getDtCreated() {
		return this.dtCreated;
	}

	public void setDtCreated(Timestamp dtCreated) {
		this.dtCreated = dtCreated;
	}

	public Timestamp getDtModified() {
		return this.dtModified;
	}

	public void setDtModified(Timestamp dtModified) {
		this.dtModified = dtModified;
	}
	
	public boolean getVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
