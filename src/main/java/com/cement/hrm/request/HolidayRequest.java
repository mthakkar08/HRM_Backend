package com.cement.hrm.request;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HolidayRequest {

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String fromDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
