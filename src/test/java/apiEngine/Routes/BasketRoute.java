package apiEngine.Routes;

public class BasketRoute {
    private static final String BASKET = "/basket";
    private static final String BASKET_ID = "/id";
    private static final String BASKET_ID_PATH = "{id}";
    private static final String CAMPAIGN = "/campaign";
    private static final String LITE = "/lite";
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String PRODUCT = "/product";

    public static String getBasketId() {
        return API + VERSION + BASKET + BASKET_ID;
    }

    public static String getBasket() {
        return API + VERSION + BASKET + BASKET_ID_PATH;
    }

    public static String getCampaign() {
        return API + VERSION + BASKET + BASKET_ID_PATH + CAMPAIGN;
    }

    public static String getBasketLite() {
        return API + VERSION + BASKET + BASKET_ID_PATH + LITE;
    }

    public static String getAddProduct() {
        return getBasket() + PRODUCT;
    }


}
