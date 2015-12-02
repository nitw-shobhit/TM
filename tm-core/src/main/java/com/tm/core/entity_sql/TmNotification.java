package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tm_notification database table.
 * 
 */
@Entity
@Table(name="tm_notification")
@NamedQuery(name="TmNotification.findAll", query="SELECT t FROM TmNotification t")
public class TmNotification extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="NOT_CONTENT")
	private String notContent;

	@Column(name="NOT_IS_UNREAD")
	private boolean notIsUnread;

	@Column(name="USER_ID")
	private long userId;

	public TmNotification() {
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
}