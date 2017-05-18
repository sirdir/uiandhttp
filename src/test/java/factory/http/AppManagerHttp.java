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
}
