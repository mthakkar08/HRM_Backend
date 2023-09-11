package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
}
