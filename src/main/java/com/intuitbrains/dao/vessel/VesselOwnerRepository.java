package com.intuitbrains.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.vessel.VesselOwner;

public interface VesselOwnerRepository extends MongoRepository<VesselOwner, Long> {
	//public Crew save(Crew crew);

	//public Crew findByFirstName(String firstName);

	//public List<Crew> findByLastName(String lastName);

}
