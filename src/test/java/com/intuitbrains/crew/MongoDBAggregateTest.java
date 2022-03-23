package com.intuitbrains.crew;

import com.intuitbrains.common.Collection;
import com.intuitbrains.main.CrewManagementApplication;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
public class MongoDBAggregateTest {
    //https://github.com/mongodb-developer/java-quick-start/blob/master/src/main/java/com/mongodb/quickstart/AggregationFramework.java

    @Autowired
    private MongoDatabase db;

    @Test
    public void testAuditTrail() {
        MongoCollection<Document> audits = db.getCollection(Collection.AUDIT_TRAIL);
        getModifiedAuditTrailUptoLimit(audits, 4);
    }

    private static void getModifiedAuditTrailUptoLimit(MongoCollection<Document> audits, int limitCnt) {
        Bson match = match(eq("action", "modify"));
        //Bson group = group("$city", sum("totalPop", "$pop"));
        Bson project = project(fields(excludeId(), include("text", "actionLocalDateTime")));
        Bson sort = sort(descending("actionLocalDateTime"));
        Bson limit = limit(limitCnt);

        List<Document> results = audits.aggregate(Arrays.asList(match, project, sort, limit))
                .into(new ArrayList<>());
        System.out.println("==> 3 most densely populated cities in Texas");
        results.forEach(printDocuments());
    }

    @Test
    public void testCrewDocuments() {
        MongoCollection<Document> docs = db.getCollection(Collection.CREW_DOCUMENT);
        getAllPreJoiningDocs(docs);
        getAllSTCW(docs);
    }

    private static void getAllPreJoiningDocs(MongoCollection<Document> docs) {
        Bson match = match(and(eq("flagCode", "IN"), eq("isRequiredBeforeJoining", true)));
        //Bson group = group("$city", sum("totalPop", "$pop"));
        Bson project = project(fields(excludeId(), include("docName", "documentCategory.name")));
        Bson sort = sort(descending("actionLocalDateTime"));

        List<Document> results = docs.aggregate(Arrays.asList(match, project, sort))
                .into(new ArrayList<>());
        System.out.println("==> All Pre-Joining Indian Docs");
        results.forEach(printDocuments());
    }

    private static void getAllSTCW(MongoCollection<Document> docs) {
        Bson match = match(eq("docTypeId", 20));
        //Bson group = group("$city", sum("totalPop", "$pop"));
        Bson project = project(fields(excludeId(), include("docName", "documentCategory.name", "durationType")));
        Bson sort = sort(ascending("docName"));

        List<Document> results = docs.aggregate(Arrays.asList(match, project, sort))
                .into(new ArrayList<>());
        System.out.println("==> All Training Docs");
        results.forEach(printDocuments());
    }


    private static Consumer<Document> printDocuments() {
        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
    }
}
