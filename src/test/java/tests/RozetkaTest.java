package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by sirdir on 18.05.17.
 */
public class RozetkaTest extends BaseTest {

    @Test(dataProvider = "idCommentsQuantityRating")
    public void repliesAndRatingForAlco(Long id, Integer expCommentsQuantity, Integer expRating){
        app.getSearchHelper().searchById(id);
        System.out.println(app.getItemHelper().getUsdPrice()); //todo need addition requirements what to do with this
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(app.getItemHelper().getReviewCountStars(), expCommentsQuantity, "review count ");
        softAssert.assertEquals(app.getItemHelper().getRating(), expRating,"rating ");
        softAssert.assertAll();
    }
}