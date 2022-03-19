package com.intuitbrains.dao.common;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.common.Flag;
import org.springframework.data.mongodb.repository.Query;

public interface FlagRepository extends MongoRepository<Flag, ObjectId> {
    @Query("{ 'code' : { $regex: ?0 } }")
    Flag getByCode(String regexp);
}
