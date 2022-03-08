package com.shipping.dao.company;

import com.shipping.model.company.Employee;
import com.shipping.model.company.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRoleRepository extends MongoRepository<UserRole, Long> {

}
