package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_issue_comment database table.
 * 
 */
@Entity
@Table(name="tm_issue_comment")
@EqualsAndHashCode(callSuper=false)
public @Data class TmIssueComment extends TmBase implements Serializable {
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
}