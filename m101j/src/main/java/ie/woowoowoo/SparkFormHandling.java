package ie.woowoowoo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by Reg on 07/06/2017.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        // Configure Freemarker
        Version v = new Version(2, 3, 21);
        final Configuration configuration = new Configuration(v);
        configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");

        //Configure Routes
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                try {
                    Map<String, Object> fruitsMap = new HashMap<String, Object>();
                    fruitsMap.put("fruits",
                            Arrays.asList("apple", "orange", "banana", "peach"));

                    Template fruitPickerTemplate =
                            configuration.getTemplate("fruitPicker.ftl");
                    StringWriter writer = new StringWriter();
                    fruitPickerTemplate.process(fruitsMap, writer);
                    return writer;
                } catch (Exception e) {
                    halt(500);
                    return null;
                }
            }
        });

        Spark.post("/favourite_fruit", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                final String fruit = request.queryParams("fruit");
                if (fruit == null) {
                    return "Why don't you pick one?";
                }
                else {
                    return "Your favourite fruit is " + fruit;
                }
            }
        });
    }
}
