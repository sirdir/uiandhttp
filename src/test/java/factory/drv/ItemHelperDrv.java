package factory.drv;

import com.jayway.jsonpath.JsonPath;
import factory.interfaces.ItemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile(ROZETKA_ITEM_REGEXP);
        Matcher matcher = pattern.matcher(pageSource);
        String usdPrice = null;
        if (matcher.find()){
            String match = matcher.group(0);
            String json = match.substring(23, match.length()-11);
            System.out.println("it is json");
            System.out.println(json);
            usdPrice = JsonPath.read(json, "$.productPriceLocal");
        }
        return usdPrice;
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