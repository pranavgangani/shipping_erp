package com.shipping.dao.company;

import com.shipping.model.company.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
