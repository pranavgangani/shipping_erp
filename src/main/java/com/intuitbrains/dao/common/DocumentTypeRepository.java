package com.intuitbrains.dao.common;

import com.intuitbrains.model.common.document.category.DocumentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface DocumentTypeRepository extends MongoRepository<DocumentType, Long> {
    @Query("{ 'name' : { $regex: ?0 } }")
    public DocumentType findByName(String name);
}
