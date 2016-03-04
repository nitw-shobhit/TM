package com.tm.core.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_issue_attachment database table.
 * 
 */
@Entity
@Table(name="tm_issue_attachment")
@EqualsAndHashCode(callSuper=false)
public @Data class TmIssueAttachment extends TmBase implements Serializable {
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
}