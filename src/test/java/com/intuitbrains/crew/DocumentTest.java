package com.intuitbrains.crew;

import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.common.document.category.DocumentCategory;
import com.intuitbrains.model.common.document.category.DocumentPool;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.service.common.SequenceGeneratorService;
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
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;
/*
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
    }*/

  /*  @Test
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
    }*/

    @Test
    void addMoreSTCWTrainingDocs() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RFPNW");
        type.setName("Ratings Forming Part of a Navigational Watch");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RASD");
        type.setName("Ratings as Able Seafarer Deck");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RFPWMUER");
        type.setName("Ratings Forming Part of a Watch in a Manned Engine-room or designated to perform duties in a Periodically Unmanned Engine-room");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RASEMUER");
        type.setName("Ratings as Able Seafarer Engine in a Manned Engine-room or designated to perform duties in a Periodically Unmanned Engine-room");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("GOCGMDSS");
        type.setName("GOC for GMDSS");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("BTOCTCO");
        type.setName("Basic Training for Oil and Chemical Tanker Cargo Operations");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("ATOTCO");
        type.setName("Advance Training for Oil Tanker Cargo Operations");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("ATCTCO");
        type.setName("Advance Training for Chemical Tanker Cargo Operations");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("BTLGTCO");
        type.setName("Basic Training for Liquefied Gas Tanker Cargo Operations");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("ATLGTCO");
        type.setName("Advanced Training for Liquefied Gas Tanker Cargo Operations");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("STPPDSPPS");
        type.setName("Safety Training for Personnel Providing Direct Service to Passengers in Passenger Spaces");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCMT");
        type.setName("Passenger Ship Crowd Management Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCMHBT");
        type.setName("Passenger Ship Crisis Management and Human Behaviour Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCSHIT");
        type.setName("Passenger Safety, Cargo Safety and Hull Integrity Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCRBOFRB");
        type.setName("Proficiency in Survival Craft and Rescue Boats other than Fast Rescue Boats");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PFRB");
        type.setName("Proficiency in Fast Rescue Boats");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("AFF");
        type.setName("Advanced Fire Fighting");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("MFA");
        type.setName("Medical First Aid");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("MCARE");
        type.setName("Medical Care");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("SSO");
        type.setName("Ship Security Officers");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("SATSDD");
        type.setName("Security Awareness Training and Seafarers with Designated Duties");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RBT");
        type.setName("Refresher on Basic Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RPSCRB");
        type.setName("Refresher Training on PSCRB");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RPFRB");
        type.setName("Refresher Training on PFRB");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("RAFF");
        type.setName("Refresher on AFF");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCMT");
        type.setName("Passenger Ship Crowd Management Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCMHBT");
        type.setName("Passenger Ship Crisis Management and Human Behaviour Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSCSHIT");
        type.setName("Passenger Safety, Cargo Safety and Hull Integrity Training");
        docTypeDao.insert(type);
    }
    @Test
    void add5BasicSTCWTrainingDocs() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("EFA");
        type.setName("Elementary First Aid - STCW 2010 Basic Safety Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("FPFF");
        type.setName("Fire Prevention and Fire Fighting - STCW 2010 Basic Safety Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PST");
        type.setName("Personal Survival Techniques - STCW 2010 Basic Safety Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSSR");
        type.setName("Personal Safety and Social Responsibility - STCW 2010 Basic Safety Training");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("PSA");
        type.setName("Proficiency in Security Awareness - STCW 2010 Basic Safety Training");
        docTypeDao.insert(type);
    }

    @Test
    void addOtherTrainingDocs() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("ROSC");
        type.setName("Radar Observer Course");
        docTypeDao.insert(type);

         type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("ARPA");
        type.setName("Automatic Radar Plotting Aids");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("GMDSS");
        type.setName("Global Maritime Distress and Safety System");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("AFFR");
        type.setName("Refresher Training For Advance Fire Fighting");
        docTypeDao.insert(type);


    }
   /* @Test
    void add5BasicSTCWTrainingDocsForAnyCrew() {

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
    }*/


    @Test
    void addDocsRequiredForIndianCrew() {
     /*   Document passport = new Passport();
        passport.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        passport.setDocumentCategory(DocumentCategory.TRAVEL);
        DocumentType dt = docTypeDao.findByName("Indian Passport");
        passport.setDocTypeId(dt.getId());
        passport.setDocName(dt.getName());
        passport.setFlagCode(dt.getFlagCode());
        passport.setValidity(10, DurationType.YEARS);
        passport.setRequiredBeforeJoining(true);
        passport.setRequiredAfterJoining(true);
        documentDao.insert(passport);

        Document usB1B2 = new Visa();
        usB1B2.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        usB1B2.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("US B1/B2");
        usB1B2.setDocTypeId(dt.getId());
        usB1B2.setDocName(dt.getName());
        usB1B2.setFlagCode(dt.getFlagCode());
        usB1B2.setValidity(10, DurationType.YEARS);
        usB1B2.setRequiredBeforeJoining(true);
        usB1B2.setRequiredAfterJoining(true);
        documentDao.insert(usB1B2);

        Document usC1D = new Visa();
        usC1D.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        usC1D.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("US C1/D");
        usC1D.setDocTypeId(dt.getId());
        usC1D.setDocName(dt.getName());
        usC1D.setFlagCode(dt.getFlagCode());
        usC1D.setValidity(10, DurationType.YEARS);
        usC1D.setRequiredBeforeJoining(true);
        usC1D.setRequiredAfterJoining(true);
        documentDao.insert(usC1D);

        Document ausMCV = new Visa();
        ausMCV.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        ausMCV.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("Australian MCV");
        ausMCV.setDocTypeId(dt.getId());
        ausMCV.setDocName(dt.getName());
        ausMCV.setFlagCode(dt.getFlagCode());
        ausMCV.setValidity(10, DurationType.YEARS);
        ausMCV.setRequiredBeforeJoining(true);
        ausMCV.setRequiredAfterJoining(true);
        documentDao.insert(ausMCV);

        Document aadharCard = new NationalID();
        aadharCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        aadharCard.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        dt = docTypeDao.findByName("Aadhar Card");
        aadharCard.setDocTypeId(dt.getId());
        aadharCard.setDocName(dt.getName());
        aadharCard.setFlagCode(dt.getFlagCode());
        aadharCard.setRequiredBeforeJoining(true);
        documentDao.insert(aadharCard);

        Document indLicense = new License();
        indLicense.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        indLicense.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("Indian License");
        indLicense.setDocTypeId(dt.getId());
        indLicense.setDocName(dt.getName());
        indLicense.setFlagCode(dt.getFlagCode());
        indLicense.setValidity(5, DurationType.YEARS);
        indLicense.setRequiredBeforeJoining(true);
        indLicense.setRequiredAfterJoining(true);
        indLicense.setRequiredOnBoard(true);
        documentDao.insert(indLicense);

        Document libLicense = new License();
        libLicense.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        libLicense.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("Liberian License");
        libLicense.setDocTypeId(dt.getId());
        libLicense.setDocName(dt.getName());
        libLicense.setFlagCode(dt.getFlagCode());
        libLicense.setValidity(5, DurationType.YEARS);
        libLicense.setRequiredBeforeJoining(true);
        libLicense.setRequiredAfterJoining(true);
        libLicense.setRequiredOnBoard(true);
        documentDao.insert(libLicense);

        Document panaLicense = new License();
        panaLicense.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        panaLicense.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("Panama License");
        panaLicense.setDocTypeId(dt.getId());
        panaLicense.setDocName(dt.getName());
        panaLicense.setFlagCode(dt.getFlagCode());
        panaLicense.setValidity(5, DurationType.YEARS);
        panaLicense.setRequiredBeforeJoining(true);
        panaLicense.setRequiredAfterJoining(true);
        panaLicense.setRequiredOnBoard(true);
        documentDao.insert(panaLicense);

        Document ukLicense = new License();
        ukLicense.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        ukLicense.setDocumentCategory(DocumentCategory.TRAVEL);
        dt = docTypeDao.findByName("Panama License");
        ukLicense.setDocTypeId(dt.getId());
        ukLicense.setDocName(dt.getName());
        ukLicense.setFlagCode(dt.getFlagCode());
        ukLicense.setValidity(5, DurationType.YEARS);
        ukLicense.setRequiredBeforeJoining(true);
        ukLicense.setRequiredAfterJoining(true);
        ukLicense.setRequiredOnBoard(true);
        documentDao.insert(ukLicense);


        Document panCard = new TaxID();
        panCard.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        panCard.setDocumentCategory(DocumentCategory.FINANCIAL);
        dt = docTypeDao.findByName("PAN");
        panCard.setDocTypeId(dt.getId());
        panCard.setDocName(dt.getName());
        panCard.setFlagCode(dt.getFlagCode());
        panCard.setRequiredBeforeJoining(true);
        documentDao.insert(panCard);

        Document cdc = new NationalID();
        cdc.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        cdc.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        dt = docTypeDao.findByName("Indian CDC");
        cdc.setDocTypeId(dt.getId());
        cdc.setDocName(dt.getName());
        cdc.setFlagCode(dt.getFlagCode());
        cdc.setValidity(10, DurationType.YEARS);
        cdc.setRequiredBeforeJoining(true);
        cdc.setRequiredAfterJoining(true);
        documentDao.insert(cdc);

        Document indos = new NationalID();
        indos.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        indos.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        dt = docTypeDao.findByName("INDOS");
        indos.setDocTypeId(dt.getId());
        indos.setDocName(dt.getName());
        indos.setFlagCode(dt.getFlagCode());
        indos.setValidity(5, DurationType.YEARS);
        indos.setRequiredBeforeJoining(true);
        indos.setRequiredAfterJoining(true);
        documentDao.insert(indos);

        Document yellowFeverCert = new Certificate();
        yellowFeverCert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        yellowFeverCert.setDocumentCategory(DocumentCategory.MEDICAL);
        dt = docTypeDao.findByName("Yellow Fever");
        yellowFeverCert.setDocTypeId(dt.getId());
        yellowFeverCert.setDocName(dt.getName());
        yellowFeverCert.setFlagCode(dt.getFlagCode());
        indos.setValidity(5, DurationType.YEARS);
        yellowFeverCert.setRequiredBeforeJoining(true);
        yellowFeverCert.setRequiredAfterJoining(true);
        documentDao.insert(yellowFeverCert);*/

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
/*
        List<Document> list = documentDao.findAll();
        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName() + " - " + doc.getClass().getName()));*/
    }

