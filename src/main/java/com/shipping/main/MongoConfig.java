package com.shipping.main;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

//@Configuration
//@EnableMongoRepositories(basePackages = "com.shipping.dao.crew")
public class MongoConfig extends AbstractMongoClientConfiguration {
	/*
	 * @Value("${dataSource.mongo.host}") private String hostServer;
	 * 
	 * @Value("${dataSource.mongo.port}") private String hostPort;
	 * 
	 * @Value("${dataSource.mongo.dbName}") private String dbName;
	 */
 
    @Override
    protected String getDatabaseName() {
        return "shipmon";
    }
 
    @Override
    public MongoClient mongoClient() {
    	ConnectionString connectionString = new ConnectionString(
				"mongodb+srv://pranavgangani:D@!zy1985@cluster0.gfa1v.mongodb.net/admin?retryWrites=true&w=majority");
        //ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/admin");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 
    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.shipping");
    }

}

