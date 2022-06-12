package com.intuitbrains.crew;

import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.company.RoleRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.company.Role;
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
    private SequenceGeneratorService sequenceGenerator;

    @Test
    void addUserRole() {
        Role adminRole = roleDao.findByRole("ADMIN");
        if (adminRole == null) {
            Role newAdminRole = new Role();
            newAdminRole.setRole("ADMIN");
            newAdminRole.setRoleDesc("User with admin rights");
            roleDao.insert(newAdminRole);
        }

        Role userRole = roleDao.findByRole("USER");
        if (userRole == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("USER");
            newUserRole.setRoleDesc("Regular user");
            roleDao.insert(newUserRole);
        }

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
            newUserRole.setRoleDesc("A crew manager directs and supervises the crew members' daily activities to ensure project completion or optimal service. Although a crew manager's duties vary depending on their industry or company of employment, their responsibilities usually include setting priorities and guidelines, managing employee schedules, recruiting and training new crew members, and solving issues and concerns when any arise. They also conduct regular assessments, review documents, and oversee supply inventories.\n\n" +
                    "Here are examples of responsibilities from real crew manager resumes representing typical tasks they are likely to perform in their roles.\n" +
                    "-Leverage exceptional communication, problem-solving and task-planning skills to achieve client's overall vision for events.\n" +
                    "-Facilitate inter-departmental communication to effectively provide customer support.");
            roleDao.save(newUserRole);
        }
        Role docMgr = roleDao.findByRole("TECHNICAL_SUP");
        if (docMgr == null) {
            Role newUserRole = new Role();
            newUserRole.setRole("TECHNICAL_SUP");
            newUserRole.setRoleDesc(
                    "-Manage the maintenance and operations of a bauxite unloading and alumina loading facility.\n" +
                    "-Present reports every morning to the COC personnel, pilots, and exercise evaluation officers as part of the morning brief.\n" +
                    "-Design and engineer lifeboats on LNG terminal by ensuring easy access, launching and recovery to ensure safety during emergency situations.\n" +
                    "-Monitor major maintenance perform on berth.\n" +
                    "-Perform minor maintenace duties as necesary to ensure berth functions maintain its realibility.");
            roleDao.save(newUserRole);
        }

    }
    @Test
    void addEmployeeJames() {
        Employee user = new Employee();
        user.setEmailId("james@saar.com");
        user.setPassword("123");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setFirstName("James");
        user.setMiddleName("");
        user.setLastName("Willis");
        user.setGender("male");
        user.setEmpId(generateEmployeeId());
        Set set = new HashSet();
        //set.add(roleDao.findByRole("USER"));
        set.add(roleDao.findByRole("ADMIN"));
        user.setRoles(set);
        employeeDao.insert(user);
    }
    @Test
    void addEmployeeRaju() {
        Employee user = new Employee();
        user.setEmailId("raju@saar.com");
        user.setPassword("123");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setFirstName("Raju");
        user.setMiddleName("");
        user.setLastName("Mathew");
        user.setGender("male");
        user.setEmpId(generateEmployeeId());
        Set set = new HashSet();
        //set.add(roleDao.findByRole("USER"));
        set.add(roleDao.findByRole("ADMIN"));
        user.setRoles(set);
        employeeDao.insert(user);
    }

    @Test
    void addEmployee() {
        Employee user = new Employee();
        user.setEmailId("pgangani@saar.com");
        user.setPassword("pranav");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setFirstName("Pranav");
        user.setMiddleName("Jayanti");
        user.setLastName("Gangani");
        user.setGender("male");
        user.setEmpId(generateEmployeeId());
        Set set = new HashSet();
        //set.add(roleDao.findByRole("USER"));
        set.add(roleDao.findByRole("ADMIN"));
        user.setRoles(set);
        employeeDao.insert(user);

        user = new Employee();
        user.setEmailId("rtiwari@saar.com");
        user.setPassword("rtiwari");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setFirstName("Rohan");
        user.setMiddleName("Pradeep");
        user.setLastName("Tiwari");
        user.setGender("male");
        user.setEmpId(generateEmployeeId());
        set = new HashSet();
        //set.add(roleDao.findByRole("USER"));
        set.add(roleDao.findByRole("USER"));
        user.setRoles(set);
        employeeDao.insert(user);

        /*user = new Employee();
        user.setEmailId("vmore@saar.com");
        user.setPassword("vmore");
        user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
        user.setFirstName("Vinayak");
        user.setMiddleName("B");
        user.setLastName("More");
        user.setGender("male");
        user.setEmpId(generateEmployeeId());
        set = new HashSet();
        //set.add(roleDao.findByRole("USER"));
        set.add(roleDao.findByRole("ADMIN"));
        user.setRoles(set);
        employeeDao.insert(user);*/

    }

    @Test
    void addUser2() {

    }

    @Test
    void addUser3() {

    }


/*    public String generateUsername(String firstName, String middleName, String lastName) {
        double cnt = employeeDao.count();
        String count = String.valueOf(cnt + 1);
        String res1 = firstName.substring(0, 3);
       // String res2 = middleName.isEmpty() ? "0" : middleName.substring(0, 1);
        String res3 = lastName.substring(0, 3);
        String res4 = res1 + res3;
        String res5 = count.toString().length() == 1 ? ("00" + count)
                : count.toString().length() == 2 ? ("0" + count) : count.toString();
        String finalResult = res4 + res5;
        return finalResult;

    }*/

    public String generateEmployeeId() {
        String count = String.valueOf(employeeDao.count() + 1);
        String res4 = "IND";
        String res5 = count.toString().length() == 1 ? ("00" + count)
                : count.toString().length() == 2 ? ("0" + count) : count.toString();
        count = count + 1;
        String finalResult = res4 + res5;
        return finalResult;

    }

}
