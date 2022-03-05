package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.DocumentTypeRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.dao.common.CrewDocumentRepository;
import com.shipping.model.common.DurationType;
import com.shipping.model.common.document.*;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.DocumentCategory;
import com.shipping.model.common.document.category.DocumentPool;
import com.shipping.model.common.document.category.DocumentType;
import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCategory;
import com.shipping.model.crew.RankSubCategory;
import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselType;
import com.shipping.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class DocumentTest {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;

    @Test
    void addSTCWDocsFromAnnex() {
        MerchantNavyCertificate trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Ratings Forming Part of a Navigational Watch");
        trainingCert.setRegulation("Regulation II/4");
        trainingCert.setSectionTable("Section A-II/4, Table A-11/4");
        trainingCert.setTrainingHours(40);
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankSubCategory.RATING.getId())));
        trainingCert.setForRanks(Rank.getIdsBySubCategory(RankSubCategory.RATING));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(5, DurationType.YEARS);
        documentDao.insert(trainingCert);
    }

    @Test
    void addHazardousTrainingDoc() {
        MerchantNavyCertificate trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Hazardous Material Handling");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.TANKER.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(
                VesselSubType.OIL_PROD_TANKER.getId(), VesselSubType.LPG_TANKER.getId(),
                VesselSubType.LNG_TANKER.getId(), VesselSubType.FSO_TANKER.getId()
        )));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);
    }

    @Test
    void addCaptainSpecificDoc() {
        MerchantNavyCertificate trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Some Captain Training Course");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(
                VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.CAPTAIN.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(5, DurationType.YEARS);
        documentDao.insert(trainingCert);
    }

    @Test
    void addFireTrainingDoc() {
        MerchantNavyCertificate trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Fire Handling Training");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);
    }

    @Test
    void addBasicSTCWTrainingDocs() {
        MerchantNavyCertificate trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Elementary First Aid (EFA)");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);

        trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Fire Prevention and Fire Fighting (FPFF)");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);

        trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Personal Survival Techniques (PST)");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);

        trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Personal Safety and Social Responsibility (PSSR)");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);

        trainingCert = new MerchantNavyCertificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocTypeId(docTypeDao.findByName("STCW 2010 Basic Safety Training").getId());
        trainingCert.setDocName("Proficiency in Security Awareness (PSA)");
        trainingCert.setDocumentCategory(DocumentCategory.TRAINING);
        trainingCert.setForVesselTypes(new ArrayList<>(Arrays.asList(VesselType.ALL.getId())));
        trainingCert.setForVesselSubTypes(new ArrayList<>(Arrays.asList(VesselSubType.ALL.getId())));
        trainingCert.setForRankCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRankSubCategories(new ArrayList<>(Arrays.asList(RankCategory.ALL.getId())));
        trainingCert.setForRanks(new ArrayList<>(Arrays.asList(Rank.ALL.getId())));
        trainingCert.setMandatory(true);
        trainingCert.setRequiredBeforeJoining(true);//Mandatory only if joining this Type of Vessle
        trainingCert.setValidity(2, DurationType.YEARS);
        documentDao.insert(trainingCert);
    }


    @Test
    void addIndianDocs() {
        Flag flag = flagDao.getByCode("IN");

        Document passport = new Passport();
        passport.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        passport.setDocumentCategory(DocumentCategory.TRAVEL);
        passport.setDocTypeId(docTypeDao.findByName("Indian Passport").getId());
        passport.setFlag(flag);
        passport.setRequiredBeforeJoining(true);
        passport.setRequiredAfterJoining(true);
        documentDao.insert(passport);

        Document aadharCard = new NationalID();
        aadharCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        aadharCard.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        aadharCard.setDocTypeId(docTypeDao.findByName("Aadhar Card").getId());
        aadharCard.setFlag(flag);
        aadharCard.setRequiredBeforeJoining(true);
        documentDao.insert(aadharCard);

        Document panCard = new TaxID();
        panCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        panCard.setDocumentCategory(DocumentCategory.FINANCIAL);
        panCard.setDocTypeId(docTypeDao.findByName("Pan Card").getId());
        panCard.setFlag(flag);
        panCard.setRequiredBeforeJoining(true);
        documentDao.insert(panCard);

        Document cdc = new NationalID();
        cdc.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        cdc.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        cdc.setDocTypeId(docTypeDao.findByName("Indian CDC").getId());
        cdc.setDocName("Indian Continuous Discharge Certificate");
        cdc.setFlag(flag);
        cdc.setValidity(10, DurationType.YEARS);
        cdc.setRequiredBeforeJoining(true);
        cdc.setRequiredAfterJoining(true);
        documentDao.insert(cdc);

        Document indos = new NationalID();
        indos.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        indos.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        indos.setDocTypeId(docTypeDao.findByName("INDOS").getId());
        indos.setDocName("Indian INDOS");
        indos.setFlag(flag);
        indos.setRequiredBeforeJoining(true);
        indos.setRequiredAfterJoining(true);
        documentDao.insert(indos);

        Document yellowFeverCert = new Certificate();
        yellowFeverCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        yellowFeverCert.setDocumentCategory(DocumentCategory.MEDICAL);
        yellowFeverCert.setDocTypeId(docTypeDao.findByName("Yellow Fever").getId());
        yellowFeverCert.setDocName("Yellow Fever");
        yellowFeverCert.setFlag(flag);
        yellowFeverCert.setRequiredBeforeJoining(true);
        yellowFeverCert.setRequiredAfterJoining(true);
        documentDao.insert(yellowFeverCert);

      /*  Document drugAlcoholCert = new Certificate();
        drugAlcoholCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        drugAlcoholCert.setDocumentCategory(DocumentCategory.MEDICAL);
        drugAlcoholCert.setDocName("Drug & Alcohol Certificate");
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
        documentDao.insert(form3A);*/

        List<Document> list = documentDao.findAll();
        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName() + " - " + doc.getClass().getName()));
    }

    void addVisas() {
        Flag usa = flagDao.getByCode("US");
        Document usVisa = new Visa();
        usVisa.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        usVisa.setDocumentCategory(DocumentCategory.TRAVEL);
        usVisa.setDocName("US Visa");
        //usVisa.setDocType("B1/B2");
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

        System.out.println("Id:" + insurance.getId());

        //System.out.println(persistedInsurance.getInsuranceCompanyName());

    }

    @Test
    void documentGet() {
        List<Document> list = documentDao.findAll();
        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName() + " - " + doc.getClass().getName()));

        list.forEach(o -> {
            System.out.println(o.getClass().getName());
            if (o.getClass().equals(Insurance.class)) {
                Insurance insurance = (Insurance) o;
                System.out.println(insurance.getInsuranceCompanyName());
            } else if (o.getClass().equals(Passport.class)) {
                Passport passport = (Passport) o;
                System.out.println(passport.getGivenName());
            }
        });
        //Document persistedInsurance = (documentDao.findById(insurance.getId()).isPresent())?documentDao.findById(insurance.getId()).get():null;
        //Assert.assertNotNull(persistedInsurance);
    }


    @Test
    void getPostJoiningDocs() {
        List<Document> list = documentDao.getPostJoiningDocsForAllVesselTypeAndAllRankCat();
        list.addAll(documentDao.getPostJoiningDocsForAllVesselTypeAndSpecificRank(Rank.CAPTAIN.getId()));

        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName()
                + " - " + doc.getDocTypeId() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));


        //Document persistedInsurance = (documentDao.findById(insurance.getId()).isPresent())?documentDao.findById(insurance.getId()).get():null;
        //Assert.assertNotNull(persistedInsurance);
    }

    @Test
    void getDocsByRating() {
        List<Document> list = documentDao.getPostJoiningDocsForAllVesselTypeAndAllSpecificSubCat(RankSubCategory.RATING.getId());

        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName()
                + " - " + doc.getDocTypeId() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));


        //Document persistedInsurance = (documentDao.findById(insurance.getId()).isPresent())?documentDao.findById(insurance.getId()).get():null;
        //Assert.assertNotNull(persistedInsurance);
    }


    @Test
    void getAllDocsWhenCrewJoiningAVessel() {
        //Vessel
        int vesselTypeId = VesselType.TANKER.getId();
        int vesselSubTypeId = VesselSubType.LNG_TANKER.getId();

        //Rank Details
        Rank rank = Rank.CAPTAIN;
        int rankCatId = rank.getRankCategory().getId();
        int rankSubCatId = rank.getRankSubCategory().getId();

        List<Document> list = new ArrayList<>();
        list.addAll(documentDao.getPostJoiningDocs1(vesselTypeId,
                vesselSubTypeId, rankCatId, rankSubCatId, rank.getId()));

        list.addAll(documentDao.getPostJoiningDocs2(vesselTypeId,
                vesselSubTypeId, rankCatId, rankSubCatId, rank.getId()));

        list.addAll(documentDao.getPostJoiningDocs3(vesselTypeId,
                vesselSubTypeId, rankCatId, rankSubCatId, rank.getId()));

        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName()
                + " - " + doc.getDocTypeId() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));

        /*list.forEach(o -> {
            System.out.println(o.getClass().getName());
            if (o.getClass().equals(Insurance.class)) {
                Insurance insurance = (Insurance) o;
                System.out.println(insurance.getInsuranceCompanyName());
            } else if (o.getClass().equals(Passport.class)) {
                Passport passport = (Passport) o;
                System.out.println(passport.getGivenName());
            }
        });*/
    }

    @Test
    void addIndianPassport() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.PASSPORT);
        type.setName("Indian Passport");
        docTypeDao.insert(type);
    }


    @Test
    void addCertificateTypes() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Certificate of Endorsement (CoE)");
        type.setDesc("Requirements for a Flag State Endorsement by the Palau International Ship Registry (PISR) in accordance with the provisions of the International Convention on Standards of Training, Certification and Watch-keeping for Seafarers, (STCW) 1978 as amended.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Certificate of Competency (CoC)");
        type.setDesc("Each candidate for an officer certificate who qualifies under the provisions of STCW and successfully completes the appropriate examination will be issued a Certificate of Competency. This certificate states that the officer has been found duly qualified in accordance with the provisions of STCW and in the format prescribed by STCW for those officers qualified to receive STCW certificates.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Cerificate of Proficiency (COP)");
        type.setDesc("This certificate states that the officer or the Rating has been found duly qualified in accordance with the provisions of STCW and in the format prescribed by STCW for those qualified to receive STCW certificates.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Seafarer Identification Record Book (SIRB)");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("INDOS");
        type.setDesc("INDoS (Indian National Database Of Seafarers) is a computerised national database of Indian seafarers for use by statutory authorities such as Flag State, Port State, Immigration & Employers etc., to prevent the fraudulent issue of certificates.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.EDUCATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("SSC");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.EDUCATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("HSC");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.TAX_ID);
        type.setName("Pan Card");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.NATIONAL_ID);
        type.setName("Aadhar Card");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.MEDICAL);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Yellow Fever");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setName("US B1/B2");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setName("US C1/D");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setName("Australian MCV");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Indian");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Liberian");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("UK");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Panama");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Liberian");
        docTypeDao.insert(type);
    }

    @Test
    void addSTCW() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("STCW 2010 Basic Safety Training");
        type.setDesc("International Convention on Standards of Training, Certification and Watchkeeping for Seafarers (STCW), 1978 sets minimum qualification standards for masters, officers and watch personnel on seagoing merchant ships and large yachts.");
        docTypeDao.insert(type);

    }
    @Test
    void addIndianCDC() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setName("Indian CDC");
        type.setDesc("A Continuous Certificate of Discharge or Continuous Discharge Certificate (C.D.C.) is a seafarer's identity document issued by his country. This document certifies that the person holding this is a seaman as per The International Convention on Standards of Training, Certification and Watch keeping for Seafarers (STCW), 1978, as amended 2010. Every seafarer must carry this document while on board, which is also an official and legal record of his sea experience. The master of the vessel signs the document each time a seaman is signed off from the vessel certifying his experience on board.");
        docTypeDao.insert(type);

    }
}
