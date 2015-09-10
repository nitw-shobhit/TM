package com.tm.bpm.core;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organizationalentity database table.
 * 
 */
@Entity
@Table(name="organizationalentity")
public class CustomOrganizationalentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String dtype;

	public CustomOrganizationalentity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

}