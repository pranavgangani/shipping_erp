package com.shipping.crew.document;

import com.shipping.common.Flag;
import com.shipping.dao.common.FlagRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.model.common.DurationType;
import com.shipping.model.common.document.*;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.DocumentCategory;
import com.shipping.service.common.SequenceGeneratorService;
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
	void addIndianDocs() {
		Flag flag = flagDao.getByCode("IN");

		Document passport = new Passport();
		passport.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		passport.setDocumentCategory(DocumentCategory.TRAVEL);
		passport.setFlag(flag);
		passport.setRequiredBeforeJoining(true);
		passport.setRequiredAfterJoining(true);
		documentDao.insert(passport);

		Document aadharCard = new NationalID();
		aadharCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		aadharCard.setDocumentCategory(DocumentCategory.INFORMATION);
		aadharCard.setDocName("Aadhar Card");
		aadharCard.setFlag(flag);
		aadharCard.setRequiredBeforeJoining(true);
		documentDao.insert(aadharCard);

		Document panCard = new TaxID();
		panCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		panCard.setDocumentCategory(DocumentCategory.FINANCIAL);
		panCard.setDocName("PAN Card");
		panCard.setFlag(flag);
		panCard.setRequiredBeforeJoining(true);
		documentDao.insert(panCard);

		Document cdc = new NationalID();
		cdc.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		cdc.setDocumentCategory(DocumentCategory.INFORMATION);
		cdc.setDocName("Continuous Discharge Certificate");
		cdc.setFlag(flag);
		cdc.setValidity(10);
		cdc.setDurationType(DurationType.YEARS);
		cdc.setRequiredBeforeJoining(true);
		cdc.setRequiredAfterJoining(true);
		documentDao.insert(cdc);

		Document indos = new NationalID();
		indos.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		indos.setDocumentCategory(DocumentCategory.EMPLOYMENT);
		indos.setDocName("INDOS");
		indos.setFlag(flag);
		indos.setRequiredBeforeJoining(true);
		indos.setRequiredAfterJoining(true);
		documentDao.insert(indos);

		Document yellowFeverCert = new Certificate();
		yellowFeverCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		yellowFeverCert.setDocumentCategory(DocumentCategory.MEDICAL);
		yellowFeverCert.setDocName("Yellow Fever");
		yellowFeverCert.setFlag(flag);
		yellowFeverCert.setRequiredBeforeJoining(true);
		yellowFeverCert.setRequiredAfterJoining(true);
		documentDao.insert(yellowFeverCert);

		Document drugAlcoholCert = new Certificate();
		drugAlcoholCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		drugAlcoholCert.setDocumentCategory(DocumentCategory.MEDICAL);
		drugAlcoholCert.setDocName("Drug & Alcohol Certificate");
		//drugAlcoholCert.setFlag(flag);
		drugAlcoholCert.setRequiredAfterJoining(true);
		documentDao.insert(drugAlcoholCert);

		Document cheque = new Cheque();
		cheque.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		cheque.setDocumentCategory(DocumentCategory.FINANCIAL);
		cheque.setDocName("Cheque");
		cheque.setFlag(flag);
		cheque.setRequiredBeforeJoining(true);
		documentDao.insert(cheque);

		Document ongcPass = new Pass();
		ongcPass.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		ongcPass.setDocumentCategory(DocumentCategory.TRAVEL);
		ongcPass.setDocName("ONGC Pass");
		ongcPass.setFlag(flag);
		documentDao.insert(ongcPass);

		Document aoa = new Contract();
		aoa.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		aoa.setDocumentCategory(DocumentCategory.EMPLOYMENT);
		aoa.setDocName("AOA/Contract");
		aoa.setFlag(flag);
		documentDao.insert(aoa);

		Document form3A = new Certificate();
		form3A.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		form3A.setDocumentCategory(DocumentCategory.EMPLOYMENT);
		form3A.setDocName("FORM 3A");
		form3A.setFlag(flag);
		documentDao.insert(form3A);

		List<Document> list = documentDao.findAll();
		list.forEach(doc->System.out.println(doc.getId() + " - "+doc.getDocumentCategory().getName() + " - "+doc.getClass().getName()));
	}

	void addVisas() {
		Flag usa = flagDao.getByCode("US");
		Document usVisa = new Visa();
		usVisa.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		usVisa.setDocumentCategory(DocumentCategory.TRAVEL);
		usVisa.setDocName("US Visa");
		usVisa.setDocType("B1/B2");
		usVisa.setFlag(usa);
		documentDao.insert(usVisa);
	}

	@Test
	void addInsurance() {
		Insurance insurance = new Insurance();
		insurance.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
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
