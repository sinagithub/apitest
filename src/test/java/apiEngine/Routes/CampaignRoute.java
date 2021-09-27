package apiEngine.Routes;

public class CampaignRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String CAMPAIGN = "/campaign";
    private static final String COUPONS = "/coupons";
    private static final String VENDOR = "/vendor/{vendorId}";
    private static final String CAMPAIGNS = "/campaigns";

    public static String getCampaign() {
        return API + VERSION + CAMPAIGN;
    }

    public static String getCoupons() {
        return getCampaign() + COUPONS;
    }

    public static String getVendorCampaigns() {
        return API + VERSION + VENDOR + CAMPAIGNS;
    }

}
