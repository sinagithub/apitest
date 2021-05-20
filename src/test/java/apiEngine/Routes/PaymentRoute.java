package apiEngine.Routes;

public class PaymentRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String PAYMENT ="/payment";
    private static final String CARDS = "/cards";
    private static final String USER = "/user";



    public static String getCards() { return
            API + VERSION + PAYMENT + USER+ CARDS;
    }

}
