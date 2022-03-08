package com.shipping.dao.common;

import com.shipping.common.AuditTrail;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.crew.Crew;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuditTrailRepository extends MongoRepository<AuditTrail, Long> {
    @Query("{$and :[{'collection': { $eq: ?0 }},{'uniqueId': { $eq: ?1 }}] }")
    public List<AuditTrail> getAudit(String collection, long uniqueId);
}
