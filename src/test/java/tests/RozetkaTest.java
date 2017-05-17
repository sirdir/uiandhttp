package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sirdir on 18.05.17.
 */
public class RozetkaTest extends BaseTest {

    @Test(dataProvider = "idCommentsQuantityRating")
    public void repliesAndRatingForAlco(int id, int expCommentsQuantity, int expRating){
//        app.getSearchHelper().searchById(id);
//        app.getItemHelper().getPrice();
//        Assert.assertEquals(app.getItemHelper().getCommentQuantity(), expCommentsQuantity);
//        Assert.assertEquals(app.getItemHelper().getRating(), expRating);
        // <script>dataLayer\.push\(.{1,}\);<\/script>
    }
}