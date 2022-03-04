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
	void addVessel(){
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
	void addVacancyToVessel(){

		List<VesselVacancy> vacancies = new ArrayList<>();

		//Find Vessel
		Vessel vessel = vesselDao.findById(12l).get();

		VesselVacancy vac1 = new VesselVacancy();
		vac1.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
		vac1.setVesselId(vessel.getId());
		vac1.setRankId(Rank.CAPTAIN.getId());

		VesselVacancy vac2 = new VesselVacancy();
		vac2.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
		vac2.setVesselId(vessel.getId());
		vac2.setRankId(Rank.CHIEF_ENGINEER.getId());

		VesselVacancy vac3 = new VesselVacancy();
		vac3.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
		vac3.setVesselId(vessel.getId());
		vac3.setRankId(Rank.CHIEF_OFFICER.getId());

		VesselVacancy vac4 = new VesselVacancy();
		vac4.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
		vac4.setVesselId(vessel.getId());
		vac4.setRankId(Rank.CHIEF_COOK.getId());

		//vacancies.add(vac1);
		//vacancies.add(vac2);
		//vacancies.add(vac3);
		vacancies.add(vac4);

		//vesselVacancyDao.insert(vac1);
		//vesselVacancyDao.insert(vac2);
		//vesselVacancyDao.insert(vac3);
		vesselVacancyDao.insert(vac4);
		//mongoTemplate.getCollection(VESSEL_VACANCY).insertMany(vacancies);

		//Add Vacancy
		/*VesselVacancy vacancy = new VesselVacancy();
		vacancy.setVesselId(vessel.getId());
		vacancy.setRankId(Rank.BOSUN.getId());
		vesselVacancyDao.save(vacancy);*/
	}

	@Test
	void findVesselsWithVacancies(){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^A"));
		List<User> users = mongoTemplate.find(query,User.class);

		List<VesselVacancy> vacancies = vesselVacancyDao.findVacanciesByRank((int)Rank.CHIEF_COOK.getId());
		vacancies.forEach(v->{
			Vessel vessel = vesselDao.findById(v.getVesselId()).get();
			System.out.println(vessel.getVesselName() + " has " + Rank.createFromId((int) v.getRankId()).getName());
		});
	}
}
