package com.cement.hrm.response;

import org.springframework.security.core.userdetails.UserDetails;

public class LoginResponse {

	private final String jwttoken;
	private final UserDetails userDetails;

	public LoginResponse(String jwttoken, UserDetails userDetails) {
		super();
		this.jwttoken = jwttoken;
		this.userDetails = userDetails;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

}
