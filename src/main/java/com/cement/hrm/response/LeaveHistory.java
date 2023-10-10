package com.cement.hrm.response;

import java.util.Date;

public class LeaveHistory {

	private Integer leaveHistoryId;
	private Integer leaveId;
	private Integer employeeId;
	private Integer respondedBy;
	private String responseMessage;
	private Integer createdBy;
	private Date createdDate;

	public LeaveHistory() {
		super();
	}

	public LeaveHistory(Integer leaveHistoryId, Integer leaveId, Integer employeeId, Integer respondedBy,
			String responseMessage, Integer createdBy, Date createdDate) {
		super();
		this.leaveHistoryId = leaveHistoryId;
		this.leaveId = leaveId;
		this.employeeId = employeeId;
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

	public Integer getRespondedBy() {
		return respondedBy;
	}

	public void setRespondedBy(Integer respondedBy) {
		this.respondedBy = respondedBy;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
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

}
