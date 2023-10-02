package com.cement.hrm.request;

import java.util.Date;

public class HolidayRequest {

	private Date fromDate;
	private Date toDate;

	private int status;

	public HolidayRequest(Date fromDate, Date toDate, int status) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

}
