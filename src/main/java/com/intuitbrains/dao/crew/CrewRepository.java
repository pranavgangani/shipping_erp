package com.intuitbrains.dao.crew;

import com.intuitbrains.model.crew.Experience;
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

    //{"fName":1, "lName":2,_id:0}
    @Query("{_id:1, fName:2, lName:3 ,mName:4, rank:5, gender:6, passportNumber:7, indosNumber:8, statusId:9}")
    public List<Crew> getList();

    @Query("{_id:1, employmentHistory:2}")
    public List<Experience> getEmploymentHistory(long crewId);

}
