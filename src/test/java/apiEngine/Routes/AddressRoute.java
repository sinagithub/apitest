package apiEngine.Routes;

public class AddressRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String ADDRESS = "/address";
    private static final String AVAILABLE = "/available";


    public static String getAddress() {
        return API + VERSION + ADDRESS;
    }

    public static String getAvailable() {
        return getAddress() + AVAILABLE;
    }

}


