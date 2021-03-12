package cucumber;

import clients.BaseUrls;
import clients.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import clients.carsi.CarsiHomePageClient;
import clients.carsi.CarsiUserClient;
import clients.carsi.CarsiVendorClient;

public class TestContext {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ScenarioContext scenarioContext;

    private CarsiUserClient carsiUserClient;
    private CarsiHomePageClient carsiHomePageClient;
    private CarsiVendorClient carsiVendorClient;

    public TestContext() {

        carsiClient = new CarsiClient("testBase");
        ysClient = new YSClient();
        scenarioContext = new ScenarioContext();
        carsiUserClient = new CarsiUserClient("https://store-user-api.yemeksepeti.com");
        oauthCoreClient = new OauthCoreClient("https://oauthcore.yemeksepeti.com");
        carsiHomePageClient = new CarsiHomePageClient(BaseUrls.getCarsiBaseUrl());
        carsiVendorClient = new CarsiVendorClient(BaseUrls.getCarsiBaseUrl());

    }

    public OauthCoreClient getOauthCoreClient() {
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
        return carsiUserClient;
    }

    public CarsiHomePageClient getCarsiHomePageClient() {
        return carsiHomePageClient;
    }
}