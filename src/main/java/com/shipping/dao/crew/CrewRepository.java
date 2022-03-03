package com.shipping.dao.crew;

import com.shipping.common.Flag;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Crew;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CrewRepository extends MongoRepository<Crew, Long> {
    @Query("{ 'fName' : { $regex: ?0 } }")
	public Crew findByFirstName(String firstName);

    @Query("{ 'lName' : { $regex: ?0 } }")
	public List<Crew> findByLastName(String lastName);

}
