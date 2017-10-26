package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class FinalExamQ4 {

    static MongoClient c =  new MongoClient();
    static MongoDatabase db = c.getDatabase("blog");
    static MongoCollection<Document> postsCollection = db.getCollection("posts");

    public static void main(String[] args) {
        String permalink = "mxwnnnqaflufnqwlekfd";
        int ordinal = 1;

        String commentKey = "comments." + String.valueOf(ordinal);
        Bson filter = eq("permalink", permalink);
        Bson update = Updates.inc(commentKey + ".num_likes", 1);
        postsCollection.updateOne(filter, update);
    }
}
