package com.shipping.dao.crew;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Crew;

public interface CrewDao extends MongoRepository<Crew, String> {
	

}
