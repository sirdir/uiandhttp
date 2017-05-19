package tests;

import factory.Browser;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ItemPage;
import pages.MainPage;
import utils.Parser;

/**
 * Created by sirdir on 18.05.17.
 */
@Test(groups = "drv")
public class RozetkaTestDrv extends BaseTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupBrowser(){
        driver = DriverFactory.getBrowser(Browser.CHROME);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownBrowser(){
        if (driver != null)
            driver.quit();
    }

    @Test(dataProvider = "idCommentsQuantityRating")
    public void repliesAndRatingForAlco(Long id, Integer expCommentsQuantity, Integer expRating){
        driver.get(BASE_URL);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ItemPage itemPage = mainPage.searchById(id);

        String usdPrice = itemPage.getUsdPrice();
        System.out.println("price for article with id " + id + " is " + usdPrice + "$");

        Integer countComments = itemPage.getCounterComments();
        Integer userRating = itemPage.getUserRating();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countComments, expCommentsQuantity, "review count ");
        softAssert.assertEquals(userRating, expRating,"rating ");
        softAssert.assertAll();
    }
}