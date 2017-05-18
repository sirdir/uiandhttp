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

    @DataProvider
    public static Object[][] idCommentsQuantityRating() {
        return new Object[][]{
                {5000299223017L, 49, 5}
        };
    }
}