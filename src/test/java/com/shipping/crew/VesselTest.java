package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.vessel.VesselOwnerRepository;
import com.shipping.dao.vessel.VesselRepository;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class VesselTest {
	@Autowired
	private VesselRepository vesselDao;
	@Autowired
	private VesselOwnerRepository vesselOwnerDao;
	@Autowired
	private CommonDocumentRepository documentDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private FlagRepository flagDao;

	@Test
	void addVessel(){
		VesselOwner vesselOwner = vesselOwnerDao.findById(1l).get();
		Flag flag = flagDao.getByCode("PA");
		Vessel vessel = new Vessel();
		vessel.setVesselOwner(vesselOwner);
		vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
		vessel.setVesselName("Evershine");
		vessel.setBeam(100);
		vessel.setLength(101);
		vessel.setDraught(103);
		vessel.setYearOfBuilt(1985);
		vessel.setFlag(flag);
		vessel.setCapacity(10);
		vessel.setCallSign("ASJ129");
		vessel.setGrossTonnage(5000);
		vessel.setActive(true);
		vessel.setMmsi("213ADAS");
		vessel.setVesselSubType(VesselSubType.BULK_CARRIER);

		List<VesselVacancy> vacancies = new ArrayList<>();

		VesselVacancy vac1 = new VesselVacancy();
		vac1.setRank(Rank.CAPTAIN);
		VesselVacancy vac2 = new VesselVacancy();
		vac2.setRank(Rank.CHIEF_ENGINEER);
		VesselVacancy vac3 = new VesselVacancy();
		vac3.setRank(Rank.CHIEF_OFFICER);
		VesselVacancy vac4 = new VesselVacancy();
		vac4.setRank(Rank.CHIEF_COOK);

		vacancies.add(vac1);
		vacancies.add(vac2);
		vacancies.add(vac3);
		vacancies.add(vac4);
		vessel.setVacancies(vacancies);
		vesselDao.insert(vessel);
	}

	@Test
	void addVacancyToVessel(){
		Vessel vessel = vesselDao.findById(12).get();
		VesselVacancy newVac = new VesselVacancy();
		newVac.setRank(Rank.BOSUN);
		vessel.getVacancies().add(newVac);
		vesselDao.save(vessel);
	}

}
