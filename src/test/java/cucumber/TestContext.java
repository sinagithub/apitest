package cucumber;

import clients.BaseUrls;
import clients.carsi.*;
import clients.OauthCoreClient;
import clients.carsi.microServiceClients.CarsiInternalVendorClient;
import clients.carsi.microServiceClients.InternalMarketingClient;
import clients.carsi.microServiceClients.InternalTaggingClient;

public class TestContext {

    private static ScenarioContext scenarioContext;


    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public CarsiVendorClient getCarsiVendorClient() {
        return new CarsiVendorClient(BaseUrls.getCarsiBaseUrl());
    }

    public OauthCoreClient getOauthCoreClient() {
        return new OauthCoreClient(BaseUrls.getOauthBaseUrl());
    }


    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


    public CarsiHomePageClient getCarsiHomePageClient() {
        return new CarsiHomePageClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiProductClient getCarsiProductClient() {
        return new CarsiProductClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiSplashClient getCarsiSplashClient() {
        return new CarsiSplashClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiBasketClient getCarsiBasketClient() {
        return new CarsiBasketClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiFavoriteClient getCarsiFavoriteClient() {
        return new CarsiFavoriteClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiContentClient getCarsiContentClient() {
        return new CarsiContentClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiOrderClient getCarsiOrderClient() {
        return new CarsiOrderClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiPaymentClient getCarsiPaymentClient() {
        return new CarsiPaymentClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiInternalVendorClient getCarsiInternalVendorClient() {
        return new CarsiInternalVendorClient(BaseUrls.getInternalMicroBaseUrl());
    }

    public CarsiCheckoutClient getCarsiCheckoutClient() {
        return new CarsiCheckoutClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiAddressesClient getCarsiAddressClient() {
        return new CarsiAddressesClient(BaseUrls.getCarsiBaseUrl());
    }

    public InternalTaggingClient getInternalTaggingClint(){
        return new InternalTaggingClient(BaseUrls.getInternalMicroBaseUrl());
    }

    public InternalMarketingClient getInternalMarketingClient(){
        return new InternalMarketingClient(BaseUrls.getInternalMicroBaseUrl());
    }

}