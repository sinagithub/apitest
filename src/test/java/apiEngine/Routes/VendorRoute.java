package apiEngine.Routes;

public class VendorRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String VENDOR = "/vendor/{vendorId}";
    private static final String PRODUCTS = "/products";
    private static final String SEARCH = "/search";

    public static String getVendor() {
        return API + VERSION + VENDOR;
    }

    public static String getVendorProducts() {
        return getVendor() + PRODUCTS;
    }

    public static String getVendorProductSearch() {
        return getVendorProducts() + SEARCH;
    }
}


