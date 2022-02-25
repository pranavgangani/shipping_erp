package com.shipping.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.vessel.VesselOwnerPhoto;

public interface VesselOwnerPhotoRepository extends MongoRepository<VesselOwnerPhoto, Long>{

}
