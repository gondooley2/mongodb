package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.eq;

public class FinalExamQ5 {

    static MongoClient c =  new MongoClient();
    static MongoDatabase db = c.getDatabase("q5");
    static MongoCollection<Document> postsCollection = db.getCollection("docs");

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Document doc = new Document("a", i)
                    .append("b", i * 1000)
                    .append("c", i* 1000000);
            postsCollection.insertOne(doc);
        }

    }
}
