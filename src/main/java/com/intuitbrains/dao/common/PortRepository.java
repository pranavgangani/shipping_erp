package com.intuitbrains.dao.common;

import com.intuitbrains.common.Flag;
import com.intuitbrains.common.Port;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PortRepository extends MongoRepository<Port, ObjectId> {
    @Query("{ 'refcode' : { $regex: ?0 } }")
    Port getByCode(String regexp);
}
