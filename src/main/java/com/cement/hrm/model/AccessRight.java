package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccessRights")
public class AccessRight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccessRightId")
	private int accessRightId;

	@Column(name = "AccessRightName")
	private String accessRightName;

	@Column(name = "Status")
	private int status;

	@Column(name = "CreatedBy")
	private int createdBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedBy")
	private int modifiedBy;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public int getAccessRightId() {
		return accessRightId;
	}

	public void setAccessRightId(int accessRightId) {
		this.accessRightId = accessRightId;
	}

	public String getAccessRightName() {
		return accessRightName;
	}

	public void setAccessRightName(String accessRightName) {
		this.accessRightName = accessRightName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public AccessRight(int accessRightId, String accessRightName, int status, int createdBy, int modifiedBy) {
		super();
		this.accessRightId = accessRightId;
		this.accessRightName = accessRightName;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

}
