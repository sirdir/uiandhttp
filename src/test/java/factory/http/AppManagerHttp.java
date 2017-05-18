package factory.http;

import factory.interfaces.AppManager;
import factory.interfaces.ItemHelper;
import factory.interfaces.SearchHelper;

/**
 * Created by sirdir on 18.05.17.
 */
public class AppManagerHttp implements AppManager {

    private ItemHelper itemHelper;
    private SearchHelper searchHelper;

    public static String ITEM_URL;

    public AppManagerHttp(){
        itemHelper = new ItemHelperHttp();
        searchHelper = new SearchHelperHttp();
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
        //epmty nothing to clean
    }
}
