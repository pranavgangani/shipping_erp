package com.intuitbrains.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.crew.RankSubCategory;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.model.vessel.VesselType;
import com.intuitbrains.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class CrewDocumentTest {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;

    @Test
    void getPostJoiningDocs() {
        List<Document> list = documentDao.getPostJoiningDocsForAllVesselTypeAndAllRankCat();
        list.addAll(documentDao.getPostJoiningDocsForAllVesselTypeAndSpecificRank(Rank.CAPTAIN.getId()));

        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName()
                + " - " + doc.getDocTypeId() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));

    }

    @Test
    void getDocsByRating() {
        List<Document> list = documentDao.getPostJoiningDocsForAllVesselTypeAndAllSpecificSubCat(RankSubCategory.RATING.getId());

        list.forEach(doc -> System.out.println(doc.getId() + " - " + doc.getDocumentCategory().getName()
                + " - " + doc.getDocTypeId() + " - " + doc.getDocName() + " - " + doc.getClass().getName()));

    }


    @Test
    void getAllDocsWhenCrewJoiningAVessel() {
        Flag indFlag = flagDao.getByCode("IN");

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

        list.forEach(o -> {

        });
    }
}
