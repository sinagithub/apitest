package apiEngine.Routes;

public class AddressRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String ADDRESS = "/address";
    private static final String AVAILABLE = "/available";
    private static final String ACTION = "/action";
    private static final String ADDRESS_ID_PATH = "/{addressId}";
    private static final String AVAILABLE_CHECKOUT = "/available-checkout";


    public static String getAddress() {
        return API + VERSION + ADDRESS;
    }

    public static String getAvailable() {
        return getAddress() + AVAILABLE;
    }


    public static String getAction() {
        return getAddress() + ACTION;
    }

    public static String getAddressDetail() {
        return API + VERSION + ADDRESS + ADDRESS_ID_PATH;
    }

    public static String getAvailableCheckout() {
        return getAddress() + AVAILABLE_CHECKOUT;
    }

}


