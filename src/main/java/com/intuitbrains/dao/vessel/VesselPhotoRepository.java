package com.intuitbrains.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.vessel.VesselPhoto;

public interface VesselPhotoRepository extends MongoRepository<VesselPhoto, Long> {

}
