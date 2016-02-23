package com.tm.core.entity_sql;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_calendar database table.
 * 
 */
@Entity
@Table(name="tm_calendar")
@EqualsAndHashCode(callSuper=false)
public @Data class TmCalendar extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ISS_ID")
	private long issId;

	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="EVENT_DATE")
	private Timestamp eventDate;
}