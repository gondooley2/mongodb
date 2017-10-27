package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static ie.woowoowoo.DataToConsole.print;

public class MongoAnalyser {
    private static MongoClient c =  new MongoClient();
    private static MongoDatabase db = c.getDatabase("oireachtas");
    private static MongoCollection<Document> coll = db.getCollection("law2016_4");

    public static void main(String[] args) {
        FindIterable<Document> docs = coll.find();
        for (Document doc: docs) {
            print(doc);
            System.out.println("--------------------------------------------------------");
        }
    }

}
