package com.intuitbrains.dao.crew;

import com.intuitbrains.model.crew.ContractRule;
import com.intuitbrains.model.crew.contract.CrewContract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ContractRuleRepository extends MongoRepository<ContractRule, Long> {

}
