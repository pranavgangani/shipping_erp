package com.shipping.dao.common;

import com.shipping.common.AuditTrail;
import com.shipping.model.common.document.category.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuditTrailRepository extends MongoRepository<AuditTrail, Long> {

}
