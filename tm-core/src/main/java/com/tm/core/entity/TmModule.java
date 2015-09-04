package com.tm.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.tm.core.bean.ModuleBean;


/**
 * The persistent class for the tm_module database table.
 * 
 */
@Entity
@Table(name="tm_module")
public class TmModule extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="MOD_DESC")
	private String modDesc;

	@Column(name="MOD_NAME")
	private String modName;

	@Column(name="MOD_STATUS")
	private String modStatus;

	@Column(name="PROJ_ID")
	private long projId;

	public TmModule() {
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
	
	public ModuleBean toBean() {
		ModuleBean moduleBean = new ModuleBean();
		DTOAssembler.newAssembler(moduleBean.getClass(), this.getClass()).assembleDto(moduleBean, this, null, null);
		return moduleBean;
	}
}