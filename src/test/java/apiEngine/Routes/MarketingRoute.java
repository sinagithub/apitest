package apiEngine.Routes;

public class MarketingRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String CAMPAIGN = "/campaign";
    private static final String MARKETING = "/marketing";
    private static final String CAMPAIGN_ID = "/{campaignId}";
    private static final String ACTIVATE = "/activate";
    private static final String CAMPAIGN_COUPON = "/coupon";
    private static final String AUTOMATION = "/automation";
    private static final String COMPENSATION = "/compensation";

    public static String getMarketing() {
        return MARKETING;
    }

    public static String getAPI() {
        return getMarketing() + API;
    }

    public static String getVERSION() {
        return VERSION;
    }

    public static String getCampaign() {
        return getAPI() + getVERSION() + CAMPAIGN;
    }

    public static String getCampaignId() {
        return getCampaign() + CAMPAIGN_ID;
    }

    public static String getCompensation(){
        return getAPI() + getVERSION() + COMPENSATION;
    }

    public static String getActivate() {
        return getCampaignId() + ACTIVATE;
    }

    public static String getCampaignCoupon() {
        return getCampaignId() + CAMPAIGN_COUPON;
    }

    public static String getDeleteCampaign() {
        return MARKETING+ API + VERSION + AUTOMATION + CAMPAIGN + CAMPAIGN_ID;
    }
}
