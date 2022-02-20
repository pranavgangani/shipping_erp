package com.shipping.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Value("${dataSource.mongo.host}")
	private String hostServer;
	
	@Value("${dataSource.mongo.port}")
	private String hostPort;
	
	@Value("${dataSource.mongo.dbName}")
	private String dbName;

	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString("mongodb://"+hostServer+":"+hostPort+"/"+dbName);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "test");
	}
}
