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
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
public class MongoDBAggregateTest {
    @Autowired
    private MongoDatabase db;

    @Test
    public void test() {
        MongoCollection<Document> audits = db.getCollection(Collection.AUDIT_TRAIL);
        threeMostPopulatedCitiesInTexas(audits);
    }

    private static void threeMostPopulatedCitiesInTexas(MongoCollection<Document> audits) {
        Bson match = match(eq("action", "modify"));
        //Bson group = group("$city", sum("totalPop", "$pop"));
        Bson project = project(fields(excludeId(), include("text")));
        Bson sort = sort(descending("actionDateTime"));
        Bson limit = limit(3);

        List<Document> results = audits.aggregate(Arrays.asList(match, project, sort, limit))
                .into(new ArrayList<>());
        System.out.println("==> 3 most densely populated cities in Texas");
        results.forEach(printDocuments());
    }


    private static Consumer<Document> printDocuments() {
        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
    }
}
