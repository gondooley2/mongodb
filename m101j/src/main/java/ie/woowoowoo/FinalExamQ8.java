package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

public class FinalExamQ8 {

    static MongoClient c =  new MongoClient();
    static MongoDatabase db = c.getDatabase("test");
    static MongoCollection<Document> animals = db.getCollection("animals");

    public static void main(String[] args) {

        Document animal = new Document("animal", "monkey");

        animals.insertOne(animal);
        animal.remove("animal");
        animal.append("animal", "cat");
        animals.insertOne(animal);
        animal.remove("animal");
        animal.append("animal", "lion");
        animals.insertOne(animal);

    }
}
