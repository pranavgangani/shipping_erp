package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Document;


public interface DocumentRepository extends MongoRepository<Document, Integer> {

}
