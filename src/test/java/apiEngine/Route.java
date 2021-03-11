package apiEngine;

public class Route {

    private static final String OAUTH = "/oauth";
    private static final String TOKEN = "/token";
    private static final String VERSION = "/v1";
    private static final String AUTHORIZE = "/authorize";
    private static final String API = "/api";
    private static final String ADDRESSES = "/address";
    private static final String AVAILABLE_ADDRESSES = "/available-addresses";



    public static String generateAccessToken() {
        return VERSION + OAUTH + AUTHORIZE;
    }

    public static String getLoginToken() {
        return VERSION + OAUTH + TOKEN;
    }

    public static String availableAddresses(){
        return API + VERSION + ADDRESSES + AVAILABLE_ADDRESSES;
    }
}
