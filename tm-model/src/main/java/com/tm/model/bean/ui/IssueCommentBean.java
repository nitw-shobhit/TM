package com.tm.model.bean.ui;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.tm.model.bean.BaseBean;

@Dto
@EqualsAndHashCode(callSuper=false)
public @Data class IssueCommentBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String comContent;

	@DtoField
	private long issId;

	@DtoField
	private long userId;
	
	private String userIdString;
}