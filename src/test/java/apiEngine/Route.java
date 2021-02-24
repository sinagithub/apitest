package apiEngine;

public class Route {

    private static final String OAUTH = "/oauth";
    private static final String TOKEN = "/token";
    private static final String VERSION = "/v1";
    private static final String AUTHORIZE = "/authorize";


    public static String generateAccessToken() {
        return VERSION + OAUTH + AUTHORIZE;
    }

    public static String getLoginToken() {
        return VERSION + OAUTH + TOKEN;
    }
}
