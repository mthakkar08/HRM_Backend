package com.cement.hrm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportingEmployee {

	@JsonProperty("EmployeeId")
	private int employeeId;

	@JsonProperty("EmployeeName")
	private String employeeName;

	public ReportingEmployee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

}
