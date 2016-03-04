package com.tm.core.entity;

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
 * The persistent class for the tm_issue database table.
 * 
 */
@Entity
@Table(name="tm_issue")
@EqualsAndHashCode(callSuper=false)
public @Data class TmIssue extends TmBase implements Serializable {
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
}