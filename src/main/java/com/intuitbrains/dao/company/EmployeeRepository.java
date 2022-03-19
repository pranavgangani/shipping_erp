package com.intuitbrains.dao.company;

import com.intuitbrains.model.company.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    //@Query("{$and :[{'userName': { $eq: ?0 }},{'password': { $eq: ?1 }}] }")
    @Query("{'userName': { $eq: ?0 }}")
    public Employee findByFirstUserNamePass(String username, String password);
}
