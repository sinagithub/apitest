package apiEngine.Routes;


public class Route {

    private static final String OAUTH = "/oauth";
    private static final String TOKEN = "/token";
    private static final String VERSION = "/v1";
    private static final String AUTHORIZE = "/authorize";
    private static final String API = "/api";
    private static final String ADDRESSES = "/address";
    private static final String AVAILABLE_ADDRESSES = "/available-addresses";
    private static final String HOMEPAGE = "/homepage";
    private static final String MAHALLE = "/mahalle";
    private static final String BANABI = "/banabi";
    private static final String VENDOR = "/vendor/{vendorId}";
    private static final String PRODUCTS = "/products";
    private static final String BANNER = "/banner";
    private static final String PRODUCT = "/product/{productId}";
    private static final String SPLASH = "/splash";
    private static final String PLATFORM = "/platform";
    private static final String BASKET = "/basket";
    private static final String BASKET_ID = "/id";
    private static final String BASKET_ID_PATH = "{id}";
    private static final String CAMPAIGN = "/campaign";
    private static final String LITE = "/lite";
    private static final String ORDER = "/order";
    private static final String ACTIVE = "/active";


    public static String generateAccessToken() {
        return VERSION + OAUTH + AUTHORIZE;
    }

    public static String getLoginToken() {
        return VERSION + OAUTH + TOKEN;
    }

    public static String availableAddresses() {
        return API + VERSION + ADDRESSES + AVAILABLE_ADDRESSES;
    }

    public static String homepageCarsi() {
        return API + VERSION + HOMEPAGE + MAHALLE;
    }

    public static String homepageBanabi() {
        return API + VERSION + HOMEPAGE + BANABI;
    }

    public static String homepageBanners() {
        return API + VERSION + HOMEPAGE + BANNER;
    }


    public static String getVendor() {
        return API + VERSION + VENDOR;
    }

    public static String getProducts() {
        return API + VERSION + VENDOR + PRODUCTS;
    }

    public static String getProduct() {
        return API + VERSION + PRODUCT;
    }

    public static String getSplash() {
        return API + VERSION + SPLASH;
    }

    public static String homepagePlatform() {
        return API + VERSION + HOMEPAGE + PLATFORM;
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
    public static String getActiveOrders() {
        return API + VERSION + ORDER + ACTIVE;
    }

    public static String getVendorProducts(){
        return API + VERSION + VENDOR + PRODUCTS;
    }




}
