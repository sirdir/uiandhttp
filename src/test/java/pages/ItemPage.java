package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Parser;

/**
 * Created by sirdir on 19.05.17.
 */
public class ItemPage extends Page {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[itemprop='aggregateRating']>meta[itemprop='reviewCount']")
    private WebElement comments;

    @FindBy(css = "span[itemprop='aggregateRating']>meta[itemprop='ratingValue']")
    private WebElement rating;

    public String getUsdPrice() {
        String pageSource = driver.getPageSource();
        return Parser.rozetkaHiddenItem(pageSource, "$.productPrice");
    }

    public Integer getCounterComments() {
        String countComments = comments.getAttribute("content");
        return Integer.valueOf(countComments);
    }

    public Integer getUserRating() {
        String userRatingStr = rating.getAttribute("content");
        return Integer.valueOf(userRatingStr);
    }
}