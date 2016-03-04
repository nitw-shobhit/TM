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
 * The persistent class for the tm_module database table.
 * 
 */
@Entity
@Table(name="tm_module")
@EqualsAndHashCode(callSuper=false)
public @Data class TmModule extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="MOD_DESC")
	private String modDesc;

	@Column(name="MOD_NAME")
	private String modName;

	@Column(name="MOD_STATUS")
	private String modStatus;

	@Column(name="PROJ_ID")
	private long projId;
}