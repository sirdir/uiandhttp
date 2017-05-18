package factory.drv;

import factory.interfaces.ItemHelper;

/**
 * Created by sirdir on 18.05.17.
 */
public class ItemHelperDrv implements ItemHelper {
    @Override
    public String getPrice() {
        // <script>dataLayer\.push\(.{1,}\);<\/script>
        return null;
    }

    @Override
    public int getCommentQuantity() {
        return 0;
    }

    @Override
    public int getRating() {
        return 0;
    }
}