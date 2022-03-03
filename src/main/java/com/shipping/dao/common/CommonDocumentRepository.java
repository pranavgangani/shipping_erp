package com.shipping.dao.common;

import com.shipping.model.common.document.category.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommonDocumentRepository extends MongoRepository<Document, Long> {

}
