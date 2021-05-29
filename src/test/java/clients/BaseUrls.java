package clients;

import apiEngine.Utils;

import java.io.IOException;

public class BaseUrls {

    private static final String CARSI_BASE_URL = "http://carsi-api-stg.yemeksepeti.com";
    private static final String MOCK_BASE_URL = "http://localhost:3464";
    private static final String INTERNAL_VENDOR_URL = "http://172.20.1.232:7050";


    public static String getCarsiBaseUrl() {
        try {
            return Utils.getGlobalValue("carsiStageBaseUrl");
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
          return Utils.getGlobalValue("InternalVendorBaseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
