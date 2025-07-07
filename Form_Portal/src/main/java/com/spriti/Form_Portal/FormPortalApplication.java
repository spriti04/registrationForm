package com.spriti.Form_Portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FormPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormPortalApplication.class, args);
	}

}
