package tests;

import factory.interfaces.AppManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

/**
 * Created by sirdir on 18.05.17.
 */
public class BaseTest {

    protected AppManager app;

    @BeforeSuite
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeClass
    public void beforeClass(){
        WebDriver driver;
        driver = new ChromeDriver();
    }


    @DataProvider
    public static Object[][] idCommentsQuantityRating() {
        return new Object[][]{
                {5000299223017L, 49, 5}
        };
    }
}