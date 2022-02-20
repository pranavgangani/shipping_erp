package com.shipping.main;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
//@ImportResource({"classpath*:spring/appServlet/servlet-context.xml"})
//@ImportResource("classpath:spring.xml")
@ComponentScan(basePackages = 
		  "com.shipping.web.*,"
		+ "com.shipping.service.*,"
		+ "com.shipping.dao.*")
public class CrewManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewManagementApplication.class, args);
	} 



}
