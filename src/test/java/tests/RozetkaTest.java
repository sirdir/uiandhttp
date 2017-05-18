package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sirdir on 18.05.17.
 */
public class RozetkaTest extends BaseTest {

    @Test(dataProvider = "idCommentsQuantityRating")
    public void repliesAndRatingForAlco(long id, int expCommentsQuantity, int expRating){
        app.getSearchHelper().searchById(id);
        System.out.println(app.getItemHelper().getUsdPrice()); //todo need addition requirements what to do with this
        Assert.assertEquals(app.getItemHelper().getCommentQuantity(), expCommentsQuantity);
        Assert.assertEquals(app.getItemHelper().getRating(), expRating);
    }
}