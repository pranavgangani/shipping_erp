package com.shipping.dao.crew;


import com.shipping.model.common.document.category.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Document, Integer> {

}
