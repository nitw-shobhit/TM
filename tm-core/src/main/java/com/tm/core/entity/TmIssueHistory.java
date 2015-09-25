package com.tm.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tm_issue_history database table.
 * 
 */
@Entity
@Table(name="tm_issue_history")
public class TmIssueHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="HIS_CONTENT")
	private String hisContent;

	@Column(name="HIS_CREATED")
	private Timestamp hisCreated;

	@Column(name="HIS_USER")
	private String hisUser;

	@Column(name="ISS_ID")
	private long issId;

	public TmIssueHistory() {
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

	public String getHisUser() {
		return this.hisUser;
	}

	public void setHisUser(String hisUser) {
		this.hisUser = hisUser;
	}

	public long getIssId() {
		return this.issId;
	}

	public void setIssId(long issId) {
		this.issId = issId;
	}

}