package com.shipping.dao.crew;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.RankCertification;


public interface RankCertificationRepository extends MongoRepository<RankCertification, Integer> {

}
