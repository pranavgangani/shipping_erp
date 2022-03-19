package com.intuitbrains.dao.common;

import com.intuitbrains.common.FieldStatusAuditTrail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FieldStatusAuditRepository extends MongoRepository<FieldStatusAuditTrail, Long> {
    @Query("{$and :[{'collection': { $eq: ?0 }},{'uniqueId': { $eq: ?1 }},{'propertyName': { $eq: ?2 }}] }")
    public List<FieldStatusAuditTrail> getAudit(String collection, long uniqueId, String propertyName);
}
