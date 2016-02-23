package com.tm.model.bean;

import java.sql.Timestamp;

import lombok.Data;

import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

public @Data class BaseBean {

	@DtoField
	private boolean visible;
	
	@DtoField
	private Timestamp dtCreated;
	
	@DtoField
	private Timestamp dtModified;
}
