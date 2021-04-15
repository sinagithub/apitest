package cucumber;

import apiEngine.ApiClient;
import clients.BaseUrls;
import clients.carsi.*;
import clients.OauthCoreClient;
import clients.YSClient;
import stepDefinitions.Hooks;
import stepDefinitions.MockServer;

public class TestContext {

    private static OauthCoreClient oauthCoreClient;
    private static ScenarioContext scenarioContext;
    private static CarsiBasketClient carsiBasketClient;
    private static CarsiUserClient carsiUserClient;


    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public CarsiVendorClient getCarsiVendorClient() {
         return new CarsiVendorClient(BaseUrls.getCarsiBaseUrl());
    }

    public OauthCoreClient getOauthCoreClient() {
        return new OauthCoreClient("https://oauthcore.yemeksepeti.com");
    }

    public CarsiClient getCarsiClient() {
        return new CarsiUserClient("https://store-user-api.yemeksepeti.com");
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

    public CarsiSplashClient getCarsiSplashClient() {
        return  new CarsiSplashClient(BaseUrls.getCarsiBaseUrl());
    }

   public CarsiBasketClient getCarsiBasketClient(){
        return new CarsiBasketClient(BaseUrls.getCarsiBaseUrl());
   }
}