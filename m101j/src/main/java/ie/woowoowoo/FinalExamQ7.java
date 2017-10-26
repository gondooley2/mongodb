package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class FinalExamQ7 {

    static MongoClient c =  new MongoClient();
    static MongoDatabase db = c.getDatabase("photos");
    static MongoCollection<Document> albumColl = db.getCollection("albums");
    static MongoCollection<Document> imageColl = db.getCollection("images");

    public static void main(String[] args) {

        System.out.println(imageColl.find(Filters.eq("tags", "sunrises")).into(new ArrayList<>()).size());
    }
}
