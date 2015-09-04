package com.tm.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.tm.core.bean.ProjectBean;


/**
 * The persistent class for the tm_project database table.
 * 
 */
@Entity
@Table(name="tm_project")
public class TmProject extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="PROJ_DESC")
	private String projDesc;

	@Column(name="PROJ_NAME")
	private String projName;

	@Column(name="PROJ_OWNER")
	private long projOwner;

	public TmProject() {
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

	public ProjectBean toBean() {
		ProjectBean projBean = new ProjectBean();
		DTOAssembler.newAssembler(projBean.getClass(), this.getClass()).assembleDto(projBean, this, null, null);
		return projBean;
	}
}