package apiEngine.Routes;

public class MarketingRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String CAMPAIGN = "/campaign";
    private static final String MARKETING = "/marketing";
    private static final String ACTIVATE = "/{campaignId}/activate";

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

    public static String getActivate() {
        return getCampaign() + ACTIVATE;
    }
}

