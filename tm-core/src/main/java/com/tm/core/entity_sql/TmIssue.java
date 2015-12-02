package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tm_issue database table.
 * 
 */
@Entity
@Table(name="tm_issue")
public class TmIssue extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ISS_DESC")
	private String issDesc;

	@Column(name="ISS_NAME")
	private String issName;

	@Column(name="ISS_PRIORITY")
	private String issPriority;

	@Column(name="ISS_STATUS")
	private String issStatus;
	
	@Column(name="ISS_OWNER")
	private long issOwner;

	@Column(name="MOD_ID")
	private long modId;

	@Column(name="USER_ID")
	private long userId;

	public TmIssue() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIssDesc() {
		return this.issDesc;
	}

	public void setIssDesc(String issDesc) {
		this.issDesc = issDesc;
	}

	public String getIssName() {
		return this.issName;
	}

	public void setIssName(String issName) {
		this.issName = issName;
	}

	public String getIssPriority() {
		return this.issPriority;
	}

	public void setIssPriority(String issPriority) {
		this.issPriority = issPriority;
	}

	public String getIssStatus() {
		return this.issStatus;
	}

	public void setIssStatus(String issStatus) {
		this.issStatus = issStatus;
	}

	public long getModId() {
		return this.modId;
	}

	public void setModId(long modId) {
		this.modId = modId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getIssOwner() {
		return issOwner;
	}

	public void setIssOwner(long issOwner) {
		this.issOwner = issOwner;
	}
}