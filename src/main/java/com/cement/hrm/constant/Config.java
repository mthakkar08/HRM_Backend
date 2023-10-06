package com.cement.hrm.constant;

import java.util.UUID;

public final class Config {

	public static final String SIGNATURE = "https://cementdigital.com";
	public static final String RESET_PASSWORD_URL = "http://localhost:3000/resetPassword?token=";
	public static final String RANDOM_TOKEN = UUID.randomUUID().toString();
	public static final long JWT_TOKEN_VALIDITY = 5 * 1 * 60;
	
	
}
