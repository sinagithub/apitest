package cucumber;

import clients.BaseUrls;
import clients.carsi.*;
import clients.OauthCoreClient;
import clients.carsi.microServiceClients.CarsiInternalVendor;

public class TestContext {

    private static ScenarioContext scenarioContext;
    private static CarsiUserClient carsiUserClient;



    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public CarsiVendorClient getCarsiVendorClient() {
         return new CarsiVendorClient(BaseUrls.getCarsiBaseUrl());
    }

    public OauthCoreClient getOauthCoreClient() {
        return new OauthCoreClient(BaseUrls.getOauthBaseUrl());
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
        return new CarsiProductClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiSplashClient getCarsiSplashClient() {
        return  new CarsiSplashClient(BaseUrls.getCarsiBaseUrl());
    }

   public CarsiBasketClient getCarsiBasketClient(){
        return new CarsiBasketClient(BaseUrls.getCarsiBaseUrl());
   }

   public CarsiFavoriteClient getCarsiFavoriteClient(){
        return new CarsiFavoriteClient(BaseUrls.getCarsiBaseUrl());
   }

   public CarsiContentClient getCarsiContentClient () {
        return new CarsiContentClient(BaseUrls.getCarsiBaseUrl());
   }

   public CarsiOrderClient getCarsiOrderClient (){
        return new CarsiOrderClient(BaseUrls.getCarsiBaseUrl());
   }

   public CarsiPaymentClient getCarsiPaymentClient(){
        return new CarsiPaymentClient(BaseUrls.getCarsiBaseUrl());
   }

   public CarsiInternalVendor getCarsiInternalVendorClient() {
        return new CarsiInternalVendor(BaseUrls.getInternalVendorUrl());
   }

}