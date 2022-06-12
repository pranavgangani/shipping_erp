package com.intuitbrains.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.dao.vessel.VesselOwnerRepository;
import com.intuitbrains.dao.vessel.VesselRepository;
import com.intuitbrains.dao.vessel.VesselVacancyRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.Experience;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.vessel.*;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.util.ListUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class VacancyTest {
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
    void findVesselsWithVacancies() {
		/*Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^A"));
		List<User> users = mongoTemplate.find(query,User.class);*/

        List<Vacancy> vacancies = vesselVacancyDao.findVacanciesByRank((int) Rank.CHIEF_OFFICER.getId());
        vacancies.forEach(v -> {
            Vessel vessel = vesselDao.findById(v.getId()).get();
            VesselVacancyAttributes att = v.getVacancyAttributes();
            System.out.print("[" + vessel.getVesselName() + "] has VACANCY -> ");
            System.out.print(" Min Gross Tonnage [" + att.getMinGrossTonnage() + "] | ");
            System.out.print(" Min Ranks required [");
            att.getMinRankList().forEach(rank -> {
                System.out.print(rank.getName() + ", ");
            });
            System.out.print("] | ");
            System.out.print(" Min Vessel Experince in [");
            if (att.getMinVesselSubTypeIdList() != null && !att.getMinVesselSubTypeIdList().isEmpty()) {
                att.getMinVesselSubTypeIdList().forEach(vesselSubType -> {
                    System.out.print(vesselSubType.getDesc() + ", ");
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
            List<Experience> employmentList = c.getEmploymentHistory();
            final List<Integer> rankExp = new ArrayList<>();
            if(ListUtil.isNotEmpty(employmentList)) {
                employmentList.forEach(emp -> rankExp.add(emp.getLastRank().getId()));
                final List<Vacancy> vacancies = vesselVacancyDao.findVacanciesByRanks(rankExp);
                if(ListUtil.isNotEmpty(vacancies)) {
                    System.out.println("Got ["+vacancies.size()+"]  vacancies for "+c.getFullName() + " | CrewId:"+c.getId());
                    vacancies.forEach(v->{
                        System.out.print("VacancyID::"+v.getId() + " for Post [");
                        v.getVacancyAttributes().getMinRankList().forEach(r->{
                            System.out.println(r.getName());
                        });
                        System.out.print("]");
                        System.out.println();
                    });
                    System.out.println("------------------------");
                }
            }
        });
    }


    @Test
    void assignCrewToVessel() {
        Crew crew = crewDao.findById(26l).get();
        Vacancy vacancy = vesselVacancyDao.findById(21l).get();
        //vacancy.setFilledByCrewId(crew.getId());
        vacancy.setStatusId(Vacancy.Status.PENDING_DOCS.getId());
        vesselVacancyDao.save(vacancy);

        crew.setStatusId(Crew.Status.PENDING_DOCS.getId());
        crewDao.save(crew);
    }


    @Test
    void getVesselSubTypes() {
        VesselSubType.getList().forEach(v->System.out.println(v.getDesc() + " ("+v.getVesselType()+")"));
    }

}
