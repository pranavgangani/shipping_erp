package com.intuitbrains.dao.crew;


import com.intuitbrains.model.common.document.category.CrewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<CrewDocument, Integer> {

}
