package com.intuitbrains.crew;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewContractRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.dao.vessel.VesselRepository;
import com.intuitbrains.dao.vessel.VesselVacancyRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.common.document.category.EducationDocument;
import com.intuitbrains.model.common.document.category.EmploymentDocument;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.*;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.model.vessel.VesselVacancy;
import com.intuitbrains.service.common.ContractDocumentGenerator;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.util.StandardWebParameter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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
class CrewTest {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private CrewContractRepository crewContractDao;
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private CrewService crewService;

    @Test
    void addNewCrewDetails() {
        LocalDate dob = LocalDate.of(1985, 7, 24);

        Flag flag = flagDao.getByCode("IN");

        Crew crew = new Crew();
        crew.setFirstName("Rohan");
        crew.setMiddleName("P");
        crew.setLastName("Tiwari");
        crew.setDob(dob);
        crew.setGender("male");
        crew.setMaritalStatusId(Crew.MaritalStatus.MARRIED.getId());
        crew.setRankId(Rank.JR_ENGINEER.getId());
        crew.setNationalityFlagId(flag.getId());
        crew.setNationality("Indian");
        crew.setPermAddress("A/4 Brahma, Wagle Estate, Shree Nagar, Thane");
        crew.setPresentAddress(crew.getPermAddress());
        crew.setDistinguishMark("Some mark on head");

        crew.setEmailId("pranavgangani@gmail.com");
        crew.setPassportNumber("SLJALJLJ");


        //Education
        Education ssc = new Education();
        ssc.setEducationName("S.S.C");
        ssc.setInstituteName("Sharon School");
        ssc.setInstituteAddress("Mulund, Mumbai");
        ssc.setPercentage(50f);
        ssc.setFlag(flag);
        ssc.setStartDate(LocalDate.of(2001, 4, 23));
        ssc.setEndDate(LocalDate.of(2002, 4, 23));

        EducationDocument sscDoc = new Certificate();
        sscDoc.setDocTypeId(docTypeDao.findByName("SSC").getId());
        //sscDoc.setFile();
        ssc.setEducationDocuments(new ArrayList<>(Arrays.asList(sscDoc)));

        Education hsc = new Education();
        hsc.setEducationName("H.S.C");
        hsc.setInstituteName("Somaiya College");
        hsc.setInstituteAddress("Vidyavihar, Mumbai");
        hsc.setPercentage(90.99f);
        hsc.setFlag(flag);
        hsc.setStartDate(LocalDate.of(2003, 4, 23));
        hsc.setEndDate(LocalDate.of(2006, 4, 23));

        EducationDocument hscDoc = new Certificate();
        hscDoc.setDocTypeId(docTypeDao.findByName("HSC").getId());
        //empDoc2.setFile();
        hsc.setEducationDocuments(new ArrayList<>(Arrays.asList(hscDoc)));

        crew.setEducationHistory(new ArrayList<>(Arrays.asList(ssc, hsc)));

        crew.setEnteredBy(employeeDao.findByEmailId("pgangani@saar.com").getEmpId());
        crewService.addCrew(crew);


    }


    @Test
    void addCrewDetails() {
        LocalDate dob = LocalDate.of(1985, 7, 23);

        Flag flag = flagDao.getByCode("IN");

        Crew crew = new Crew();
        crew.setFirstName("Pranav");
        crew.setMiddleName("J");
        crew.setLastName("Gangani");
        crew.setDob(dob);
        crew.setGender("male");
        crew.setRank(Rank.JR_ENGINEER);
        crew.setDistinguishMark("Some mark on head");
        crew.setNationalityFlagId(flag.getId());
        crew.setPermAddress("A/4 Brahma, Wagle Estate, Shree Nagar, Thane");
        crew.setPresentAddress(crew.getPermAddress());
        crew.setEmailId("pranavgangani@gmail.com");
        crew.setPassportNumber("SLJALJLJ");

        crew.setStatusId(Crew.Status.NEW_RECRUIT.getId());
        crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
        crewDao.insert(crew);
    }

    @Test
    void getCrewDOB() {
        Crew crew = crewDao.findById(29l).get();
        System.out.println(crew.getDob().toString());

        List<Crew> crews = crewDao.findByDOB(LocalDate.of(1985, 7, 22));
        Assert.assertNotNull(crews);
        crews.forEach(c -> {
            System.out.println(c.getFullName());
        });

    }

