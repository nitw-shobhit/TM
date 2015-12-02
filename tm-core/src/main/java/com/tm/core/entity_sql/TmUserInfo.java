package com.tm.core.entity_sql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * The persistent class for the tm_user_info database table.
 * 
 */
@Entity
@Table(name="tm_user_info")
public class TmUserInfo extends TmBase implements Serializable {
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

	public TmUserInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGroupId() {
		return this.userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		StringBuffer tempBuffer = new StringBuffer("BPS_USER_INFO['ID':").append(this.id).append(",'USER_ID':")
			.append(this.userId).append(",'USER_NAME':").append(this.userName).append(",'USER_GROUP_ID':")
			.append(this.userGroupId).append(",'USER_TYPE':").append(this.userType).append(",'USER_EMAIL':")
			.append(this.userEmail).append(",'USER_PHONE':").append(this.userPhone).append("]");
		return tempBuffer.toString();
	}
}