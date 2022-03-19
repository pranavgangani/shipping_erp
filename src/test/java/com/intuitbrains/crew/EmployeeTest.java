package com.intuitbrains.crew;

import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.company.RoleRepository;
import com.intuitbrains.dao.company.UserRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.company.Role;
import com.intuitbrains.model.company.User;
import com.intuitbrains.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private RoleRepository roleDao;
    @Autowired
    private UserRepository userDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Test
    void addUserRole() {
        Role adminRole = roleDao.findByRole("ADMIN");
        if (adminRole == null) {
            Role newAdminRole = new Role();
            newAdminRole.setRole("ADMIN");
            roleDao.save(newAdminRole);
        }

        Role userRole = roleDao.findByRole("USER");
        if (userRole == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("USER");
            roleDao.save(newUserRole);
        }
/*
        Role rectruiter = roleDao.findByRole("RECRUITER");
        if (rectruiter == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("RECRUITER");
            newUserRole.setRoleDesc("Manages Recruitment of Crew, adds vacancies");
            roleDao.save(newUserRole);
        }
        Role vesselMgr = roleDao.findByRole("VESSEL_MANAGER");
        if (vesselMgr == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("VESSEL_MANAGER");
            newUserRole.setRoleDesc("Manages Vessel Data");
            roleDao.save(newUserRole);
        }
        Role docMgr = roleDao.findByRole("DOCUMENT_MANAGER");
        if (docMgr == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("DOCUMENT_MANAGER");
            newUserRole.setRoleDesc("Manages Vessel & Crew Documents");
            roleDao.save(newUserRole);
        }
      */
    }

    @Test
    void addUser() {
        User user = new User();
        user.setEmail("pranavgangani@gmail.com");
        user.setPassword("pranav");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setEnabled(true);
        Set set = new HashSet();
        set.add(roleDao.findByRole("ADMIN"));
        user.setRoles(set);
        userDao.insert(user);
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
