package com.tm.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the tm_issue_history database table.
 * 
 */
@Entity
@Table(name="tm_issue_history")
public @Data class TmIssueHistory implements Serializable {
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
}