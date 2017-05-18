package factory.http;

import factory.interfaces.ItemHelper;

/**
 * Created by sirdir on 18.05.17.
 */
public class ItemHelperHttp implements ItemHelper {
    @Override
    public String getUsdPrice() {
        return null;
    }

    @Override
    public Integer getReviewCountStars() {
        return 0;
    }

    @Override
    public Integer getRating() {
        return 0;
    }
}