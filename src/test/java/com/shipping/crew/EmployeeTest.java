package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.CrewDocumentRepository;
import com.shipping.dao.common.DocumentTypeRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.company.EmployeeRepository;
import com.shipping.dao.company.UserRoleRepository;
import com.shipping.dao.crew.CrewContractRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.dao.vessel.VesselVacancyRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.model.common.document.*;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.EducationDocument;
import com.shipping.model.common.document.category.EmploymentDocument;
import com.shipping.model.company.Employee;
import com.shipping.model.company.UserRole;
import com.shipping.model.crew.*;
import com.shipping.model.crew.contract.*;
import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselVacancy;
import com.shipping.service.common.ContractDocumentGenerator;
import com.shipping.service.common.SequenceGeneratorService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private UserRoleRepository userRoleDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Test
    void addUserRole() {
        UserRole role1 = new UserRole();
        role1.setId(sequenceGenerator.generateSequence(UserRole.SEQUENCE_NAME));
        role1.setRoleName("Recruiter");
        role1.setRoleDesc("Manages Recruitment of Crew, adds vacancies");
        userRoleDao.insert(role1);

        UserRole role2 = new UserRole();
        role2.setId(sequenceGenerator.generateSequence(UserRole.SEQUENCE_NAME));
        role2.setRoleName("Vessel Manager");
        role2.setRoleDesc("Manages Vessel Data");
        userRoleDao.insert(role2);

        UserRole role3 = new UserRole();
        role3.setId(sequenceGenerator.generateSequence(UserRole.SEQUENCE_NAME));
        role3.setRoleName("Document Manager");
        role3.setRoleDesc("Manages Vessel & Crew Documents");
        userRoleDao.insert(role3);
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setId(sequenceGenerator.generateSequence(Employee.SEQUENCE_NAME));
        employee.setfName("Pranav");
        employee.setlName("Gangani");
        employee.setEmailId("pgangani@gmail.com");
        employee.setGender("male");
        employee.setUserName("pgangani");
        employee.setPassword("pgangani");
        employeeDao.insert(employee);

        employee = new Employee();
        employee.setId(sequenceGenerator.generateSequence(Employee.SEQUENCE_NAME));
        employee.setfName("Vinayak");
        employee.setlName("More");
        employee.setEmailId("vmore@gmail.com");
        employee.setGender("male");
        employee.setUserName("vmore");
        employee.setPassword("vmore");
        employeeDao.insert(employee);
    }

}