    @Test
    void updateName() {
        Crew crew = crewService.getById(1);
        crew.setFirstName("Rohan");
        crew.setMiddleName("P");
        crew.setLastName("Tiwari");
        crewDao.save(crew);

    }

    @Test
    void updateRank() {
        Crew crew = crewService.getById(1);
        crew.setRankId(Rank.CAPTAIN.getId());
        crewDao.save(crew);

    }

    @Test
    void updateDOB() {
        Crew crew = crewService.getById(1);
        LocalDate dob = LocalDate.of(1985, 11, 20);
        crew.setDob(dob);
        crewDao.save(crew);

    }

    @Test
    void updatePassport() {
        Crew crew = crewService.getById(1);
        crew.setId(1);
        crew.setPassportNumber("PP-ADA24234A");
        crew.setIndosNumber("INDOS-ADA24234A");
        crewDao.save(crew);

    }

    @Test
    void updateFlag() {
        Crew crew = crewDao.findById(26l).get();
        Flag flag = flagDao.getByCode("IN");
        crew.setNationalityFlagId(flag.getId());
        crewDao.save(crew);
    }

    @Test
    void updateEducationDetails() {
        Crew crew = crewDao.findById(29l).get();
        Flag flag = flagDao.findById(crew.getNationalityFlagId()).get();


        //Education
        Education ssc = new Education();
        ssc.setEducationName("S.S.C");
        ssc.setInstituteName("Sharon School");
        ssc.setInstituteAddress("Mulund, Mumbai");
        ssc.setPercentage(50f);
        ssc.setFlag(flag);

        EducationDocument sscDoc = new Certificate();
        //sscDoc.setFile();
        ssc.setEducationDocuments(new ArrayList<>(Arrays.asList(sscDoc)));

        Education hsc = new Education();
        hsc.setEducationName("H.S.C");
        hsc.setInstituteName("Somaiya College");
        hsc.setInstituteAddress("Vidyavihar, Mumbai");
        hsc.setPercentage(90.99f);
        hsc.setFlag(flag);

        EducationDocument hscDoc = new Certificate();
        //empDoc2.setFile();
        hsc.setEducationDocuments(new ArrayList<>(Arrays.asList(hscDoc)));

        crew.setEducationHistory(new ArrayList<>(Arrays.asList(ssc, hsc)));
        crewDao.save(crew);
    }

    @Test
    void updateEmploymentDetails() {
        Crew crew = crewService.getById(1);
        Flag flag = flagDao.getByCode("IN");

        //Employment
        Experience emp1 = new Experience();
        emp1.setEmployerName("Merks");
        emp1.setEmployerAddress("Mumbai");
        //Vessel v = new Vessel();
       // v.setGrossTonnage(7000);
        //emp1.setVessel(v);
        emp1.setLastRank(Rank.JR_ENGINEER);
        emp1.setVesselSubType(VesselSubType.LPG_TANKER);
        //emp1.setStartDate(new LocalDateTime());
        //emp1.setEndDate(new LocalDateTime());
        emp1.setFlag(flag);
        List<EmploymentDocument> emp1Docs = new ArrayList<>();

        EmploymentDocument emp1Doc1 = new SalarySlip();
        //empDoc2.setFile();
        emp1Docs.add(emp1Doc1);

        EmploymentDocument emp1Doc2 = new ExperienceLetter();
        //empDoc2.setFile();
        emp1Docs.add(emp1Doc2);
        emp1.setEmploymentDocuments(emp1Docs);

        Experience emp2 = new Experience();
        emp2.setEmployerName("MSC");
        emp2.setEmployerAddress("Mumbai");
        //v = new Vessel();
       // v.setGrossTonnage(500);
       // emp1.setVessel(v);
        emp2.setLastRank(Rank.JR_ENGINEER);
        emp2.setVesselSubType(VesselSubType.LNG_TANKER);
        //emp2.setStartDate(new LocalDateTime());
        //emp2.setEndDate(new LocalDateTime());

        List<EmploymentDocument> emp2Docs = new ArrayList<>();
        EmploymentDocument emp2Doc1 = new SalarySlip();
        //empDoc2.setFile();
        emp2Docs.add(emp2Doc1);

        EmploymentDocument emp2Doc2 = new ExperienceLetter();
        //empDoc2.setFile();
        emp2Docs.add(emp2Doc2);
        emp2.setEmploymentDocuments(emp2Docs);
        emp2.setFlag(flag);
        crew.setEmploymentHistory(new ArrayList<>(Arrays.asList(emp1, emp2)));

        crewDao.save(crew);
    }

