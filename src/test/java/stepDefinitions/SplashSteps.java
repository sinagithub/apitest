package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.Splash.CampaignsItem;
import apiEngine.models.response.Splash.SplashData;
import apiEngine.models.response.Splash.SplashResponse;
import clients.carsi.CarsiSplashClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

import java.util.List;

public class SplashSteps extends BaseSteps {

    public SplashSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("Çarsı should be {string} on selected city")
    public void carsi_should_be_on_selected_city(String carsiStatus) {
        IRestResponse<SplashResponse> splashResponse =
                (IRestResponse<SplashResponse>) getScenarioContext().getContext(Context.SPLASH_RESPONSE);
        if (carsiStatus.equalsIgnoreCase("True")) {
            assertTrue(splashResponse.getBody().getData().getIsCarsiEnabled());
        } else {
            assertFalse(splashResponse.getBody().getData().getIsCarsiEnabled());
        }
    }

    @Then("I get carsi vendor status")
    public void I_get_carsi_status() {
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);
        CarsiSplashClient mockSplash = new CarsiSplashClient("http://localhost:3464");
        IRestResponse<SplashResponse> splashResponse = mockSplash.getSplash(catalogName);
        getScenarioContext().setContext(Context.SPLASH_RESPONSE, splashResponse);

    }

    @Then("Çarsı info should be valid")
    public void carsi_info_should_be_valid() {
        IRestResponse<SplashResponse> splashResponse =
                (IRestResponse<SplashResponse>) getScenarioContext().getContext(Context.SPLASH_RESPONSE);
        SplashData splashData = splashResponse.getBody().getData();
        assertNotEmpty(splashData.getCarsiLogoUrl());
        List<CampaignsItem> campaignsItem = splashData.getCampaigns();
        assertTrue(campaignsItem.size() > 0);
        for (CampaignsItem campaign : campaignsItem) {
            assertNotEmpty(campaign.getCampaignId());
            assertNotEmpty(campaign.getCampaignThumbImageUrl());
            assertNotEmpty(campaign.getSeoUrl());
        }
    }


}
