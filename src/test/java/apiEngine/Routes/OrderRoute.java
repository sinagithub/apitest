package apiEngine.Routes;

public class OrderRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String ORDER ="/order";
    private static final String NOTE = "/note";



    public static String getNote() {
        return API + VERSION +ORDER + NOTE;
    }

}
