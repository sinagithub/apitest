package apiEngine;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Route {

    private static final String OAUTH = "/oauth";
    private static final String TOKEN = "/token";
    private static final String VERSION = "/v1";
    private static final String AUTHORIZE = "/authorize";
    private static final String API = "/api";
    private static final String ADDRESSES = "/address";
    private static final String AVAILABLE_ADDRESSES = "/available-addresses";
    private static final String HOMEPAGE = "/homepage";
    private static final String CARSI = "/carsi";
    private static final String BANABI = "/banabi";
    private static final String VENDOR = "/vendor/{vendorId}";
    private static final String PRODUCTS = "/products";
    private static final String BANNER = "/banner";
    private static final String PRODUCT = "/product/{productId}";


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
        return API + VERSION + HOMEPAGE + CARSI;
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
        return API + VERSION  + PRODUCT;
    }


}
