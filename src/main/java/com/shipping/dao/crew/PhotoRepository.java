package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.CrewPhoto;

public interface PhotoRepository extends MongoRepository<CrewPhoto, Long> {

}
