package com.intuitbrains.service.company;

import java.util.List;

import com.intuitbrains.common.Collection;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuitbrains.dao.company.EmployeeRepository;

import static com.mongodb.client.model.Filters.eq;

@Service("employeeService")
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeDao;
    @Autowired
    private MongoDatabase db;

    void addEmployee(Employee emp) {

    }

    void deleteEmployee(Employee filterEmp) {

    }

    void updateEmployee(Employee filterEmp) {

    }

    public Employee getById(String empId) {
        Bson projections = Projections.include("empId", "firstName", "middleName", "lastName", "emailId");
        MongoCollection<Employee> collection = db.getCollection(Collection.EMPLOYEE, Employee.class);
        Bson filter = eq("empId", empId);
        return collection.find(filter).projection(projections).first();
    }

    List<Employee> getFilteredList(Employee filterEmp) {
        return null;
    }
}
