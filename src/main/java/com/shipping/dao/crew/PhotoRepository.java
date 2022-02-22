package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}
