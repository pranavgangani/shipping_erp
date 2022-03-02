package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.DocumentSubCategory;

public interface CrewSubDocumentCategoryRepository extends MongoRepository<DocumentSubCategory, Long> {

}
