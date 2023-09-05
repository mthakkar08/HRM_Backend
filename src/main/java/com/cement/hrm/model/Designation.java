package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Designation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "DesignationId")
	private int designationId;

	@Column(name = "DesignationName")
	private String designationName;

	@Column(name = "Description")
	private String description;

	@Column(name = "CreatedBy")
	private int createdBy;
	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedBy")
	private int modifiedBy;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Designation(int designationId, String designationName, String description, int createdBy, Date createdDate,
			int modifiedBy, Date modifiedDate) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
