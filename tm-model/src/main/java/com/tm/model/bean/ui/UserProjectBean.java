package com.tm.model.bean.ui;

import java.io.Serializable;

import lombok.Data;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;

@Dto
public @Data class UserProjectBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private long projId;

	@DtoField
	private long userId;
}
