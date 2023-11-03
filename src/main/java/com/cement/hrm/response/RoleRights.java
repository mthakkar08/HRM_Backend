package com.cement.hrm.response;

import java.util.Date;

public class RoleRights {

	private int roleId;
	private int menuId;
	private int accessRightId;
	private int status;
	private int createdBy;
	private Date createdDate;
	private int modifiedBy;
	private Date modifiedDate;

	public RoleRights() {
		super();
	}

	public RoleRights(int roleId, int menuId, int accessRightId, int status, int createdBy, Date createdDate,
			int modifiedBy, Date modifiedDate) {
		super();
		this.roleId = roleId;
		this.menuId = menuId;
		this.accessRightId = accessRightId;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
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
