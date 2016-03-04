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
 * The persistent class for the tm_notification database table.
 * 
 */
@Entity
@Table(name="tm_notification")
@EqualsAndHashCode(callSuper=false)
public @Data class TmNotification extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="NOT_CONTENT")
	private String notContent;

	@Column(name="NOT_IS_UNREAD")
	private boolean notIsUnread;

	@Column(name="USER_ID")
	private long userId;
}