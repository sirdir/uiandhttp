package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sirdir on 19.05.17.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.rz-header-search-input-text")
    private WebElement searchInput;

    @FindBy(name = "rz-search-button")
    private WebElement searchButton;

    public ItemPage searchById(Long id) {
        searchInput.sendKeys(id.toString());
        searchButton.click();
        return PageFactory.initElements(driver, ItemPage.class);
    }
}
