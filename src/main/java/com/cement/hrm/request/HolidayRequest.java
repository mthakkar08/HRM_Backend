package com.cement.hrm.request;

import java.util.Date;

public class HolidayRequest {

	private Date fromDate;
	private Date toDate;
	private Integer employeeId;
	private Integer holidayId;
	private Integer status;

	public HolidayRequest() {
		super();
	}

	public HolidayRequest(Date fromDate, Date toDate, Integer employeeId, Integer holidayId, Integer status) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.employeeId = employeeId;
		this.holidayId = holidayId;
		this.status = status;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
