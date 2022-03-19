package com.intuitbrains.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableConfigurationProperties
@ComponentScan("com.intuitbrains.main")
@EnableMongoRepositories(basePackages = "com.intuitbrains.dao.*")
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan(basePackages =
        "com.intuitbrains.web.*,"
                + "com.intuitbrains.service.*, com.intuitbrains.main.*")

public class CrewManagementApplication implements ServletContextListener {
    public static void main(String[] args) {
        SpringApplication.run(CrewManagementApplication.class, args);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Callback triggered - ContextListener.");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Triggers when context initializes
    }
    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }*/
}
