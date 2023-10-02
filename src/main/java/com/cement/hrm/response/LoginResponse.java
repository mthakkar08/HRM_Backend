package com.cement.hrm.response;

public class LoginResponse {

	private final String jwttoken;
	private final String email;
	private final String password;
	private final String employeeName;
	private final Integer employeeId;

	public LoginResponse(String jwttoken, String email, String password, String employeeName, Integer employeeId) {
		super();
		this.jwttoken = jwttoken;
		this.email = email;
		this.password = password;
		this.employeeName = employeeName;
		this.employeeId = employeeId;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

}
