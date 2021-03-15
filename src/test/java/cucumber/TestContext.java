package cucumber;

import clients.carsi.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import clients.carsi.CarsiHomePageClient;
import clients.carsi.CarsiUserClient;
import clients.carsi.CarsiVendorClient;

public class TestContext {

    private OauthCoreClient oauthCoreClient;
    private static CarsiClient carsiClient;
    private static YSClient ysClient;
    private static ScenarioContext scenarioContext;

    private static CarsiUserClient carsiUserClient;
    private static CarsiHomePageClient carsiHomePageClient;
    private static CarsiVendorClient carsiVendorClient;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        carsiUserClient = new CarsiUserClient("https://store-user-api.yemeksepeti.com");
        carsiVendorClient = new CarsiVendorClient("http://carsi-api-stg.yemeksepeti.com");

    }

    public OauthCoreClient getOauthCoreClient() {
        oauthCoreClient = new OauthCoreClient("https://oauthcore.yemeksepeti.com");
        return oauthCoreClient;
    }

    public CarsiClient getCarsiClient() {
        return carsiClient;
    }

    public YSClient getYsClient() {
        return ysClient;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public CarsiUserClient getCarsiUserClient() {
        carsiUserClient = new CarsiUserClient("https://store-user-api.yemeksepeti.com");
        return carsiUserClient;
    }

    public CarsiHomePageClient getCarsiHomePageClient() {
        carsiHomePageClient = new CarsiHomePageClient("http://carsi-api-stg.yemeksepeti.com");
        return carsiHomePageClient;
    }
}