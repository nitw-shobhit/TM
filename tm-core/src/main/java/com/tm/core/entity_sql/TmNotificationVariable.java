package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_notification_variable database table.
 * 
 */
@Entity
@Table(name="tm_notification_variable")
@EqualsAndHashCode(callSuper=false)
public @Data class TmNotificationVariable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="NOT_ID")
	private long notId;

	@Column(name="NVL_KEY")
	private String nvlKey;

	@Column(name="NVL_VAL")
	private String nvlVal;
}