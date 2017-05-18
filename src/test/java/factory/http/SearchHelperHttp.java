package factory.http;

import factory.interfaces.SearchHelper;
import io.restassured.response.Response;
import utils.Parser;

import static factory.http.AppManagerHttp.ITEM_URL;
import static io.restassured.RestAssured.get;
import static tests.BaseTest.BASE_URL;

/**
 * Created by sirdir on 18.05.17.
 */
public class SearchHelperHttp implements SearchHelper {
    @Override
    public void searchById(Long id) {
        Response pageSource = get(BASE_URL + "/search/?text=" + id);
        ITEM_URL = Parser.rozetkaHiddenItem(pageSource.getBody().asString(), "$.productHref");
    }
}