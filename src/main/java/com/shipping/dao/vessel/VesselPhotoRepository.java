package com.shipping.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.vessel.VesselPhoto;

public interface VesselPhotoRepository extends MongoRepository<VesselPhoto, Long> {

}
