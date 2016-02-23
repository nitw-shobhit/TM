package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_release database table.
 * 
 */
@Entity
@Table(name="tm_release")
@EqualsAndHashCode(callSuper=false)
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
}