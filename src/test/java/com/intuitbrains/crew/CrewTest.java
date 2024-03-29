package com.intuitbrains.crew;

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
import com.intuitbrains.model.common.Address;
import com.intuitbrains.model.common.Duration;
import com.intuitbrains.model.common.DurationType;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.common.document.category.*;
import com.intuitbrains.model.company.compensation.*;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.*;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.model.vessel.Vacancy;
import com.intuitbrains.service.common.ContractDocumentGenerator;
import com.intuitbrains.service.common.OfferLetterGenerator;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.service.vessel.VesselService;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.ListUtil;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import net.sf.jasperreports.engine.JRException;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

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
    private VesselService vesselService;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private CrewService crewService;
    @Autowired
    private MongoDatabase db;

    @Test
    void addNewCrewDetails() {
        LocalDate dob = LocalDate.of(1985, 7, 24);

        Flag flag = flagDao.getByCode("IN");

        Crew crew = new Crew();
        crew.setFirstName("Pranav");
        crew.setMiddleName("J");
        crew.setLastName("Gangani");
        crew.setDob(dob);
        crew.setGender("male");
        crew.setMaritalStatus(Crew.MaritalStatus.MARRIED.getDesc());
        crew.setRank(Rank.CHIEF_ENGINEER);
        crew.setNationalityFlag(flag);
        //crew.setNationality("Indian");
        Address address = new Address();
        address.setAddress("A/4 Brahma, Wagle Estate, Shree Nagar, Thane");
        crew.setPermAddress(address);
        crew.setPresentAddress(crew.getPermAddress());
        crew.setDistinguishingMark("Some mark on head");

        crew.setEmailId("pgangani@gmail.com");
        crew.setPassportNumber("SLJALJLJ");


        //Education
        Education ssc = new Education();
        ssc.setEducationName("S.S.C");
        ssc.setInstituteName("Sharon School");
        ssc.setInstituteAddress("Mulund, Mumbai");
        ssc.setPercentage(50f);
        ssc.setFlagCode("IN");
        ssc.setStartDate(LocalDate.of(2001, 4, 23));
        ssc.setEndDate(LocalDate.of(2002, 4, 23));

        EducationDocument sscDoc = new Certificate();
        sscDoc.setDocType(docTypeDao.findByName("SSC"));
        //sscDoc.setFile();
        ssc.setEducationDocuments(new ArrayList<>(Arrays.asList(sscDoc)));

        Education hsc = new Education();
        hsc.setEducationName("H.S.C");
        hsc.setInstituteName("Somaiya College");
        hsc.setInstituteAddress("Vidyavihar, Mumbai");
        hsc.setPercentage(90.99f);
        ssc.setFlagCode("IN");
        hsc.setStartDate(LocalDate.of(2003, 4, 23));
        hsc.setEndDate(LocalDate.of(2006, 4, 23));

        EducationDocument hscDoc = new Certificate();
        hscDoc.setDocType(docTypeDao.findByName("HSC"));
        //empDoc2.setFile();
        //hsc.setEducationDocuments(new ArrayList<>(Arrays.asList(hscDoc)));

        crew.setEducationHistory(new ArrayList<>(Arrays.asList(ssc, hsc)));

        crew.setEnteredBy(employeeDao.findByEmailId("pgangani@saar.com"));
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
        crew.setDistinguishingMark("Some mark on head");
        crew.setNationalityFlag(flag);

        Address address = new Address();
        address.setAddress("A/4 Brahma, Wagle Estate, Shree Nagar, Thane");
        crew.setPermAddress(address);
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
        Crew crew = crewService.getObjectById(4);
        Bson updates = Updates.set("rank", Rank.CAPTAIN);
        Bson filter = Filters.eq("_id", 4);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);
    }

    @Test
    void updateNationality() {
        Flag flag = flagDao.getByCode("IN");
        Bson updates = Updates.set("nationalityFlag", flag);
        Bson filter = Filters.eq("_id", 4);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);

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
        crew.setNationalityFlag(flag);
        crewDao.save(crew);
    }

    @Test
    void updateEducationDetails() {
        Crew crew = new Crew();
        crew.setId(24);
        //Flag flag = flagDao.findById(crew.getNationalityFlagId()).get();


        //Education
        Education ssc = new Education();
        ssc.setEducationName("S.S.C");
        ssc.setInstituteName("Vani School");
        ssc.setInstituteAddress("Mulund, Mumbai");
        ssc.setPercentage(50f);
        // ssc.setFlag(flag);

        EducationDocument sscDoc = new Certificate();
        //sscDoc.setFile();
        ssc.setEducationDocuments(new ArrayList<>(Arrays.asList(sscDoc)));

        Education hsc = new Education();
        hsc.setEducationName("H.S.C");
        hsc.setInstituteName("Raheja College");
        hsc.setInstituteAddress("Vidyavihar, Mumbai");
        hsc.setPercentage(90.99f);
        // hsc.setFlag(flag);

        EducationDocument hscDoc = new Certificate();
        //empDoc2.setFile();
        hsc.setEducationDocuments(new ArrayList<>(Arrays.asList(hscDoc)));

        crew.setEducationHistory(new ArrayList<>(Arrays.asList(ssc, hsc)));
        Bson updates = Updates.set("educationHistory", new ArrayList<>(Arrays.asList(ssc, hsc)));
        Bson filter = Filters.eq("_id", 24);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);
    }

    @Test
    void updateEmploymentDetails() {
        //Crew crew = crewService.getById(25);
        Crew crew = new Crew();
        crew.setId(1);
        Flag flag = flagDao.getByCode("IN");

        //Employment
        Experience emp1 = new Experience();
        emp1.setEmployerName("Merks");
        emp1.setEmployerAddress("Mumbai");
        //Vessel v = new Vessel();
        // v.setGrossTonnage(7000);
        //emp1.setVessel(v);
        emp1.setLastRankId(Rank.JR_ENGINEER.getId());
        emp1.setVesselSubType(VesselSubType.LPG_TANKER);
        //emp1.setStartDate(new LocalDateTime());
        //emp1.setEndDate(new LocalDateTime());
        emp1.setFlagCode(flag.getCode());
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
        emp2.setLastRankId(Rank.JR_ENGINEER.getId());
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
        emp2.setFlagCode(flag.getCode());
        crew.setEmploymentHistory(new ArrayList<>(Arrays.asList(emp1, emp2)));

        Bson updates = Updates.set("employmentHistory", new ArrayList<>(Arrays.asList(emp1, emp2)));
        Bson filter = Filters.eq("_id", 1);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);
        // crewDao.save(crew);
    }

    @Test
    void updateNextOfKinDetails() {
        Crew crew = new Crew();
        crew.setId(4);
        NextOfKin nok1 = new NextOfKin();
        nok1.setNomineeName("Vrushali Rohan Tiwari");
        // nok1.setDateOfBirth("12-Mar-1983");
        nok1.setRelationType(RelationType.WIFE.getRelationTypeName());
        nok1.setAddress("Same as above");
        nok1.setPerOfAmount(60);

        NextOfKin nok2 = new NextOfKin();
        nok2.setNomineeName("Kanchan Pradeep Tiwari");
        //nok2.setDateOfBirth("12-Apr-1964");
        nok2.setRelationType(RelationType.MOTHER.getRelationTypeName());
        nok2.setAddress("Same as above");
        nok2.setPerOfAmount(40);

        //Below 18
        NextOfKin nok3 = new NextOfKin();
        nok3.setNomineeName("Tanishqa Tiwari");
        //nok3.setDateOfBirth("21-Oct-2012");
        nok3.setRelationType(RelationType.DAUGHTER.getRelationTypeName());
        nok3.setAddress("Same as above");

        NextOfKin nok4 = new NextOfKin();
        nok4.setNomineeName("Shamika Tiwari");
        // nok4.setDateOfBirth("16-Jun-2015");
        nok4.setRelationType(RelationType.DAUGHTER.getRelationTypeName());
        nok4.setAddress("Same as above");

        List<NextOfKin> nextOfKins = new LinkedList<>();
        nextOfKins.add(nok1);
        nextOfKins.add(nok2);
        nextOfKins.add(nok3);
        nextOfKins.add(nok4);
        crew.setNextOfKins(nextOfKins);

        Bson updates = Updates.set("nextOfKins", nextOfKins);
        Bson filter = Filters.eq("_id", 4);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);
    }

    @Test
    void uploadOtherDocs() {
        Crew crew = crewDao.findById(26l).get();
        List<CrewDocument> preJoiningMandatoryDocs = documentDao.findAll();
        //crew.setPreJoiningDocuments(preJoiningMandatoryDocs);
        crewDao.save(crew);
    }

    @Test
    void uploadBankDetails() {
        Crew crew = crewService.getById(1);

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

 /*   @Test
    void updateCrewDetails() {
        Crew crew = crewDao.findById(26l).get();
        Flag flag = flagDao.findById(crew.getNationalityFlagId()).get();

        List<Education> eduList = crew.getEducationHistory();
        List<Experience> empList = crew.getEmploymentHistory();

        List<? extends Document> existingDocs = crew.getExistingDocuments();
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
*/

    @Test
    void testGetList() {
        List<Crew> crews = crewDao.findAll();
        crews.forEach(c -> System.out.println(c.getFirstName()));
        crews = crewService.getList();
        crews.forEach(c -> System.out.println(c.getFirstName()));
        Crew c = crewService.getById(1);
        System.out.println(c.getFirstName());
    }

    @Test
    void testExperienceList() {
        List<Experience> list = crewService.getEmploymentHistory(24);
        list.forEach(e -> System.out.println(e.getEmployerName()));
    }

    @Test
    void testEducationList() {
        List<Education> list = crewService.getEducationHistory(24);
        list.forEach(e -> System.out.println(e.getInstituteName()));
    }

    @Test
    void testCast() {

    }

    @Test
    void testGetPPVisa() {
        List<CrewDocument> list = crewService.getPassportVisa(4);
        List<Passport> passports = new ArrayList<>();
        List<Visa> visas = new ArrayList<>();
        for (CrewDocument doc : list) {
            if (doc instanceof Passport) {
                Passport pp = (Passport) doc;
                passports.add(pp);
            } else if (doc instanceof Visa) {
                Visa visa = (Visa) doc;
                visas.add(visa);
            }
        }
        //List<Passport> passport = list.stream().filter(TravelDocument.class::isInstance).map(Passport.class::cast).collect(Collectors.toList());

        list.forEach(e -> System.out.println("Doc = " + e.getDocType().getName()));
    }

    @Test
    void testAddPassportAndVisa() {
        List<DocumentType> documentTypes = docTypeDao.findAll();
        List<CrewDocument> existingDocs = new ArrayList<>();
        for (DocumentType dt : documentTypes) {
            if (dt.getDocumentPool().equals(DocumentPool.PASSPORT)) {
                Passport pp = new Passport();
                pp.setCrewId(1);
                pp.setDocNumber("12433453");
                pp.setGivenName("Tiwari Rohan Pradeep");
                pp.setRequiredECNR(false);
                pp.setBlankPages(10);
                // pp.setFlagCode("IN");
                pp.setDateOfIssue(LocalDate.of(2020, 2, 20));
                pp.setDateOfExpiry(LocalDate.of(2040, 2, 20));
                pp.setPlaceOfIssue("Mumbai, India");
                pp.setDocType(dt);
                existingDocs.add(pp);
            } else if (dt.getDocumentPool().equals(DocumentPool.VISA)) {
                Visa visa = new Visa();
                visa.setCrewId(1);
                visa.setDocNumber("5678890");
                visa.setGivenName("Tiwari Rohan Pradeep");
                //visa.setFlagCode("US");
                visa.setDateOfIssue(LocalDate.of(2018, 2, 20));
                visa.setDateOfExpiry(LocalDate.of(2028, 2, 20));
                visa.setPlaceOfIssue("NY, USA");
                visa.setDocType(dt);
                existingDocs.add(visa);
            }
        }
     /*   Bson updates = Updates.set("existingDocuments", existingDocs);
        Bson filter = Filters.eq("_id", 24);
        db.getCollection(Collection.CREW, Crew.class).updateOne(filter, updates);*/
        for (CrewDocument doc : existingDocs) {
            doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
        }
        documentDao.insert(existingDocs);

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
        Vacancy vacancy = vesselVacancyDao.findVacancyByCrewId(crew.getId());

        //Get Vessel details
        Vessel vessel = vesselService.getById(vacancy.getVessel().getId());


        CrewContract contract = new CrewContract();
        contract.setId(sequenceGenerator.generateSequence(CrewContract.SEQUENCE_NAME));
        contract.setRank(Rank.CAPTAIN);
        contract.setCrew(crew);
        contract.setVessel(vacancy.getVessel());
        contract.setPlaceOfContract("Mumbai");
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
    void generateOfferLetter() throws JRException, IOException {
        Crew crew = crewDao.findById(4l).get();
        OfferLetter offerLetter = new OfferLetter();
        offerLetter.setVesselName("Some vessel name");
        offerLetter.setAgreedRank(Rank.CAPTAIN);
        offerLetter.setAgreedWages(1000);
        offerLetter.setContractPeriod(new Duration(DurationType.MONTHS, 6));

        List<Remuneration> remunerations = new ArrayList<>();
        remunerations.add(new Remuneration(RemunerationType.BASIC, 100.00d));
        remunerations.add(new Remuneration(RemunerationType.FIXED_OVETIME, 200.00d));
        remunerations.add(new Remuneration(RemunerationType.PENSION_FUND, 1000.00d));
        List<Reimbursement> reimbursements = new ArrayList<>();
        reimbursements.add(new Reimbursement(ReimbursementType.JOINING_ALLOWANCE, 1001.00d));

        //List<Deduction> deductions = new ArrayList<>();
        //deductions.add(new Deduction(DeductionType.NIL, 0d));

        offerLetter.setRemunerations(remunerations);
        offerLetter.setReimbursements(reimbursements);
        offerLetter.setDeductions(null);
        OfferLetterGenerator offerLetterGenerator = new OfferLetterGenerator(crew, offerLetter);
        offerLetterGenerator.generate("E:\\");
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

    @Test
    void calculateExp() {
        Crew crew = new Crew();
        List<Experience> exps = new ArrayList<>();
        Experience exp = new Experience();
        exp.setStartDate(LocalDate.of(2008, 1, 1));
        exp.setEndDate(LocalDate.of(2008, 5, 31));
        exps.add(exp);

        exp = new Experience();
        exp.setStartDate(LocalDate.of(2010, 1, 1));
        exp.setEndDate(LocalDate.of(2012, 5, 31));
        exps.add(exp);

        crew.setEmploymentHistory(exps);
        long expInMonths = 0;
        if (ListUtil.isNotEmpty(crew.getEmploymentHistory())) {
            for (Experience e : crew.getEmploymentHistory()) {
                LocalDate startDate = e.getStartDate();
                LocalDate endDate = e.getEndDate();
                expInMonths += DateTimeUtil.differenceInMonths(startDate, endDate);
            }
        }
        Logger.getGlobal().info("expInMonths = "+expInMonths);
    }

}
