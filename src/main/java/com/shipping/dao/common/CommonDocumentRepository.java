package com.shipping.dao.common;

import com.shipping.model.common.document.category.Document;
import com.shipping.model.vessel.VesselVacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommonDocumentRepository extends MongoRepository<Document, Long> {
   /* @Query("{'vacancyAttributes.minRankList': { $eq: 1 }}")
    public List<VesselVacancy> findVacanciesByRank(int rankId);

    @Query("{'vacancyAttributes.minRankList': { $in: [?0] }}")
    public List<VesselVacancy> findVacanciesByRanks(List<Integer> rankIds);*/

   /* @Query("{$and :[{'forVesselTypes': { $in: [?0]}},{'forVesselSubTypes': {$gt>?1}}] }")
    public List<Document> getPostJoiningDocs(int vesselTypeId, int vesselSubTypeId,
                                             int rankCatId, int rankSubCatId, int rankId);*/

    @Query("{$or:[\n" +
            "        {$and:[ \n" +
            "            {'forVesselTypes': { $eq: 0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: 0 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]\n" +
            "\t\t},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: 0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: 0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "\t\t{$and:[\n" +
            "            {'forVesselTypes': { $eq: 0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: ?4 }}]}\n" +
            "    ]\n" +
            "}")
    public List<Document> getPostJoiningDocs1(int vesselTypeId, int vesselSubTypeId, int rankCatId, int rankSubCatId, int rankId);

    @Query("{$or:[\n" +
            "        {$and:[ \n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: 0 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]\n" +
            "\t\t},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "\t\t{$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: 0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: ?4 }}]}\n" +
            "    ]\n" +
            "}")
    public List<Document> getPostJoiningDocs2(int vesselTypeId, int vesselSubTypeId, int rankCatId, int rankSubCatId, int rankId);

    @Query("{$or:[\n" +
            "        {$and:[ \n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: ?1 }}, \n" +
            "            {'forRankCategories': { $eq: 0 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]\n" +
            "\t\t},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: ?1 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: 0 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "        {$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: ?0 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: 0 }}]},\n" +
            "\t\t{$and:[\n" +
            "            {'forVesselTypes': { $eq: ?0 }}, \n" +
            "            {'forVesselSubTypes': { $eq: ?1 }}, \n" +
            "            {'forRankCategories': { $eq: ?2 }}, \n" +
            "            {'forRankSubCategories': { $eq: ?3 }}, \n" +
            "            {'forRanks': { $eq: ?4 }}]}\n" +
            "    ]\n" +
            "}")
    public List<Document> getPostJoiningDocs3(int vesselTypeId, int vesselSubTypeId, int rankCatId, int rankSubCatId, int rankId);

    @Query("{$and :[{'forVesselTypes': { $eq: 0 }},{'forRankCategories': { $eq: 0 }}] }")
    public List<Document> getPostJoiningDocsForAllVesselTypeAndAllRankCat();

    @Query("{$and :[{'forVesselTypes': { $eq: 0 }},{'forRankCategories': { $eq: ?0 }}] }, {'forRankSubCategories': { $eq: 0 }}, {'forRanks': { $eq: 0 }}")
    public List<Document> getPostJoiningDocsForAllVesselTypeAndAllSpecificDept(int rankCatId);

    @Query("{$and :[{'forVesselTypes': { $eq: 0 }},{'forRankCategories': { $eq: 0 }}] }, {'forRankSubCategories': { $eq: 0 }}, {'forRanks': { $eq: ?0 }}")
    public List<Document> getPostJoiningDocsForAllVesselTypeAndSpecificRank(int rankId);

    @Query("{$and :[{'forVesselTypes': { $eq: 0 }},{'forRankCategories': { $eq: 0 }}] }, {'forRankSubCategories': { $eq: 0 }}, {'forRanks': { $eq: ?0 }}")
    public List<Document> getPostJoiningDocsForAllVesselTypeAndSpecificDepartment(int rankId);
}
