package cucumber;

import clients.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import enums.Context;

public class TestContext {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ScenarioContext scenarioContext;

    public TestContext() {
        oauthCoreClient = new OauthCoreClient();
        carsiClient = new CarsiClient();
        ysClient = new YSClient();
        scenarioContext = new ScenarioContext();
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



}