package com.intuitbrains.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.crew.CrewPhoto;

public interface PhotoRepository extends MongoRepository<CrewPhoto, Long> {

}
