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
 * The persistent class for the tm_project database table.
 * 
 */
@Entity
@Table(name="tm_project")
@EqualsAndHashCode(callSuper=false)
public @Data class TmProject extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="PROJ_DESC")
	private String projDesc;

	@Column(name="PROJ_NAME")
	private String projName;

	@Column(name="PROJ_OWNER")
	private long projOwner;
}