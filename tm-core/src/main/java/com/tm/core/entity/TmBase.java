package com.tm.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TmBase {

	@Column(name="VISIBLE")
	private boolean visible;
	
	@Column(name="DT_CREATED")
	private Timestamp dtCreated;

	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;
	
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
