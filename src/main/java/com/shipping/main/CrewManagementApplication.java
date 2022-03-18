package com.shipping.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.shipping.dao.crew.CrewRepository;

@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.shipping.dao")
//@ImportResource({"classpath*:spring/appServlet/servlet-context.xml"})
//@ImportResource("classpath:spring.xml")
@ComponentScan(basePackages =
        "com.shipping.web.*,"
                + "com.shipping.service.*")

public class CrewManagementApplication extends AbstractMongoClientConfiguration implements ServletContextListener {
    private MongoClient mongoClient;

    public static void main(String[] args) {
        SpringApplication.run(CrewManagementApplication.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return "shipmon";
    }

    @Override
    public MongoClient mongoClient() {
        //ConnectionString connectionString = new ConnectionString("mongodb+srv://pranavgangani:D%40%21zy1985@cluster0.gfa1v.mongodb.net/admin?retryWrites=true&w=majority");
        ConnectionString connectionString = new
                ConnectionString("mongodb://localhost:27017/admin");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(mongoClientSettings);
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient, getDatabaseName());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Callback triggered - ContextListener.");
        if (mongoClient != null) mongoClient.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Triggers when context initializes
    }

}
