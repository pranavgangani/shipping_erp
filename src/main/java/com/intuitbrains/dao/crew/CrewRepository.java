package com.intuitbrains.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intuitbrains.model.crew.Crew;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CrewRepository extends MongoRepository<Crew, Long> {
    @Query("{ 'fName' : { $regex: ?0 } }")
	public Crew findByFirstName(String firstName);

    @Query("{ 'lName' : { $regex: ?0 } }")
	public List<Crew> findByLastName(String lastName);

    @Query("{ 'dob' : { $gt: ?0 } }")
    public List<Crew> findByDOB(LocalDate date);

}
