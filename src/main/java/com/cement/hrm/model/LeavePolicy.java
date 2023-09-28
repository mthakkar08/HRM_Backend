package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LeavePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeavePolicyId")
	private int leavePolicyId;

	@Column(name = "LeaveCount")
	private int leaveCount;

	@Transient
	private int employeeId;

	@Column(name = "Status")
	private int status;

	@Column(name = "CreatedBy")
	private int createdBy;

	@Column(name = "StartFrom")
	private Date startFrom;

	@Column(name = "EndTo")
	private Date endTo;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedBy")
	private Integer modifiedBy;

	@Column(name = "ModifiedDate")
	private Date modifieddate;

	public LeavePolicy() {
		super();
	}

	public LeavePolicy(int leavePolicyId, int leaveCount, int employeeId, int status, int createdBy, Date startFrom,
			Date endTo, Date createdDate, Integer modifiedBy, Date modifieddate) {
		super();
		this.leavePolicyId = leavePolicyId;
		this.leaveCount = leaveCount;
		this.employeeId = employeeId;
		this.status = status;
		this.createdBy = createdBy;
		this.startFrom = startFrom;
		this.endTo = endTo;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifieddate = modifieddate;
	}

	public int getLeavePolicyId() {
		return leavePolicyId;
	}

	public void setLeavePolicyId(int leavePolicyId) {
		this.leavePolicyId = leavePolicyId;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getStartFrom() {
		return startFrom;
	}

	public void setStartFrom(Date startFrom) {
		this.startFrom = startFrom;
	}

	public Date getEndTo() {
		return endTo;
	}

	public void setEndTo(Date endTo) {
		this.endTo = endTo;
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

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

}
