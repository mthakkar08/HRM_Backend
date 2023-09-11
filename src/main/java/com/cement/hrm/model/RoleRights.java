package com.cement.hrm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RoleRights")
public class RoleRights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleRightId")
	private int roleRightId;

	@ManyToOne
	@JoinColumn(name = "RoleId")
	private Role role;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "MenuId")
	@Column(name="MenuId")
	private int menuId;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "AccessRightId")
	@Column(name="AccessRightId")
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

	

	

}
