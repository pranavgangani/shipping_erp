package com.shipping.dao.company;

import com.shipping.model.company.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}