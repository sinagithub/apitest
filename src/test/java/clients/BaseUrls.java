package clients;

public class BaseUrls {

    private static final String CARSI_BASE_URL = "http://carsi-api-stg.yemeksepeti.com";
    private static final String MOCK_BASE_URL = "http://localhost:3464";


    public static String getCarsiBaseUrl() {
        return CARSI_BASE_URL;
    }
    public static String mockBaseUrl(){
        return MOCK_BASE_URL;
    }

}
