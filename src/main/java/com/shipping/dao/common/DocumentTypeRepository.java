package com.shipping.dao.common;

import com.shipping.model.common.document.category.DocumentType;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DocumentTypeRepository extends MongoRepository<DocumentType, Long> {

}
