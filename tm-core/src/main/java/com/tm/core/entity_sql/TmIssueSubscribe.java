package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

import lombok.Data;


/**
 * The persistent class for the tm_issue_subscribe database table.
 * 
 */
@Entity
@Table(name="tm_issue_subscribe")
public @Data class TmIssueSubscribe implements Serializable {
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
}