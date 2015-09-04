package com.tm.core.bean;

import java.io.Serializable;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.tm.core.entity.TmModule;

@Dto
public class ModuleBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@DtoField
	private long id;

	@DtoField
	private String modDesc;

	@DtoField
	private String modName;

	@DtoField
	private String modStatus;

	@DtoField
	private long projId;

	public ModuleBean() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModDesc() {
		return this.modDesc;
	}

	public void setModDesc(String modDesc) {
		this.modDesc = modDesc;
	}

	public String getModName() {
		return this.modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModStatus() {
		return this.modStatus;
	}

	public void setModStatus(String modStatus) {
		this.modStatus = modStatus;
	}

	public long getProjId() {
		return this.projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}
	
	public TmModule toEntity() {
		TmModule moduleEntity = new TmModule();
		DTOAssembler.newAssembler(this.getClass(), moduleEntity.getClass()).assembleEntity(this, moduleEntity, null, null);
		return moduleEntity;
	}
}