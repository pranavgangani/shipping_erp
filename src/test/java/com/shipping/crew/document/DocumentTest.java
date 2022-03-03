package com.shipping.crew.document;

import com.shipping.dao.common.FlagRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.model.common.document.Insurance;
import com.shipping.model.common.document.Passport;
import com.shipping.model.common.document.Visa;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.DocumentCategory;
import com.shipping.service.common.SequenceGeneratorService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class DocumentTest {
	@Autowired
	private CommonDocumentRepository documentDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private FlagRepository flagDao;

	@Test
	void addPassport() {
		Document passport = new Passport();
		passport.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		passport.setDocumentCategory(DocumentCategory.TRAVEL);
		passport.setGivenName("Pranav Gangani");
		documentDao.insert(passport);
	}

	@Test
	void addVisa() {
		Document visa = new Visa();
		visa.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		visa.setDocumentCategory(DocumentCategory.TRAVEL);
		visa.setGivenName("Rohan Tiwari");
		documentDao.insert(visa);

		Insurance insurance = new Insurance();
		insurance.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		insurance.setDocumentCategory(DocumentCategory.FINANCIAL);
		insurance.setGivenName("Rohan Tiwari");
		insurance.setDocName("Insurance of Bla Bla");
		insurance.setInsuranceCompanyName("ICICI lombard");
		insurance.setInsuredSum(10000);
		insurance.setInsuranceCompanyAddress("Mumbai, INDIA");

		insurance.setFlag(flagDao.getByCode("IN"));
		documentDao.insert(insurance);

	}
	@Test
	void addInsurance() {
		Insurance insurance = new Insurance();
		insurance.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		insurance.setDocumentCategory(DocumentCategory.FINANCIAL);
		insurance.setGivenName("Rohan Tiwari");
		insurance.setDocName("Insurance of Bla Bla");
		insurance.setInsuranceCompanyName("ICICI lombard");
		insurance.setInsuredSum(10000);
		insurance.setInsuranceCompanyAddress("Mumbai, INDIA");

		insurance.setFlag(flagDao.getByCode("IN"));
		documentDao.insert(insurance);

		System.out.println("Id:"+insurance.getId());

		//System.out.println(persistedInsurance.getInsuranceCompanyName());

	}
	@Test
	void documentGet() {
		List<Document> list = documentDao.findAll();
		list.forEach(doc->System.out.println(doc.getId() + " - "+doc.getDocumentCategory().getName() + " - "+doc.getClass().getName()));

		list.forEach(o->{
			System.out.println(o.getClass().getName());
			if(o.getClass().equals(Insurance.class)) {
				Insurance insurance = (Insurance)o;
				System.out.println(insurance.getInsuranceCompanyName());
			}
			else if(o.getClass().equals(Passport.class)) {
				Passport passport = (Passport)o;
				System.out.println(passport.getGivenName());
			}
		});
		//Document persistedInsurance = (documentDao.findById(insurance.getId()).isPresent())?documentDao.findById(insurance.getId()).get():null;
		//Assert.assertNotNull(persistedInsurance);
	}
}
