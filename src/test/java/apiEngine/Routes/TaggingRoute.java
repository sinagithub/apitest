package apiEngine.Routes;

public class TaggingRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String USER_TAG = "/usertag";
    private static final String TAGGING ="/tagging";
    private static final String DELETE_TAG = "/usertag/{id}";

    public static String getTagging() {
        return TAGGING;
    }

    public static String getAPI() {
        return getTagging() +API;
    }

    public static String getVERSION() {
        return VERSION;
    }

    public static String getUserTag() {
        return getAPI() + getVERSION() + USER_TAG;
    }

    public static String deleteUserTag(){
        return getAPI() + getVERSION() + DELETE_TAG;
    }
}


