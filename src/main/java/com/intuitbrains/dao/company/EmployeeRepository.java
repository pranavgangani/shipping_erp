package com.intuitbrains.dao.company;

import com.intuitbrains.model.company.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByEmailId(String emailId);

    Employee findByEmpId(String empId);

    @Query("{role: {$eq: ?0}}")
    List<Employee> findByRole(String role);

}