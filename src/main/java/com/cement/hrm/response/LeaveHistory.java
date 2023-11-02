package com.cement.hrm.response;

import java.util.Date;

public class LeaveHistory {

	private Integer leaveHistoryId;
	private String leaveSubject;
	private Integer leaveStatus;
	private String employeeName;
	private String respondedBy;
	private String responseMessage;
	private String createdBy;
	private Date createdDate;

	public LeaveHistory() {
		super();
	}

	public LeaveHistory(Integer leaveHistoryId, String leaveSubject, Integer leaveStatus, String employeeName,
			String respondedBy, String responseMessage, String createdBy, Date createdDate) {
		super();
		this.leaveHistoryId = leaveHistoryId;
		this.leaveSubject = leaveSubject;
		this.leaveStatus = leaveStatus;
		this.employeeName = employeeName;
		this.respondedBy = respondedBy;
		this.responseMessage = responseMessage;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Integer getLeaveHistoryId() {
		return leaveHistoryId;
	}

	public void setLeaveHistoryId(Integer leaveHistoryId) {
		this.leaveHistoryId = leaveHistoryId;
	}

	public String getLeaveSubject() {
		return leaveSubject;
	}

	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}

	public Integer getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(Integer leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRespondedBy() {
		return respondedBy;
	}

	public void setRespondedBy(String respondedBy) {
		this.respondedBy = respondedBy;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
