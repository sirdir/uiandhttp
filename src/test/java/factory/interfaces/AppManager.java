package factory.interfaces;

/**
 * Created by sirdir on 18.05.17.
 */
public interface AppManager {
    ItemHelper getItemHelper();
    SearchHelper getSearchHelper();
    void tearDown();
}