/*
    void addVisas() {
        Flag usa = flagDao.getByCode("US");
        Document usVisa = new Visa();
        usVisa.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
        usVisa.setDocumentCategory(DocumentCategory.TRAVEL);
        usVisa.setDocName("US Visa");
        //usVisa.setDocType("B1/B2");
        usVisa.setFlagCode(usa.getCode());
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

        insurance.setFlagCode(flagDao.getByCode("IN").getCode());
        documentDao.insert(insurance);

        System.out.println("Id:" + insurance.getId());

        //System.out.println(persistedInsurance.getInsuranceCompanyName());

    }
*/

    @Test
    void documentGet() {
        List<CrewDocument> list = documentDao.findAll();
        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocType().getDocumentCategory().getName() + " - " + doc.getClass().getName()));

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
    void addSTCW() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("STCW 2010");
        type.setName("STCW 2010 Basic Safety Training");
        type.setDesc("International Convention on Standards of Training, Certification and Watchkeeping for Seafarers (STCW), 1978 sets minimum qualification standards for masters, officers and watch personnel on seagoing merchant ships and large yachts.");
        docTypeDao.insert(type);

    }

    @Test
    void addAllValidDocTypes() {
        DocumentType type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.PASSPORT);
        type.setName("Indian Passport");
         type.setShortName("INDPP");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CDC);
        type.setName("Indian CDC");
        type.setShortName("INDCDC");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        type.setDesc("A Continuous Certificate of Discharge or Continuous Discharge Certificate (C.D.C.) is a seafarer's identity document issued by his country. This document certifies that the person holding this is a seaman as per The International Convention on Standards of Training, Certification and Watch keeping for Seafarers (STCW), 1978, as amended 2010. Every seafarer must carry this document while on board, which is also an official and legal record of his sea experience. The master of the vessel signs the document each time a seaman is signed off from the vessel certifying his experience on board.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CDC);
        type.setName("Liberian CDC");
        type.setShortName("LIBCDC");
        type.setFlagCode(flagDao.getByCode("LR").getCode());
        type.setDesc("A Continuous Certificate of Discharge or Continuous Discharge Certificate (C.D.C.) is a seafarer's identity document issued by his country. This document certifies that the person holding this is a seaman as per The International Convention on Standards of Training, Certification and Watch keeping for Seafarers (STCW), 1978, as amended 2010. Every seafarer must carry this document while on board, which is also an official and legal record of his sea experience. The master of the vessel signs the document each time a seaman is signed off from the vessel certifying his experience on board.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CDC);
        type.setName("Panama CDC");
        type.setShortName("PANCDC");
        type.setFlagCode(flagDao.getByCode("PA").getCode());
        type.setDesc("A Continuous Certificate of Discharge or Continuous Discharge Certificate (C.D.C.) is a seafarer's identity document issued by his country. This document certifies that the person holding this is a seaman as per The International Convention on Standards of Training, Certification and Watch keeping for Seafarers (STCW), 1978, as amended 2010. Every seafarer must carry this document while on board, which is also an official and legal record of his sea experience. The master of the vessel signs the document each time a seaman is signed off from the vessel certifying his experience on board.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.CDC);
        type.setShortName("OTHCDC");
        type.setName("Other CDC");
        //type.setFlagCode(flagDao.getByCode("PA").getCode());
        type.setDesc("A Continuous Certificate of Discharge or Continuous Discharge Certificate (C.D.C.) is a seafarer's identity document issued by his country. This document certifies that the person holding this is a seaman as per The International Convention on Standards of Training, Certification and Watch keeping for Seafarers (STCW), 1978, as amended 2010. Every seafarer must carry this document while on board, which is also an official and legal record of his sea experience. The master of the vessel signs the document each time a seaman is signed off from the vessel certifying his experience on board.");
        docTypeDao.insert(type);


        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.COE);
        type.setShortName("CoE");
        type.setName("Certificate of Endorsement");
        type.setDesc("Requirements for a Flag State Endorsement by the Palau International Ship Registry (PISR) in accordance with the provisions of the International Convention on Standards of Training, Certification and Watch-keeping for Seafarers, (STCW) 1978 as amended.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.COC);
        type.setShortName("CoC");
        type.setName("Certificate of Competency");
        type.setDesc("Each candidate for an officer certificate who qualifies under the provisions of STCW and successfully completes the appropriate examination will be issued a Certificate of Competency. This certificate states that the officer has been found duly qualified in accordance with the provisions of STCW and in the format prescribed by STCW for those officers qualified to receive STCW certificates.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.COP);
        type.setShortName("CoP");
        type.setName("Certificate of Proficiency");
        type.setDesc("This certificate states that the officer or the Rating has been found duly qualified in accordance with the provisions of STCW and in the format prescribed by STCW for those qualified to receive STCW certificates.");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.SIRB);
        type.setShortName("SIRB");
        type.setName("Seafarer Identification Record Book");
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.INDOS);
        type.setShortName("INDOS");
        type.setName("Indian National Database Of Seafarers");
        type.setDesc("INDoS is a computerised national database of Indian seafarers for use by statutory authorities such as Flag State, Port State, Immigration & Employers etc., to prevent the fraudulent issue of certificates.");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.EDUCATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("SSC");
        type.setName("Secondary School Certificate");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.EDUCATION);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("HSC");
        type.setName("Higher Secondary Certificate");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.PAN);
        type.setShortName("PAN");
        type.setName("Pan Card");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.IDENTIFICATION);
        type.setDocumentPool(DocumentPool.AADHAR);
        type.setShortName("Aadhar");
        type.setName("Aadhar Card");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.MEDICAL);
        type.setDocumentPool(DocumentPool.YELLOW_FEVER);
        type.setShortName("YELFVR");
        type.setName("Yellow Fever");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setShortName("USB1B2");
        type.setName("US B1/B2");
        type.setFlagCode(flagDao.getByCode("US").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setName("US C1/D");
        type.setShortName("USC1D");
        type.setFlagCode(flagDao.getByCode("US").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.VISA);
        type.setShortName("AUSMCV");
        type.setName("Australian MCV");
        type.setFlagCode(flagDao.getByCode("AU").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Indian License");
        type.setShortName("INDLIC");
        type.setFlagCode(flagDao.getByCode("IN").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Liberian License");
        type.setShortName("LIBLIC");
        type.setFlagCode(flagDao.getByCode("LR").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("UK License");
        type.setShortName("UKLIC");
        type.setFlagCode(flagDao.getByCode("GB").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setName("Panama License");
        type.setShortName("PANLIC");
        type.setFlagCode(flagDao.getByCode("PA").getCode());
        docTypeDao.insert(type);

        type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAVEL);
        type.setDocumentPool(DocumentPool.LICENSE);
        type.setShortName("SINGLIC");
        type.setName("Singapore License");
        type.setFlagCode(flagDao.getByCode("SG").getCode());
        docTypeDao.insert(type);

      /*  type = new DocumentType();
        type.setId(sequenceGenerator.generateSequence(DocumentType.SEQUENCE_NAME));
        type.setDocumentCategory(DocumentCategory.TRAINING);
        type.setDocumentPool(DocumentPool.CERTIFICATE);
        type.setShortName("STCW 2010");
        type.setName("STCW 2010 Basic Safety Training");
        type.setDesc("International Convention on Standards of Training, Certification and Watchkeeping for Seafarers (STCW), 1978 sets minimum qualification standards for masters, officers and watch personnel on seagoing merchant ships and large yachts.");
        docTypeDao.insert(type);*/
    }

    @Test
    void getALlDocTypes() {
        docTypeDao.findAll().forEach(dt->System.out.println(dt.getName() + " ("+dt.getShortName()+")"));
    }

    @Test
    void getFlags() {
        flagDao.findAll().forEach(f->System.out.println(f.getName() + " ("+f.getCode()+")"));
    }

}
