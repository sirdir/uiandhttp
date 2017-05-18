package tests;

import factory.drv.AppManagerDrv;
import factory.http.AppManagerHttp;
import factory.interfaces.AppManager;
import org.testng.annotations.*;

/**
 * Created by sirdir on 18.05.17.
 */
public class BaseTest {

    AppManager app;
    public static final String BASE_URL = "http://rozetka.com.ua";

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        String appType = System.getProperty("app.type");
        switch (appType != null ? appType : "http"){
            default:
            case "http":
                app = new AppManagerHttp();
                break;
            case "drv":
                app = new AppManagerDrv();
                break;
        }
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(){
        if (app != null)
            app.tearDown();
    }

    @DataProvider
    public static Object[][] idCommentsQuantityRating() {
        return new Object[][]{
                {5000299223017L, 49, 5}
        };
    }
}