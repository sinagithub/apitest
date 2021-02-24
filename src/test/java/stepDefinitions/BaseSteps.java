package stepDefinitions;

import clients.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseSteps {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ScenarioContext scenarioContext;


    public BaseSteps(TestContext testContext) {
        carsiClient = testContext.getCarsiClient();
        oauthCoreClient = testContext.getOauthCoreClient();
        ysClient = testContext.getYsClient();
        scenarioContext = testContext.getScenarioContext();
    }


    public CarsiClient getCarsiClient() {
        return carsiClient;
    }

    public YSClient getYsClient() {
        return ysClient;
    }

    public OauthCoreClient getOauthCoreClient() {
        return oauthCoreClient;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


}