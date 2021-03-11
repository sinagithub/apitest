package cucumber;

import apiEngine.ApiClient;
import apiEngine.BaseUrls;
import clients.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import clients.carsi.CarsiUserClient;
import enums.Context;

public class TestContext {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ApiClient apiClient;
    private ScenarioContext scenarioContext;

    private CarsiUserClient carsiUserClient;

    public TestContext() {

        carsiClient = new CarsiClient("testBase");
        ysClient = new YSClient();
        scenarioContext = new ScenarioContext();
        carsiUserClient = new CarsiUserClient("https://store-user-api.yemeksepeti.com");
        oauthCoreClient = new OauthCoreClient("https://oauthcore.yemeksepeti.com");

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




}