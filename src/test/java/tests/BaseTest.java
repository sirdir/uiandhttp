package tests;

import org.testng.annotations.*;

/**
 * Created by sirdir on 18.05.17.
 */
public class BaseTest {

    static final String BASE_URL = "http://rozetka.com.ua";

    @DataProvider
    static Object[][] idCommentsQuantityRating() {
        return new Object[][]{
                {5000299223017L, 49, 5}
        };
    }
}