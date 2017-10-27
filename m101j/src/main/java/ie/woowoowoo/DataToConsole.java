package ie.woowoowoo;

import org.bson.Document;

import java.util.List;
import java.util.Set;

class DataToConsole {

    static void print(Document doc) {
        print(doc, 0);
    }

    private static void print(Document doc, int depth) {
        Set<String> keys = doc.keySet();
        for (String key: keys) {
            Object value = doc.get(key);
            Class type = value.getClass();
            indent(depth);
            System.out.print(key + " => ");
            print(type, value, depth + 1);
        }
        indent(depth);
        System.out.println("= = = = = = = = = = = = = = = = = = = =");

    }

    private static void indent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
    }

    private static void print(Class type, Object item, int depth) {
        switch(type.toString()) {
            case "class java.util.ArrayList":
                System.out.println();
                print((List) item, depth);
                break;
            case "class org.bson.Document":
                print((Document)item, depth);
                break;
            default:
                System.out.println(item);
                indent(depth);
                System.out.println(type);
        }
    }

    private static void print(List list, int depth) {
        indent(depth);
        if (list.size() == 0) {
            System.out.println("<<Empty list>>");
            return;
        }
        System.out.println("List size: " + list.size());
        indent(depth);
        System.out.println("[");
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            Class type = item.getClass();
            print(type, item, depth + 1);
        }
        indent(depth);
        System.out.println("]");
    }

}
