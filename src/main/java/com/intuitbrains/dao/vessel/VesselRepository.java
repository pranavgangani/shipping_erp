package com.intuitbrains.dao.vessel;

import com.intuitbrains.model.vessel.Journey;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.vessel.Vessel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VesselRepository extends MongoRepository<Vessel, Long> {
    @Query("{'vesselName': { $eq: /^?0/ }}")
	public List<Vessel> findByName(String vesselName);

    @Query("{'vesselOwner._id': { $eq: ?0 }}")
	public List<Vessel> findByVesselOwner(long vesselOwnerId);

    @Query("{'journeys.status.id': { eq: 1 }}")
    public Journey getActiveJourney();

}
