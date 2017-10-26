package ie.woowoowoo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reg on 07/06/2017.
 */
public class HelloWorldFreeMarkerStyle {

    public static void main(String[] args) {
        Configuration configuration =
                new Configuration(new
                        Version(2, 3, 21));
        configuration.setClassForTemplateLoading(
                HelloWorldFreeMarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("fruitPicker.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, writer);

            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
