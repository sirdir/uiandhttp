package factory.http;

import com.jayway.jsonpath.JsonPath;
import factory.interfaces.ItemHelper;

import io.restassured.response.Response;
import utils.Parser;

import static factory.http.AppManagerHttp.ITEM_URL;
import static io.restassured.RestAssured.get;
import static tests.BaseTest.BASE_URL;

/**
 * Created by sirdir on 18.05.17.
 */
public class ItemHelperHttp implements ItemHelper {

    @Override
    public String getUsdPrice() {
        Response pageSource = get(ITEM_URL);
        return Parser.rozetkaHiddenItem(pageSource.getBody().asString(), "$.productPriceLocal");
    }

    @Override
    public Integer getReviewCountStars() {
        Response response = get(ITEM_URL);
        String productId = Parser.rozetkaHiddenItem(response.getBody().asString(), "$.productID");
        response = get(BASE_URL + "/recent_goods_sync/action=getRecentGoods;goods_ids=" + productId + "/");
        String json = response.getBody().asString();
        String countComments = JsonPath.read(json, "$.content[0].count_comments");
        return Integer.valueOf(countComments);
    }

    @Override
    public Integer getRating() {
        Response response = get(ITEM_URL);
        String productId = Parser.rozetkaHiddenItem(response.getBody().asString(), "$.productID");
        response = get(BASE_URL + "/recent_goods_sync/action=getRecentGoods;goods_ids=" + productId + "/");
        return JsonPath.read(response.getBody().asString(), "$.content[0].users_rating");
    }
}