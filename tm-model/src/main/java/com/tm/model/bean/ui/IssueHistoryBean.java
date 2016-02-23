package com.tm.model.bean.ui;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public @Data class IssueHistoryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String hisContent;

	@DtoField
	private Timestamp hisCreated;
	
	@DtoField
	private String hisUser;

	@DtoField
	private long issId;
}