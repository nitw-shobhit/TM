package com.tm.core.entity_sql;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tm_issue_subscribe database table.
 * 
 */
@Entity
@Table(name="tm_issue_subscribe")
public class TmIssueSubscribe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ISS_ID")
	private long issId;

	@Column(name="SUB_CREATED")
	private Timestamp subCreated;

	@Column(name="USER_ID")
	private long userId;

	public TmIssueSubscribe() {
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

}