package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leaves")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaveId")
	private int leaveId;

	@Column(name = "LeaveSubject")
	private String leaveSubject;

	@Column(name = "LeaveReason")
	private String leaveReason;

	@Column(name = "LeaveStatus")
	private int leaveStatus;

	@Column(name = "EmployeeId")
	private int employeeId;

	@Column(name = "ApprovedBy")
	private int approvedBy;

	@Column(name = "ApprovedMessage")
	private String approvedMessage;

	@Column(name = "Status")
	private int status;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "CreatedBy")
	private int createdBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedBy")
	private int modifiedBy;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave(int leaveId, String leaveSubject, String leaveReason, int leaveStatus, int employeeId, int approvedBy,
			String approvedMessage, int status, Date startDate, Date endDate, int createdBy, Date createdDate,
			int modifiedBy, Date modifiedDate) {
		super();
		this.leaveId = leaveId;
		this.leaveSubject = leaveSubject;
		this.leaveReason = leaveReason;
		this.leaveStatus = leaveStatus;
		this.employeeId = employeeId;
		this.approvedBy = approvedBy;
		this.approvedMessage = approvedMessage;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveSubject() {
		return leaveSubject;
	}

	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public int getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(int leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedMessage() {
		return approvedMessage;
	}

	public void setApprovedMessage(String approvedMessage) {
		this.approvedMessage = approvedMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDAte(Date endDate) {
		this.endDate = endDate;
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
