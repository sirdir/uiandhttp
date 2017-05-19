package tests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Parser;

import static io.restassured.RestAssured.get;

/**
 * Created by sirdir on 18.05.17.
 */
public class RozetkaTestHttp extends BaseTest {

    @Test(dataProvider = "idCommentsQuantityRating", groups = "http")
    public void repliesAndRatingForAlco(Long id, Integer expCommentsQuantity, Integer expRating){
        Response searchResult = get(BASE_URL + "/search/?text=" + id);
        String url = Parser.rozetkaHiddenItem(searchResult.getBody().asString(), "$.productHref");


        String itemPage = get(url).getBody().asString();
        String usdPrice = Parser.rozetkaHiddenItem(itemPage, "$.productPrice");
        System.out.println("price for article with id " + id + " is " + usdPrice + "$");

        String productId = Parser.rozetkaHiddenItem(itemPage, "$.productID");

        Response response = get(BASE_URL + "/recent_goods/action=getRecentGoods;goods_ids=" + productId + "/");
        String json = response.getBody().asString();

        String countCommentsStr = JsonPath.read(json, "$.content[0].count_comments");
        Integer countComments = Integer.valueOf(countCommentsStr);
        Integer userRating = JsonPath.read(json, "$.content[0].users_rating");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countComments, expCommentsQuantity, "review count ");
        softAssert.assertEquals(userRating, expRating,"rating ");
        softAssert.assertAll();
    }
}