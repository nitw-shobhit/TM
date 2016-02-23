package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the tm_user_project database table.
 * 
 */
@Entity
@Table(name="tm_user_project")
public @Data class TmUserProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="PROJ_ID")
	private long projId;

	@Column(name="USER_ID")
	private long userId;
}