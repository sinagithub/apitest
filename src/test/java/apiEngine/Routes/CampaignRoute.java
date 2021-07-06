package apiEngine.Routes;

public class CampaignRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String CAMPAIGN ="/campaign";
    private static final String COUPONS = "/coupons";



    public static String getCampaign(){
        return API + VERSION + CAMPAIGN;
    }
    public static String getCoupons() {
        return getCampaign() + COUPONS;
    }

}
