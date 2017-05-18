package utils;

import com.jayway.jsonpath.JsonPath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sirdir on 18.05.17.
 */
public class Parser {

    private static final String ROZETKA_ITEM_REGEXP = "<script>dataLayer\\.push\\(.{1,}\\);<\\/script>";

    public static <T> T rozetkaHiddenItem(String str, String jsonPath){
        Pattern pattern = Pattern.compile(ROZETKA_ITEM_REGEXP);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            String match = matcher.group(0);
            String json = match.substring(23, match.length()-11);
            return JsonPath.read(json, jsonPath);
        }
        return null;
    }
}