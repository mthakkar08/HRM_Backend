package com.cement.hrm.request;

import java.util.Date;

public class LeaveRequest {

	private Integer leaveId;
	private Integer employeeId;
	private Integer leaveStatus;
	private Integer status;
	private String leaveSubject;
	private Date leaveDate;
	private Integer approvedBy;
	private String approvedMessage;

	public LeaveRequest() {
		super();
	}

	public LeaveRequest(Integer leaveId, Integer employeeId, Integer leaveStatus, Integer status, String leaveSubject,
			Date leaveDate, Integer approvedBy, String approvedMessage) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveStatus = leaveStatus;
		this.status = status;
		this.leaveSubject = leaveSubject;
		this.leaveDate = leaveDate;
		this.approvedBy = approvedBy;
		this.approvedMessage = approvedMessage;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(Integer leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLeaveSubject() {
		return leaveSubject;
	}

	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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

}