    @Test
    void updateNextOfKinDetails() {
        Crew crew = crewDao.findById(26l).get();
        NextOfKin nok1 = new NextOfKin();
        nok1.setNomineeName("Vrushali Rohan Tiwari");
       // nok1.setDateOfBirth("12-Mar-1983");
        nok1.setRelationType(NextOfKin.RelationType.WIFE.getRelationTypeName());
        nok1.setAddress("Same as above");
        nok1.setGender("female");
        nok1.setPerOfAmount(60);

        NextOfKin nok2 = new NextOfKin();
        nok2.setNomineeName("Kanchan Pradeep Tiwari");
        //nok2.setDateOfBirth("12-Apr-1964");
        nok2.setRelationType(NextOfKin.RelationType.MOTHER.getRelationTypeName());
        nok2.setAddress("Same as above");
        nok2.setGender("female");
        nok2.setPerOfAmount(40);

        //Below 18
        NextOfKin nok3 = new NextOfKin();
        nok3.setNomineeName("Tanishqa Tiwari");
        //nok3.setDateOfBirth("21-Oct-2012");
        nok3.setRelationType(NextOfKin.RelationType.DAUGHTER.getRelationTypeName());
        nok3.setAddress("Same as above");
        nok3.setGender("female");

        NextOfKin nok4 = new NextOfKin();
        nok4.setNomineeName("Shamika Tiwari");
       // nok4.setDateOfBirth("16-Jun-2015");
        nok4.setRelationType(NextOfKin.RelationType.DAUGHTER.getRelationTypeName());
        nok4.setAddress("Same as above");
        nok4.setGender("female");

        List<NextOfKin> nextOfKins = new LinkedList<>();
        nextOfKins.add(nok1);
        nextOfKins.add(nok2);
        nextOfKins.add(nok3);
        nextOfKins.add(nok4);
        crew.setNextOfKins(nextOfKins);
        crewDao.save(crew);
    }

    @Test
    void uploadOtherDocs() {
        Crew crew = crewDao.findById(26l).get();
        List<Document> preJoiningMandatoryDocs = documentDao.findAll();
        crew.setPreJoiningDocuments(preJoiningMandatoryDocs);
        crewDao.save(crew);
    }

    @Test
    void uploadBankDetails() {
        Crew crew = crewDao.findById(29l).get();

        Bank bank = new Bank();
        bank.setBankName("HDFC Bank");
        bank.setPrimary(true);
        bank.setAccountNumber("10001");
        bank.setMicrCode("3434");
        bank.setSwiftCode("SWI2323");
        bank.setFlag(flagDao.getByCode("IN"));

        crew.setBanks(new ArrayList<>(Arrays.asList(bank)));
        crewDao.save(crew);
    }

