package com.shipping.dao.crew;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.shipping.model.crew.Crew;

public interface CrewRepository extends MongoRepository<Crew, Integer>, QuerydslPredicateExecutor<Crew> {

	// public Crew save(Crew crew);

	// public Crew findByFirstName(String firstName);

	// public List<Crew> findByLastName(String lastName);

	@Query("{ 'name' : ?0 }")
	List<Crew> findCrewsByName(String name);

	@Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
	List<Crew> findCrewsByAgeBetween(int ageGT, int ageLT);

	@Query("{ 'name' : { $regex: ?0 } }")
	List<Crew> findCrewsByRegexpName(String regexp);

	List<Crew> findByName(String name);

	List<Crew> findByNameLikeOrderByAgeAsc(String name);

	List<Crew> findByAgeBetween(int ageGT, int ageLT);

	List<Crew> findByNameStartingWith(String regexp);

	List<Crew> findByNameEndingWith(String regexp);

	@Query(value = "{}", fields = "{name : 1}")
	List<Crew> findNameAndId();

	@Query(value = "{}", fields = "{_id : 0}")
	List<Crew> findNameAndAgeExcludeId();
}
