package com.shipping.main;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Configuration
//@ImportResource({"classpath*:spring/appServlet/servlet-context.xml"})
@ComponentScan(basePackages = "com.shipping.web.crew, com.shipping.crew.service, com.shipping.dao.crew")
public class CrewManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewManagementApplication.class, args);
	} 
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}


}
