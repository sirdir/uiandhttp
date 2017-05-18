package factory.drv;

import factory.interfaces.SearchHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sirdir on 18.05.17.
 */
public class SearchHelperDrv implements SearchHelper {
    private final WebDriver driver;

    SearchHelperDrv(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void searchById(Long id) {
        driver.get("http://rozetka.com.ua/");
        driver.findElement(By.cssSelector("input.rz-header-search-input-text")).sendKeys(id.toString());
        driver.findElement(By.name("rz-search-button")).click();
    }
}