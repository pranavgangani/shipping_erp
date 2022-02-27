package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Crew;

public interface CrewRepository extends MongoRepository<Crew, Long> {
	//public Crew save(Crew crew);

	//public Crew findByFirstName(String firstName);

	//public List<Crew> findByLastName(String lastName);

}
