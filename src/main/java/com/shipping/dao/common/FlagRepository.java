package com.shipping.dao.common;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.common.Flag;

public interface FlagRepository extends MongoRepository<Flag, ObjectId> {

}
