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
@Table(name = "Leaves")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaveId")
	private Integer leaveId;

	@Column(name = "LeaveSubject")
	private String leaveSubject;

	@Column(name = "LeaveReason")
	private String leaveReason;

	@Column(name = "LeaveStatus")
	private Integer leaveStatus;

	@Column(name = "EmployeeId")
	private Integer employeeId;

	@Column(name = "ApprovedBy")
	private Integer approvedBy;

	@Column(name = "ApprovedMessage")
	private String approvedMessage;

	@Column(name = "Status")
	private Integer status;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "CreatedBy")
	private Integer createdBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedBy")
	private Integer modifiedBy;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	@Transient
	private String employeeName;

	@Transient
	private String reportingEmployee;

	public Leave() {
		super();
	}

	public Leave(Integer leaveId, String leaveSubject, String leaveReason, Integer leaveStatus, Integer employeeId,
			Integer approvedBy, String approvedMessage, Integer status, Date startDate, Date endDate, Integer createdBy,
			Date createdDate, Integer modifiedBy, Date modifiedDate, String employeeName, String reportingEmployee) {
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
		this.employeeName = employeeName;
		this.reportingEmployee = reportingEmployee;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
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

	public Integer getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(Integer leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedMessage() {
		return approvedMessage;
	}

	public void setApprovedMessage(String approvedMessage) {
		this.approvedMessage = approvedMessage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getReportingEmployee() {
		return reportingEmployee;
	}

	public void setReportingEmployee(String reportingEmployee) {
		this.reportingEmployee = reportingEmployee;
	}

}
