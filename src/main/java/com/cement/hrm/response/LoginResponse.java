package com.cement.hrm.response;

public class LoginResponse {

	private final String jwttoken;
	private final String email;
	private final String password;
	private final String employeeName;

	public LoginResponse(String jwttoken, String email, String password, String employeeName) {
		super();
		this.jwttoken = jwttoken;
		this.email = email;
		this.password = password;
		this.employeeName = employeeName;
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

}
