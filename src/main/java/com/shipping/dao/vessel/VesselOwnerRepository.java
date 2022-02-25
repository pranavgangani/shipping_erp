package com.shipping.dao.vessel;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Crew;
import com.shipping.model.vessel.VesselOwner;

public interface VesselOwnerRepository extends MongoRepository<VesselOwner, Integer> {
	//public Crew save(Crew crew);

	//public Crew findByFirstName(String firstName);

	//public List<Crew> findByLastName(String lastName);

}
