package com.cement.hrm.constant;

import java.util.UUID;

public final class Config {

	public static final String SIGNATURE = "https://cementdigital.com";
	public static final String RESET_PASSWORD_URL = "http://localhost:3000/reset-password?token=";
	public static final String GENERATE_TOKEN = UUID.randomUUID().toString();
	
	
}
