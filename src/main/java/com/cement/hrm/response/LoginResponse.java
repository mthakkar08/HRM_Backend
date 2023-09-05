package com.cement.hrm.response;

public class LoginResponse {

	private final String jwttoken;

	public LoginResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	
}
