package ie.woowoowoo;

import com.mongodb.*;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Reg on 07/06/2017.
 */
public class SparkRoutes {

    static DBCollection collection;

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        /*DB database = mongoClient.getDB("test");
        collection = database.getCollection("restaurants");*/
        final DB database = mongoClient.getDB("video");
        collection = database.getCollection("movies");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return "Hello World\n";
            }
        });

        Spark.get("/collections", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return database.getCollectionNames();
            }
        });

        Spark.get("/get/:key/:value", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                DBCursor results = collection.find(new BasicDBObject(
                        request.params(":key"), request.params(":value")));
                StringBuilder sb = new StringBuilder("");
                for (DBObject result : results) {
                    sb.append(result.toString());
                }
                return sb;

            }
        });


    }
}
