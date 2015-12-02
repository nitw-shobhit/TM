package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tm_release database table.
 * 
 */
@Entity
@Table(name="tm_release")
public class TmRelease extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="MOD_ID")
	private long modId;

	@Column(name="REL_DESC")
	private String relDesc;

	@Column(name="REL_NAME")
	private String relName;

	@Column(name="REL_STATUS")
	private String relStatus;

	@Column(name="USER_ID")
	private long userId;

	public TmRelease() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getModId() {
		return this.modId;
	}

	public void setModId(long modId) {
		this.modId = modId;
	}

	public String getRelDesc() {
		return this.relDesc;
	}

	public void setRelDesc(String relDesc) {
		this.relDesc = relDesc;
	}

	public String getRelName() {
		return this.relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getRelStatus() {
		return this.relStatus;
	}

	public void setRelStatus(String relStatus) {
		this.relStatus = relStatus;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}