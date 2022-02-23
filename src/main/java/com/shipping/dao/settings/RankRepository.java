package com.shipping.dao.settings;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shipping.model.crew.Rank;

public interface RankRepository extends MongoRepository<Rank, Integer> {

}
