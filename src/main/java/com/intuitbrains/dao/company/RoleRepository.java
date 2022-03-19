package com.intuitbrains.dao.company;

import com.intuitbrains.model.company.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
