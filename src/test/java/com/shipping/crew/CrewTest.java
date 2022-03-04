package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.model.common.document.*;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.DocumentPool;
import com.shipping.model.common.document.category.EducationDocument;
import com.shipping.model.common.document.category.EmploymentDocument;
import com.shipping.model.crew.*;
import com.shipping.model.vessel.VesselType;
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
class CrewTest {
	@Autowired
	private CommonDocumentRepository documentDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private FlagRepository flagDao;
	@Autowired
	private CrewRepository crewDao;

	@Test
	void addCrewDetails() {
		LocalDate dob = LocalDate.of(1985,7,23);

		Flag flag = flagDao.getByCode("IN");

		Crew crew = new Crew();
		crew.setfName("Pranav");
		crew.setlName("Gangani");
		crew.setmName("J");
		crew.setDob(new DateTime());
		crew.setGender("male");
		crew.setRank(Rank.CHIEF_ENGINEER);
		crew.setDistinguishMark("Some mark on head");

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

		//Employment
		Employment emp1 = new Employment();
		emp1.setEmployerName("MSC");
		emp1.setEmployerAddress("Mumbai");
		emp1.setLastRank(Rank.CHIEF_ENGINEER);
		emp1.setVesselType(VesselType.CARGO);
		emp1.setStartDate(new DateTime());
		emp1.setEndDate(new DateTime());
		emp1.setFlag(flag);
		List<EmploymentDocument> emp1Docs = new ArrayList<>();

		EmploymentDocument emp1Doc1 = new SalarySlip();
		//empDoc2.setFile();
		emp1Docs.add(emp1Doc1);

		EmploymentDocument emp1Doc2 = new ExperienceLetter();
		//empDoc2.setFile();
		emp1Docs.add(emp1Doc2);
		emp1.setEmploymentDocuments(emp1Docs);

		Employment emp2 = new Employment();
		emp2.setEmployerName("MSC");
		emp2.setEmployerAddress("Mumbai");
		emp2.setLastRank(Rank.CHIEF_ENGINEER);
		emp2.setVesselType(VesselType.CARGO);
		emp2.setStartDate(new DateTime());
		emp2.setEndDate(new DateTime());

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

		crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		crewDao.insert(crew);
	}

	@Test
	void uploadOtherDocs() {

		Crew crew = crewDao.findById(25l).get();
		List<Document> preJoiningMandatoryDocs = documentDao.findAll();
		crew.setPreJoiningDocuments(preJoiningMandatoryDocs);
		crewDao.save(crew);
	}

	@Test
	void updateCrewDetails() {

		Crew crew = crewDao.findById(25l).get();
		List<Education> eduList = crew.getEducationHistory();
		List<Employment> empList = crew.getEmploymentHistory();

		List<Document> preJoiningMandatoryDocs = documentDao.findAll();
		preJoiningMandatoryDocs.forEach(doc->{
			if(doc.isRequiredBeforeJoining()) {
				if(doc.getClass().equals(Passport.class)) {
					Passport passport = new Passport();
					passport.setDocNumber("HND1234");
				}
			}
		});
		crewDao.save(crew);
	}

}