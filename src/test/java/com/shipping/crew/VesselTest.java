package com.shipping.crew;

import com.jayway.jsonpath.Criteria;
import com.shipping.common.Flag;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.vessel.VesselOwnerRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.dao.vessel.VesselVacancyRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.model.common.document.Certificate;
import com.shipping.model.common.document.ExperienceLetter;
import com.shipping.model.common.document.Passport;
import com.shipping.model.common.document.SalarySlip;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.EducationDocument;
import com.shipping.model.common.document.category.EmploymentDocument;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.Education;
import com.shipping.model.crew.Employment;
import com.shipping.model.crew.Rank;
import com.shipping.model.vessel.*;
import com.shipping.service.common.SequenceGeneratorService;
import com.shipping.util.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shipping.common.Collection.VESSEL_VACANCY;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class VesselTest {
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private VesselOwnerRepository vesselOwnerDao;
    @Autowired
    private CommonDocumentRepository documentDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    void addVessel() {
        VesselOwner vesselOwner = vesselOwnerDao.findById(2l).get();
        Flag flag = flagDao.getByCode("IN");
        Vessel vessel = new Vessel();
        vessel.setVesselOwner(vesselOwner);
        vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
        vessel.setVesselName("Some Indian Vessel");
        vessel.setBeam(100);
        vessel.setLength(101);
        vessel.setDraught(103);
        vessel.setYearOfBuilt(2001);
        vessel.setFlag(flag);
        vessel.setCapacity(10);
        vessel.setCallSign("AHS12A");
        vessel.setGrossTonnage(5100);
        vessel.setActive(true);
        vessel.setMmsi("JA8081MA");
        vessel.setVesselSubType(VesselSubType.BULK_CARRIER);
        vesselDao.insert(vessel);
    }

    @Test
    void addVacancyToVessel() {

        //Find Vessel
        Vessel vessel = vesselDao.findById(12l).get();

        VesselVacancy vacancy = new VesselVacancy();
        vacancy.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
        vacancy.setVesselId(vessel.getId());

        //All Vacancies
        List<VesselVacancyAttributes> vacancyAttributes = new ArrayList<>();

        //Vacancy#1
        VesselVacancyAttributes vacancy1 = new VesselVacancyAttributes();
        //Add Min Rank Attributes
        vacancy1.setMinRankList(new ArrayList<>(Arrays.asList(Rank.CAPTAIN.getId())));

        //Add Min Vessel Type Attributes
        vacancy1.setMinVesselSubTypeIdList(new ArrayList<>(Arrays.asList(
                VesselSubType.LNG_TANKER.getId(),
                VesselSubType.LPG_TANKER.getId(),
                VesselSubType.FSO_TANKER.getId(),
                VesselSubType.OIL_PROD_TANKER.getId()
        )));

        //Min Gross Tonn
        vacancy1.setMinGrossTonnage(1000);

        //Vacancy#2
        VesselVacancyAttributes vacancy2 = new VesselVacancyAttributes();
        //Add Min Rank Attributes
        vacancy2.setMinRankList(new ArrayList<>(Arrays.asList(Rank.SECOND_OFFICER.getId())));

        //Open for any Vessel Experience
        //So no Vessel Sub Type added

        //Min Gross Tonn
        vacancy2.setMinGrossTonnage(7000);


        //-->Add Vacancy Attributes
        vacancyAttributes.add(vacancy1);
        vacancyAttributes.add(vacancy2);

        vacancy.setVacancyAttributes(vacancyAttributes);
        vesselVacancyDao.insert(vacancy);

        //mongoTemplate.getCollection(VESSEL_VACANCY).insertMany(vacancies);

    }

    @Test
    void findVesselsWithVacancies() {
		/*Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^A"));
		List<User> users = mongoTemplate.find(query,User.class);*/

        List<VesselVacancy> vacancies = vesselVacancyDao.findVacanciesByRank((int) Rank.CHIEF_OFFICER.getId());
        vacancies.forEach(v -> {
            Vessel vessel = vesselDao.findById(v.getVesselId()).get();
            List<VesselVacancyAttributes> attributes = v.getVacancyAttributes();
            attributes.forEach(att -> {
                System.out.print("[" + vessel.getVesselName() + "] has VACANCY -> ");
                System.out.print(" Min Gross Tonnage [" + att.getMinGrossTonnage() + "] | ");
                System.out.print(" Min Ranks required [");
                att.getMinRankList().forEach(rankId -> {
                    System.out.print(Rank.createFromId(rankId).getName() + ", ");
                });
                System.out.print("] | ");
                System.out.print(" Min Vessel Experince in [");
                if (att.getMinVesselSubTypeIdList() != null && !att.getMinVesselSubTypeIdList().isEmpty()) {
                    att.getMinVesselSubTypeIdList().forEach(vesselSubTypeId -> {
                        System.out.print(VesselSubType.createFromId(vesselSubTypeId).getDesc() + ", ");
                    });
                }else {
                    System.out.print("Any Vessel");
                }
                System.out.print(" ]");
                System.out.println();
            });
        });
    }
}
