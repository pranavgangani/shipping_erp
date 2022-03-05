package com.shipping.crew;

import com.shipping.common.Flag;
import com.shipping.dao.common.CrewDocumentRepository;
import com.shipping.dao.common.DocumentTypeRepository;
import com.shipping.dao.common.FlagRepository;
import com.shipping.main.CrewManagementApplication;
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
