package com.shipping.dao.crew;

import com.shipping.model.crew.Crew;
import com.shipping.model.crew.CrewContract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CrewContractRepository extends MongoRepository<CrewContract, Long> {
    @Query("{ 'name' : { $regex: ?0 } }")
	public List<CrewContract> findByName(String name);

    @Query("{ 'crewId' : { $eq: ?0 } }")
    public List<CrewContract> findByCrewId(long crewId);

    @Query("{ 'crewId' : { $eq: ?0 } }")
    public CrewContract findCurrentByCrewId(long crewId);

    @Query("{ 'crewId' : { $eq: ?0 } }")
    public List<CrewContract> findByVesselId(long vesselId);
}
