package factory.drv;

import factory.interfaces.AppManager;
import factory.interfaces.ItemHelper;
import factory.interfaces.SearchHelper;
import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Created by sirdir on 18.05.17.
 */
public class AppManagerDrv implements AppManager {


    private ItemHelper itemHelper;
    private SearchHelper searchHelper;

    public AppManagerDrv(){
        ChromeDriverManager.getInstance().setup();
        itemHelper = new ItemHelperDrv();
        searchHelper = new SearchHelperDrv();
    }

    @Override
    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    @Override
    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
