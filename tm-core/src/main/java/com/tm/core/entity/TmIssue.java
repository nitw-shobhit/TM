package com.tm.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tm_issue database table.
 * 
 */
@Entity
@Table(name="tm_issue")
public class TmIssue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="MOD_ID")
	private long modId;

	@Column(name="PROC_ID")
	private long procId;

	public TmIssue() {
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

	public long getProcId() {
		return this.procId;
	}

	public void setProcId(long procId) {
		this.procId = procId;
	}
}