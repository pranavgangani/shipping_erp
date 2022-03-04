package com.shipping.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Crew;
import com.shipping.model.vessel.Vessel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VesselRepository extends MongoRepository<Vessel, Long> {
    @Query("{'vesselName': { $eq: /^?0/ }}")
	public List<Vessel> findByName(String vesselName);

    @Query("{'vesselOwner._id': { $eq: ?0 }}")
	public List<Vessel> findByVesselOwner(long vesselOwnerId);

}
