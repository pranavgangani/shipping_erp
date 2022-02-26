package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Certification;

public interface CertRepository extends MongoRepository<Certification, Integer> {

}
