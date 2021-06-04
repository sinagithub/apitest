package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.Splash.CampaignsItem;
import apiEngine.models.response.Splash.SplashData;
import apiEngine.models.response.Splash.SplashResponse;
import clients.carsi.CarsiSplashClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

import java.io.UncheckedIOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class SplashSteps extends BaseSteps {

    public SplashSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("Çarsı should be {string} on selected city")
    public void carsi_should_be_on_selected_city(String carsiStatus) {
        SplashData splashData = (SplashData) getScenarioContext().getContext(Context.SPLASH_RESPONSE_DATA);
        if (carsiStatus.equalsIgnoreCase("True")) {
            assertTrue(splashData.getIsCarsiEnabled(), "Çarşı should be available");
        } else {
            assertFalse(splashData.getIsCarsiEnabled());
        }
    }

    @Then("I get carsi status")
    public void I_get_carsi_status() {
        IRestResponse<SplashResponse> splashResponse = getCarsiSplashClient().getSplash();
        getScenarioContext().setContext(Context.SPLASH_RESPONSE_DATA, splashResponse.getBody().getData());
    }



}
