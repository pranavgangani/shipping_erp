package com.intuitbrains.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.vessel.VesselOwnerPhoto;

public interface VesselOwnerPhotoRepository extends MongoRepository<VesselOwnerPhoto, Long>{

}
