package com.cement.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmApplication.class, args);
	}

}
