package tests;

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
        String url = BASE_URL + "/search/?text=" + id;
        Response searchResult = get(url);
        url = Parser.rozetkaHiddenItem(searchResult.getBody().asString(), "$.productHref");

        String itemPage = get(url).getBody().asString();
        String usdPrice = Parser.rozetkaHiddenItem(itemPage, "$.productPrice");
        System.out.println("price for article with id " + id + " is " + usdPrice + "$");

        Integer countComments = Parser.rozetkaDirtyRegexp("reviewCount\\\"\\scontent=\\\"\\d{1,}\\\"", itemPage);
        Integer userRating = Parser.rozetkaDirtyRegexp("ratingValue\\\"\\scontent=\\\"\\d{1,}\\\"", itemPage);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countComments, expCommentsQuantity, "review count ");
        softAssert.assertEquals(userRating, expRating,"rating ");
        softAssert.assertAll();
    }
}