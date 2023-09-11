package com.cement.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MenuId")
	private int menuId;

	@Column(name = "ParentMenuId")
	private int parentMenuId;

	@Column(name = "MenuName")
	private String menuName;

	@Column(name = "Status")
	private int status;

	@Column(name = "CreatedBy")
	private int createdBy;

	@Column(name = "ModifiedBy")
	private int modifiedBy;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public Menu(int menuId, int parentMenuId, String menuName, int status, int createdBy, int modifiedBy) {
		super();
		this.menuId = menuId;
		this.parentMenuId = parentMenuId;
		this.menuName = menuName;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

}
