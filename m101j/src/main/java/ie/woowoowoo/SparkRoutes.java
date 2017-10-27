package ie.woowoowoo;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Reg on 07/06/2017.
 */
public class SparkRoutes {

    private static MongoCollection collection;

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        final MongoDatabase database = mongoClient.getDatabase("video");
        collection = database.getCollection("movies");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return "Hello World\n";
            }
        });

        Spark.get("/collections", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return database.listCollectionNames();
            }
        });

        Spark.get("/get/:key/:value", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                FindIterable results = collection.find(new BasicDBObject(
                        request.params(":key"), request.params(":value")));
                StringBuilder sb = new StringBuilder("");
                for (Object result : results) {
                    sb.append(result.toString());
                }
                return sb;

            }
        });


    }
}
