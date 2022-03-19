package com.intuitbrains.dao.company;

import com.intuitbrains.model.company.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByEmailId(String emailId);

    Employee findByEmpId(String empId);

}