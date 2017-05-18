package factory.drv;

import factory.interfaces.ItemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Parser;

/**
 * Created by sirdir on 18.05.17.
 */
public class ItemHelperDrv implements ItemHelper {
    private final WebDriver driver;

    ItemHelperDrv(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getUsdPrice() {
        String pageSource = driver.getPageSource();
        return Parser.rozetkaHiddenItem(pageSource, "$.productPriceLocal");
    }

    @Override
    public Integer getReviewCountStars() {
        By cssSelector = By.cssSelector("span[itemprop='aggregateRating']>meta[itemprop='reviewCount']");
        String reviewCount = driver.findElement(cssSelector).getAttribute("content");
        return Integer.valueOf(reviewCount);
    }

    @Override
    public Integer getRating() {
        By cssSelector = By.cssSelector("span[itemprop='aggregateRating']>meta[itemprop='ratingValue']");
        String rating = driver.findElement(cssSelector).getAttribute("content");
        return Integer.valueOf(rating);
    }
}