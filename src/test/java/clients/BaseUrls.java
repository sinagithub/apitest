package clients;

import apiEngine.Utils;

import java.io.IOException;

public class BaseUrls {

    private static final String MOCK_BASE_URL = "http://localhost:3464";

    public static String getCarsiBaseUrl() {
        try {
            return Utils.getGlobalValue("carsiStageBaseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getOauthBaseUrl() {
        try {
            return Utils.getGlobalValue("oauthBaseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String mockBaseUrl(){
        return MOCK_BASE_URL;
    }

    public static String getInternalVendorUrl(){
        try {
          return Utils.getGlobalValue("internalVendorBaseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
