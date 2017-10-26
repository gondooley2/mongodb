package ie.woowoowoo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ie.woowoowoo.DataToConsole.print;

/**
 * Created by Reg on 07/06/2017.
 */
public class FinalExamQ3 {

    public static void main(String[] args) throws InterruptedException {

        MongoClient c =  new MongoClient();
        MongoDatabase db = c.getDatabase("enron");
        MongoCollection<Document> coll = db.getCollection("messages");

        String adding = "mrpotatohead@mongodb.com";

        Bson filter = Filters.eq("headers.Message-ID",
                "<8147308.1075851042335.JavaMail.evans@thyme>");
        Bson doc1 = Updates.addToSet("headers.To", adding);
        coll.updateOne(filter, doc1);

        MongoIterable<Document> docs = coll.find(filter);
        ArrayList<Object> docsList = docs.into(new ArrayList<>());
        System.out.println("Number of documents returned: "+ docsList.size());
        Document doc = docs.first();
        if (doc == null) {
            System.out.println("No documents found");
        } else {
            print(doc);
        }



    }


}


