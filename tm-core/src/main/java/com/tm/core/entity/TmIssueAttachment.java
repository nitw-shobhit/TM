package com.tm.core.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tm_issue_attachment database table.
 * 
 */
@Entity
@Table(name="tm_issue_attachment")
@NamedQuery(name="TmIssueAttachment.findAll", query="SELECT t FROM TmIssueAttachment t")
public class TmIssueAttachment extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Lob
	@Column(name="ATT_CONTENT")
	private Blob attContent;

	@Column(name="ISS_ID")
	private long issId;

	@Column(name="USER_ID")
	private long userId;

	public TmIssueAttachment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Blob getAttContent() {
		return this.attContent;
	}

	public void setAttContent(Blob attContent) {
		this.attContent = attContent;
	}

	public long getIssId() {
		return this.issId;
	}

	public void setIssId(long issId) {
		this.issId = issId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}