package com.cement.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleId")
	private int roleId;

	@Column(name = "RoleName")
	private String roleName;

	@Column(name = "Status")
	private int status;

	@Column(name = "CreatedBy")
	private int createdBy;

	@Column(name = "ModifiedBy")
	private int modifiedBy;

	public Role() {
		super();
	}

	public Role(int roleId, String roleName, int status, int createdBy, int modifiedBy) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
