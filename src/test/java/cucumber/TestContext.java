package cucumber;

import clients.BaseUrls;
import clients.carsi.*;
import clients.OauthCoreClient;
import clients.carsi.microServiceClients.CarsiInternalVendor;

public class TestContext {

    private static ScenarioContext scenarioContext;
    private static CarsiAddressesClient carsiAddressesClient;


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

    public CarsiInternalVendor getCarsiInternalVendorClient() {
        return new CarsiInternalVendor(BaseUrls.getInternalVendorUrl());
    }

    public CarsiCheckoutClient getCarsiCheckoutClient() {
        return new CarsiCheckoutClient(BaseUrls.getCarsiBaseUrl());
    }

    public CarsiAddressesClient getCarsiAddressClient() {
        carsiAddressesClient =  new CarsiAddressesClient(BaseUrls.getCarsiBaseUrl());
        return carsiAddressesClient;
    }

}