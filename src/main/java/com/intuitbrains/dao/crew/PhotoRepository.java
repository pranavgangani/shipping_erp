package com.intuitbrains.dao.crew;

import com.intuitbrains.model.vessel.Vessel;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.crew.CrewPhoto;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PhotoRepository extends MongoRepository<CrewPhoto, Long> {
    @Query("{'crewId': { $eq: ?0 }}")
    public CrewPhoto findByCrewId(long crewId);
    //{ "$java" : Query: { "crewId" : { "$eq" : 4}}, Fields: {}, Sort: {} }
}
