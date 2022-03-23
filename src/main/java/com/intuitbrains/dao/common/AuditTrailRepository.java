package com.intuitbrains.dao.common;

import com.intuitbrains.common.AuditTrail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuditTrailRepository extends MongoRepository<AuditTrail, Long> {
    @Query("{$and :[{'collection': { $eq: ?0 }},{'uniqueId': { $eq: ?1 }}] }")
    public List<AuditTrail> getAudit(String collection, long uniqueId);
/*
    @Query("{$sort: {actionDateTime: -1}}, {$limit: 5}")
    public List<AuditTrail> getTop5Desc();*/
}
