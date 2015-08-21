package com.tm.core.bean;

import java.io.Serializable;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.tm.core.entity.TmProject;

@Dto
public class ProjectBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String projDesc;

	@DtoField
	private String projName;

	@DtoField
	private long projOwner;

	public ProjectBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjDesc() {
		return this.projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public String getProjName() {
		return this.projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public long getProjOwner() {
		return this.projOwner;
	}

	public void setProjOwner(long projOwner) {
		this.projOwner = projOwner;
	}
	
	public TmProject toEntity() {
		TmProject projEntity = new TmProject();
		DTOAssembler.newAssembler(this.getClass(), projEntity.getClass()).assembleEntity(this, projEntity, null, null);
		return projEntity;
	}
}