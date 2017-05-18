package factory.drv;

import factory.interfaces.AppManager;
import factory.interfaces.ItemHelper;
import factory.interfaces.SearchHelper;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sirdir on 18.05.17.
 */
public class AppManagerDrv implements AppManager {


    private ItemHelper itemHelper;
    private SearchHelper searchHelper;
    private WebDriver driver;

    public AppManagerDrv(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();//todo maybe another fabric for diff browsers?
        driver.manage().window().maximize();
        itemHelper = new ItemHelperDrv(driver);
        searchHelper = new SearchHelperDrv(driver);
    }

    @Override
    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    @Override
    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    @Override
    public void tearDown() {
        driver.quit();
    }
}