    @Test
    void updateCrewDetails() {
        Crew crew = crewDao.findById(26l).get();
        Flag flag = flagDao.findById(crew.getNationalityFlagId()).get();

        List<Education> eduList = crew.getEducationHistory();
        List<Experience> empList = crew.getEmploymentHistory();

        List<Document> existingDocs = crew.getExistingDocuments();
        System.out.println(existingDocs != null ? existingDocs.size() : 0);
        List<Document> preJoiningMandatoryDocs = documentDao.getPostJoinMandatoryByFlag(flag.getId());
        System.out.println(preJoiningMandatoryDocs != null ? preJoiningMandatoryDocs.size() : 0);

        if (existingDocs == null) {
            AtomicInteger countExistingDocs = new AtomicInteger();
            preJoiningMandatoryDocs.forEach(mandateDoc -> {
                if (mandateDoc.isRequiredBeforeJoining()) {
                    if (docTypeDao.findByName("Indian Passport").getId() == mandateDoc.getDocTypeId()) {
                        Passport pp = (Passport) mandateDoc;
                        pp.setDocNumber("KJHDKSHJD");
                        pp.setDocName("Rohan's Indian Passport");
                        pp.setGivenName("Tiwari Rohan Pradeep");
                        pp.setUploaded(true);
                        countExistingDocs.getAndIncrement();
                    } else if (mandateDoc.getClass().equals(NationalID.class)) {
                        if (docTypeDao.findByName("Pan Card").getId() == mandateDoc.getDocTypeId()) {
                            TaxID panCard = (TaxID) mandateDoc;
                            panCard.setDocNumber("ANHG2131");
                            panCard.setDocName("Rohan Pan Card");
                            panCard.setGivenName("Rohan P Tiwari");
                            panCard.setUploaded(true);
                            countExistingDocs.getAndIncrement();
                        }

                    }

                }
            });
            crew.setExistingDocuments(preJoiningMandatoryDocs);
            crewDao.save(crew);
        }

    }


    @Test
    void testGetList() {
        List<Crew> crews = crewDao.findAll();
        crews.forEach(c->System.out.println(c.getFirstName()));
        crews = crewService.getList();
        crews.forEach(c->System.out.println(c.getFirstName()));
        Crew c = crewService.getById(1);
        System.out.println(c.getFirstName());
    }
    @Test
    void testExperienceList() {
        List<Experience> experienceList = crewService.getEmploymentHistory(1);
        experienceList.forEach(e->System.out.println(e.getEmployerName()));
    }
    @Test
    void testTravelAndAccomodationList() {
        List<TravelAndAccomodation> travelList = crewService.getTravelAndAccomodationHistory(1);
        //travelList.forEach(e->System.out.println(Travel.TravelMode.createFromId(e.get()).getName()));
    }
    @Test
    void generateContract() {
        //Get Crew Details
        Crew crew = crewDao.findById(26l).get();

        //Get Vessel details on which the crew has been assigned
        VesselVacancy vacancy = vesselVacancyDao.findVacancyByCrewId(crew.getId());

        //Get Vessel details
        Vessel vessel = vesselDao.findById(vacancy.getVesselId()).get();


        CrewContract contract = new CrewContract();
        contract.setId(sequenceGenerator.generateSequence(CrewContract.SEQUENCE_NAME));
        contract.setRankId(Rank.CAPTAIN.getId());
        contract.setCrewId(crew.getId());
        contract.setVesselId(vacancy.getVesselId());
        contract.setPlaceOfContract("Mumbai");
        Flag flag = flagDao.findById(crew.getNationalityFlagId()).get();
        contract.setPlaceOfContractFlag(flag);
        contract.setMonthlyWage(new BigDecimal(15000));
        contract.setWageCurrency("USD");
        contract.setStatusId(CrewContract.Status.GENERATED.getId());

        //Generate Contract Docs
        ContractDocumentGenerator wordDocument = new ContractDocumentGenerator(crew, vessel, contract);
        try {
            wordDocument.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Add Contract
        crewContractDao.insert(contract);


    }

    @Test
    void addTravelAndAccomodation() {
        CrewContract contract = crewContractDao.findById(1l).get();
        Flight flight = new Flight();
        flight.setFlightName("Air India");
        flight.setFlightNumber("12434");
        flight.setTravelModeId(Travel.TravelMode.FLIGHT.getId());
        flight.setStartLocalDateTime(LocalDateTime.of(2022, 3, 23, 22, 20, 2));
        flight.setEndLocalDateTime(LocalDateTime.of(2022, 3, 23, 0, 20, 2));

        Hotel hotel = new Hotel();
        hotel.setAccomodationName("Oberoi");
        hotel.setStartLocalDateTime(LocalDateTime.of(2022, 3, 24, 02, 30, 2));
        hotel.setEndLocalDateTime(LocalDateTime.of(2022, 3, 24, 04, 30, 2));
        flight.setTravelModeId(Accomodation.AccomodationType.HOTEL.getId());
        contract.setTravelAndAccomodations(new LinkedList<>(Arrays.asList(flight, hotel)));

        crewContractDao.save(contract);

    }

}
