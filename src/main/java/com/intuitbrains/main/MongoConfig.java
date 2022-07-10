package com.intuitbrains.main;

import java.util.Collection;
import java.util.Collections;

import com.mongodb.client.MongoDatabase;
import com.mysema.commons.lang.URLEncoder;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    private CodecRegistry codecRegistry;

    @Override
    protected String getDatabaseName() {
        return "shipmon";
    }

    @Override
    public MongoClient mongoClient() {
        //final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/admin");
        //mongodb+srv://pranavgangani:D@!zy1985@cluster0.gfa1v.mongodb.net/?retryWrites=true&w=majority
        final ConnectionString connectionString = new ConnectionString("mongodb+srv://pranavgangani:"+ URLEncoder.encodeParam("D@!zy1985", "UTF-8")+"@cluster0.gfa1v.mongodb.net/?retryWrites=true&w=majority");

        // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);

        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.intuitbrains");
    }


    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        System.out.println("transactionManager.......");
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }

   /* @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }*/

    @Bean
    public MongoDatabase getDB() {
        return mongoClient().getDatabase(getDatabaseName());
    }
}