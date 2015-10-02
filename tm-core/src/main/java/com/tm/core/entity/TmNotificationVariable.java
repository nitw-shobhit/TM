package com.tm.core.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tm_notification_variable database table.
 * 
 */
@Entity
@Table(name="tm_notification_variable")
@NamedQuery(name="TmNotificationVariable.findAll", query="SELECT t FROM TmNotificationVariable t")
public class TmNotificationVariable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="NOT_ID")
	private long notId;

	@Column(name="NVL_KEY")
	private String nvlKey;

	@Column(name="NVL_VAL")
	private String nvlVal;

	public TmNotificationVariable() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNotId() {
		return this.notId;
	}

	public void setNotId(long notId) {
		this.notId = notId;
	}

	public String getNvlKey() {
		return this.nvlKey;
	}

	public void setNvlKey(String nvlKey) {
		this.nvlKey = nvlKey;
	}

	public String getNvlVal() {
		return this.nvlVal;
	}

	public void setNvlVal(String nvlVal) {
		this.nvlVal = nvlVal;
	}
}