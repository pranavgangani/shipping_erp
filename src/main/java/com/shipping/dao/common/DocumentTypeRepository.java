package com.shipping.dao.common;

import com.shipping.model.common.document.category.DocumentType;
import com.shipping.model.crew.Crew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface DocumentTypeRepository extends MongoRepository<DocumentType, Long> {
    @Query("{ 'fName' : { $regex: ?0 } }")
    public Crew findByName(String firstName);
}
