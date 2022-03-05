package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.FlagRepository;
import com.shipping.main.CrewManagementApplication;
import com.shipping.dao.common.CommonDocumentRepository;
import com.shipping.model.common.DurationType;
import com.shipping.model.common.document.*;
import com.shipping.model.common.document.category.Document;
import com.shipping.model.common.document.category.DocumentCategory;
import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCategory;
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
    private CommonDocumentRepository documentDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;

    @Test
    void addHazardousTrainingDoc() {
        Certificate trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
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
        Certificate trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
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
        Certificate trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
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
        Certificate trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocType("STCW 2010 Basic Safety Training");
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

        trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocType("STCW 2010 Basic Safety Training");
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

        trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocType("STCW 2010 Basic Safety Training");
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

        trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocType("STCW 2010 Basic Safety Training");
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

        trainingCert = new Certificate();
        trainingCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        trainingCert.setDocType("STCW 2010 Basic Safety Training");
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
        cdc.setValidity(10, DurationType.YEARS);
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
        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName() + " - " + doc.getClass().getName()));
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
                + " - " + doc.getDocType() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));


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
                + " - " + doc.getDocType() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));

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

}
