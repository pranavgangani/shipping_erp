package com.intuitbrains.dao.crew;


import com.intuitbrains.model.common.document.category.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Document, Integer> {

}
