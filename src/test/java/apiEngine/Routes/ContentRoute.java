package apiEngine.Routes;

public class ContentRoute {
    private static final String CONTENT = "/content";
    private static final String FAQ = "/faq";
    private static final String API = "/api";
    private static final String VERSION = "/v1";

    public static String getFaq(){
        return API + VERSION + CONTENT + FAQ;
    }


}
