package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.CrewDocumentRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.vessel.VesselOwnerRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.dao.vessel.VesselVacancyRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.Employment;
import com.shipping.model.crew.Rank;
import com.shipping.model.vessel.*;
import com.shipping.service.common.SequenceGeneratorService;
import com.shipping.util.ListUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class VesselVacancyTest {
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private VesselOwnerRepository vesselOwnerDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private CrewRepository crewDao;
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

        //Vacancy#1
        VesselVacancyAttributes att = new VesselVacancyAttributes();
        //Add Min Rank Attributes
        att.setMinRankList(new ArrayList<>(Arrays.asList(Rank.JR_ENGINEER.getId())));

        //Add Min Vessel Type Attributes
        /*att.setMinVesselSubTypeIdList(new ArrayList<>(Arrays.asList(
                VesselSubType.LNG_TANKER.getId(),
                VesselSubType.LPG_TANKER.getId(),
                VesselSubType.FSO_TANKER.getId(),
                VesselSubType.OIL_PROD_TANKER.getId()
        )));*/

        //Min Gross Tonn
        att.setMinGrossTonnage(1000);
        vacancy.setVacancyAttributes(att);
        vacancy.setStatusId(VesselVacancy.Status.OPEN.getId());
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
            VesselVacancyAttributes att = v.getVacancyAttributes();
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
            } else {
                System.out.print("Any Vessel");
            }
            System.out.print(" ]");
            System.out.println();

        });
    }

    @Test
    void findMatchingVacanciesToCrew() {
        final List<Crew> crews = crewDao.findAll();
        crews.forEach(c->{
            List<Employment> employmentList = c.getEmploymentHistory();
            final List<Integer> rankExp = new ArrayList<>();
            employmentList.forEach(emp -> rankExp.add(emp.getLastRank().getId()));
            final List<VesselVacancy> vacancies = vesselVacancyDao.findVacanciesByRanks(rankExp);
            if(ListUtil.isNotEmpty(vacancies)) {
                System.out.println("Got ["+vacancies.size()+"]  vacancies for "+c.getName() + " | CrewId:"+c.getId());
                vacancies.forEach(v->{
                    System.out.print("VacancyID::"+v.getId() + " for Post [");
                    v.getVacancyAttributes().getMinRankList().forEach(r->{
                        System.out.println(Rank.createFromId(r).getName());
                    });
                    System.out.print("]");
                    System.out.println();
                });
                System.out.println("------------------------");
            }
        });
    }


    @Test
    void assignCrewToVessel() {
        Crew crew = crewDao.findById(26l).get();
        VesselVacancy vacancy = vesselVacancyDao.findById(21l).get();
        vacancy.setFilledByCrewId(crew.getId());
        vacancy.setStatusId(VesselVacancy.Status.PENDING_DOCS.getId());
        vesselVacancyDao.save(vacancy);

        crew.setStatusId(Crew.Status.PENDING_DOCS.getId());
        crewDao.save(crew);
    }


}
