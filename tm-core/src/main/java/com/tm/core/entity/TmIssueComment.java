package com.tm.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tm_issue_comment database table.
 * 
 */
@Entity
@Table(name="tm_issue_comment")
public class TmIssueComment extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="COM_CONTENT")
	private String comContent;

	@Column(name="ISS_ID")
	private long issId;

	@Column(name="USER_ID")
	private long userId;
	
	public TmIssueComment() {
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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComContent() {
		return this.comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
}