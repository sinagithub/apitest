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
        CarsiSplashClient mockSplash = new CarsiSplashClient("http://localhost:3464");
        IRestResponse<SplashResponse> splashResponse = mockSplash.getSplash();
        getScenarioContext().setContext(Context.SPLASH_RESPONSE_DATA, splashResponse.getBody().getData());
    }

    @Then("User check campaign id list are valid")
    public void campaigns_Id_should_valid() {
        SplashData splashData = (SplashData) getScenarioContext().getContext(Context.SPLASH_RESPONSE_DATA);
        for (CampaignsItem campaignsItem : splashData.getCampaigns()) {
            assertTrue(campaignsItem.getCampaignId() != null, "CampaignId id should not null");
        }
    }
    @Then("User carsi Logo url is valid")
    public void carsiLogo_should_valid() {
        SplashData splashData = (SplashData) getScenarioContext().getContext(Context.SPLASH_RESPONSE_DATA);
        String carsiUrl = splashData.getCarsiLogoUrl();
        assertTrue(!carsiUrl.isEmpty(),"Carsi logo url should not empty" );
    }

    @Then("User check campaign Seo list are valid")
    public void campaigns_seoUrl_should_valid() {
        SplashData splashData = (SplashData) getScenarioContext().getContext(Context.SPLASH_RESPONSE_DATA);

        for (CampaignsItem campaignsItem : splashData.getCampaigns()) {
            assertTrue(!campaignsItem.getSeoUrl().isEmpty(), "Campaign seo url should not empty");
        }
    }

    @Then("User check campaign ThumbImage list are valid")
    public void campaigns_ThumbImage_should_valid() {
        SplashData splashData = (SplashData) getScenarioContext().getContext(Context.SPLASH_RESPONSE_DATA);
        for (CampaignsItem campaignsItem : splashData.getCampaigns()) {
            assertTrue(!campaignsItem.getCampaignThumbImageUrl().isEmpty(), "Campaign CampaignThumbImage url should not empty");
        }
    }


}
