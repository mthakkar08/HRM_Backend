package com.cement.hrm.request;

import java.util.Date;

public class LeaveRequest {

	private String leaveSubject;
	private int leaveStatus;
	private int status;
	private Date leaveDate;
	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveRequest(String leaveSubject, int leaveStatus, Date leaveDate, int status) {
		super();
		this.leaveSubject = leaveSubject;
		this.leaveStatus = leaveStatus;
		this.leaveDate = leaveDate;
		this.status = status;
	}

	public String getLeaveSubject() {
		return leaveSubject;
	}

	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}

	public int getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(int leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
