package cucumber;

import clients.BaseUrls;
import clients.carsi.*;
import clients.OauthCoreClient;
import clients.YSClient;

public class TestContext {

    private static OauthCoreClient oauthCoreClient;
    private static CarsiClient carsiClient;
    private static YSClient ysClient;
    private static ScenarioContext scenarioContext;

    private static CarsiUserClient carsiUserClient;
    private static CarsiHomePageClient carsiHomePageClient;
    private static CarsiVendorClient carsiVendorClient;
    private static CarsiProductClient carsiProductClient;


    public TestContext() {
        scenarioContext = new ScenarioContext();
       // carsiVendorClient = new CarsiVendorClient("http://carsi-api-stg.yemeksepeti.com");

    }

    public OauthCoreClient getOauthCoreClient() {
        oauthCoreClient = new OauthCoreClient("https://oauthcore.yemeksepeti.com");
        return oauthCoreClient;
    }

    public CarsiClient getCarsiClient() {
        return new CarsiUserClient("https://store-user-api.yemeksepeti.com");
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
        return new CarsiHomePageClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiProductClient getCarsiProductClient() {
        return new CarsiProductClient("http://carsi-api-stg.yemeksepeti.com");
    }
}