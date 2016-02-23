package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the tm_user_info database table.
 * 
 */
@Entity
@Table(name="tm_user_info")
@EqualsAndHashCode(callSuper=false)
public @Data class TmUserInfo extends TmBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="USER_EMAIL")
	private String userEmail;

	@Column(name="USER_GROUP_ID")
	private String userGroupId;

	@Column(name="USER_ID")
	private String userId;

	@Lob
	@Column(name="USER_IMAGE")
	private byte[] userImage;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PASS")
	private String userPass;

	@Column(name="USER_PHONE")
	private String userPhone;

	@Column(name="USER_TYPE")
	private String userType;
}