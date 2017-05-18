package tests;

import factory.Browser;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Parser;

/**
 * Created by sirdir on 18.05.17.
 */
@Test(groups = "drv")
public class RozetkaTestDrv extends BaseTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupBrowser(){
        driver = DriverFactory.getBrowser(Browser.CHROME); //todo hardcode -> param
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownBrowser(){
        if (driver != null)
            driver.quit();
    }

    @Test(dataProvider = "idCommentsQuantityRating")
    public void repliesAndRatingForAlco(Long id, Integer expCommentsQuantity, Integer expRating){
        driver.get("http://rozetka.com.ua/");
        driver.findElement(By.cssSelector("input.rz-header-search-input-text")).sendKeys(id.toString());
        driver.findElement(By.name("rz-search-button")).click();

        String pageSource = driver.getPageSource();
        String usdPrice = Parser.rozetkaHiddenItem(pageSource, "$.productPrice");
        System.out.println("price for article with id " + id + " is " + usdPrice + "$");

        By cssSelector1 = By.cssSelector("span[itemprop='aggregateRating']>meta[itemprop='reviewCount']");
        String countCommentsStr = driver.findElement(cssSelector1).getAttribute("content");
        Integer countComments = Integer.valueOf(countCommentsStr);

        By cssSelector2 = By.cssSelector("span[itemprop='aggregateRating']>meta[itemprop='ratingValue']");
        String userRatingStr = driver.findElement(cssSelector2).getAttribute("content");
        Integer userRating = Integer.valueOf(userRatingStr);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countComments, expCommentsQuantity, "review count ");
        softAssert.assertEquals(userRating, expRating,"rating ");
        softAssert.assertAll();
    }
}