package utils;

import com.jayway.jsonpath.JsonPath;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by sirdir on 18.05.17.
 */
public class Parser {

    public static <T> T rozetkaHiddenItem(String str, String jsonPath){
        Document doc = Jsoup.parse(str);
        for (Element el : doc.head().getElementsByTag("script")) {
            String data = el.data();
            if (data.startsWith("dataLayer.push(")){
                String json = data.substring(15, data.length()-2);
                return JsonPath.read(json, jsonPath);
            }
        }
        return null;
    }
}