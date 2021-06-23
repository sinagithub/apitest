package apiEngine.Routes;

public class CheckOutRoute {
    private static final String CHECKOUT = "/checkout";
    private static final String API = "/api";
    private static final String VERSION = "/v1";

    public static String postCheckout(){
        return API + VERSION + CHECKOUT;
    }
}
