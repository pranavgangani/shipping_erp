package com.shipping.dao.crew;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shipping.model.crew.Crew;

public interface CrewRepository extends MongoRepository<Crew, Integer> {
	//public Crew save(Crew crew);

	//public Crew findByFirstName(String firstName);

	//public List<Crew> findByLastName(String lastName);

}