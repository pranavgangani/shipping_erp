package com.shipping.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.shipping.web, com.shipping.service")
public class CrewManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewManagementApplication.class, args);
	} 

}
