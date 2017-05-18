package factory.interfaces;

/**
 * Created by sirdir on 18.05.17.
 */
public interface ItemHelper {

    String ROZETKA_ITEM_REGEXP = "<script>dataLayer\\.push\\(.{1,}\\);<\\/script>";

    String getUsdPrice();

    Integer getReviewCountStars();

    Integer getRating();
}