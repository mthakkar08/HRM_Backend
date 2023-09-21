package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RoleRights")
public class RoleRights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleRightId")
	private int roleRightId;

	@Column(name = "RoleId")
	private int roleId;

	@Column(name = "MenuId")
	private int menuId;


	@Column(name = "AccessRightId")
	private int accessRightId;

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

	public RoleRights() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleRights(int roleRightId, int roleId, int menuId, int accessRightId, int status, int createdBy,
			Date createdDate, int modifiedBy, Date modifiedDate) {
		super();
		this.roleRightId = roleRightId;
		this.roleId = roleId;
		this.menuId = menuId;
		this.accessRightId = accessRightId;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public int getRoleRightId() {
		return roleRightId;
	}

	public void setRoleRightId(int roleRightId) {
		this.roleRightId = roleRightId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getAccessRightId() {
		return accessRightId;
	}

	public void setAccessRightId(int accessRightId) {
		this.accessRightId = accessRightId;
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
}
