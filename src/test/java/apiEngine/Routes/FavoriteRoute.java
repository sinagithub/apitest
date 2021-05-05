package apiEngine.Routes;

public class FavoriteRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String FAVORITE = "/favorite";
    private static final String VENDOR = "/vendor";
    private static final String VENDOR_PATH = "/{vendorId}";
    private static final String DETAIL = "/detail";
    private static final String PRODUCT = "/product";
    private static final String PRODUCT_PATH = "/{productId}";


    public static String getFavorite() {
        return API + VERSION + FAVORITE;
    }

    public static String getFavoriteVendorDetail() {
        return API + VERSION + FAVORITE + VENDOR + VENDOR_PATH + DETAIL;
    }

    public static String getAddFavoriteProduct() {
        return API + VERSION + FAVORITE + VENDOR + VENDOR_PATH + PRODUCT;
    }

    public static String getAddFavoriteVendor() {
        return API + VERSION + FAVORITE + VENDOR;
    }

    public static String  getDeleteFavoriteProduct(){
        return API + VERSION + FAVORITE + VENDOR + VENDOR_PATH +PRODUCT + PRODUCT_PATH;
    }

    public static String getDeleteVendor(){
        return API + VERSION + FAVORITE + VENDOR + VENDOR_PATH;
    }

}
