package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Created by sirdir on 18.05.17.
 */
public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }
}