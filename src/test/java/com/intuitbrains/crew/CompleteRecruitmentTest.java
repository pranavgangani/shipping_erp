package com.intuitbrains.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.service.crew.CrewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;

public class CompleteRecruitmentTest {
    @Autowired
    private CrewService crewService;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private CrewDocumentRepository documentDao;

    @Test
    void recruitAndGenerateContract() {
        Employee makerEmp = employeeDao.findByEmpId("IND001");
        //Take Interview - (Taken offline)

        //Shortlisted CV (First Entry point for Crew)
        Crew newCrew = recruit(makerEmp);

        //Roll out Offer Letter
       // crewService.
    }

    private Crew recruit(Employee recruiterEmp) {
        try {
            FileInputStream file = new FileInputStream("F:\\shipping_erp\\Pranav.xlsx");
            return crewService.uploadCrewData(recruiterEmp, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
