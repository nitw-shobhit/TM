package com.tm.core.entity_sql;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
public @Data class TmBase {

	@Column(name="VISIBLE")
	private boolean visible;
	
	@Column(name="DT_CREATED")
	private Timestamp dtCreated;

	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;
}
