package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.requests.InternalVendor.Marketing.Campaign;
import apiEngine.models.requests.InternalVendor.Marketing.DescriptionEn;
import apiEngine.models.requests.InternalVendor.Marketing.DescriptionTr;
import apiEngine.models.response.Basket.BasketResponse;
import apiEngine.models.response.Basket.Campaign.Coupon;
import apiEngine.models.response.Campaign.CampaignCouponsResponse;
import apiEngine.models.response.Campaign.CampaignsData;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;


@SuppressWarnings("unchecked")
public class CampaignSteps extends BaseSteps {

    public CampaignSteps(TestContext testContext) {
        super(testContext);
    }

    private IRestResponse<BasketResponse> getBasketResponse() {
        return (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);
    }

    private IRestResponse<CampaignCouponsResponse> getCampaignResponse() {
        return (IRestResponse<CampaignCouponsResponse>) getScenarioContext().getContext(Context.CAMPAIGN_COUPONS_RESPONSE);
    }

    private List<CampaignsData> getCampaignCouponDataList() {
        return getCampaignResponse().getBody().getData();
    }

    private HashMap getDefinedCampaignInfo() {
        return (HashMap) getScenarioContext().getContext(Context.DEFINATED_CAMPAIGN);
    }

    private List<Coupon> getBasketCouponList() {
        return (List<Coupon>) getScenarioContext().getContext(Context.BASKET_COUPON_LIST);
    }

    private List<apiEngine.models.response.Basket.Campaign.Campaign> getBasketCampaignList() {
        return (List<apiEngine.models.response.Basket.Campaign.Campaign>) getScenarioContext().getContext(Context.BASKET_CAMPAIGN_LIST);
    }

    private Campaign getSelectedCampaignInfo() {
        return (Campaign) getDefinedCampaignInfo().get("Campaign");
    }

    private DescriptionTr getSelectedCampaignDescriptionTr() {
        return (DescriptionTr) getDefinedCampaignInfo().get("DescriptionTr");
    }

    private DescriptionEn getSelectedCampaignDescriptionEn() {
        return (DescriptionEn) getDefinedCampaignInfo().get("DescriptionEn");
    }

    private apiEngine.models.requests.InternalVendor.Marketing.Coupon getSelectedCouponInfo() {
        return (apiEngine.models.requests.InternalVendor.Marketing.Coupon) getDefinedCampaignInfo().get("Coupon");
    }

    @Then("I list Coupons in campaign coupons response")
    public void i_list_coupons_in_campaign_coupons_response() {
        IRestResponse<CampaignCouponsResponse> campaignCouponsResponse = getCarsiCampaignsClient().getCoupons();
        getScenarioContext().setContext(Context.CAMPAIGN_COUPONS_RESPONSE, campaignCouponsResponse);
    }

    @Then("I validate created coupon is listed in campaign coupons response")
    public void i_validate_created_coupon_is_listed_in_campaign_coupons_response() {
        String expectedTitle = getSelectedCampaignDescriptionTr().getTitle();
        String expectedDes = getSelectedCampaignDescriptionTr().getDescription();

        List<CampaignsData> campaignsList = getCampaignCouponDataList();
        int campaignIndex = -1;
        for (CampaignsData campaign : campaignsList) {
            if (campaign.getCampaignTitle().equalsIgnoreCase(expectedTitle)) {
                campaignIndex = campaignsList.indexOf(campaign);
                break;
            }
        }

        String actualTitle = getCampaignCouponDataList().get(campaignIndex).getCampaignTitle();
        String actualDesc = getCampaignCouponDataList().get(campaignIndex).getDescription();
        assertEqual("Campaign title should be " + expectedTitle, actualTitle, expectedTitle);
        assertEqual("Campaign Desc should be " + expectedDes, actualDesc, expectedDes);
    }

    @Then("I list Coupons in basket response")
    public void i_list_coupons_in_basket_response() {
        List<Coupon> couponList = getBasketResponse().getBody().getData().getCoupons();
        getScenarioContext().setContext(Context.BASKET_COUPON_LIST, couponList);
    }

    @Then("I list Campaigns in basket response")
    public void i_list_campaigns_in_basket_response() {
        List<apiEngine.models.response.Basket.Campaign.Campaign> campaignList =
                getBasketResponse().getBody().getData().getCampaigns();
        getScenarioContext().setContext(Context.BASKET_CAMPAIGN_LIST, campaignList);
    }

    private int getCreatedCouponIndexFromBasketCoupons() {
        List<Coupon> couponList = getBasketCouponList();
        String definedCouponCode = getSelectedCouponInfo().getCouponCode();
        int selectedCouponIndex = -1;
        for (Coupon coupon : couponList) {
            if (coupon.getCode().equalsIgnoreCase(definedCouponCode)) {
                selectedCouponIndex = couponList.indexOf(coupon);
                break;
            }
        }
        return selectedCouponIndex;
    }

    private int getCreatedCouponIndexFromBasketCampaigns() {
        List<apiEngine.models.response.Basket.Campaign.Campaign> campaignList = getBasketCampaignList();
        Campaign selectedCampaignInfo = getSelectedCampaignInfo();
        int selectedCampaignIndex = -1;
        for (apiEngine.models.response.Basket.Campaign.Campaign campaign : campaignList) {
            if (campaign.getCampaignItem().getTitle().equalsIgnoreCase(selectedCampaignInfo.getName())) {
                selectedCampaignIndex = campaignList.indexOf(campaign);
                break;
            }
        }
        return selectedCampaignIndex;
    }

    @Then("I validate created coupon is listed in basket response")
    public void i_validate_created_coupon_is_listed_in_basket_response() {
        assertTrue(getCreatedCouponIndexFromBasketCoupons() != -1,
                "Created Coupon should be on the basket coupons");

    }

    @Then("I validate coupon image url is valid in basket response")
    public void i_validate_coupon_image_url_is_valid_in_basket_response() {
        List<Coupon> couponList = getBasketCouponList();
        String actualImageUrl = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getImageUrl();
        String expectedImageUrl = getSelectedCampaignDescriptionTr().getImageUrl();
        assertEqual("Image url should be match on basket coupons", actualImageUrl, expectedImageUrl);

    }

    @Then("I vaidate coupon name is valid in basket response")
    public void i_vaidate_coupon_name_is_valid_in_basket_response() {
        List<Coupon> couponList = getBasketCouponList();
        String actualName = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getName();
        String expectedName = getSelectedCampaignDescriptionTr().getTitle();
        assertEqual("Coupon Name should be match on basket coupons", actualName, expectedName);
    }

    @Then("I validate coupon code is valid in basket response")
    public void i_validate_coupon_code_is_valid_in_basket_response() {
        List<Coupon> couponList = getBasketCouponList();
        String actualCode = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getCode();
        String expectedCode = getSelectedCouponInfo().getCouponCode();
        assertEqual("Coupon Code should be match on basket coupons", actualCode, expectedCode);
    }

    @Then("I validate coupon IsOtpRequired is valid in basket response")
    public void i_validate_coupon_is_otp_required_is_valid_in_basket_response() {
        Campaign selectedCampaignInfo = getSelectedCampaignInfo();

        List<Coupon> couponList = getBasketCouponList();
        boolean actualOtpReq = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getIsOtpRequired();
        boolean expectedOtpReq = selectedCampaignInfo.getIsOtpRequired();
        assertTrue(actualOtpReq == expectedOtpReq, "IsOtp Req should be " + expectedOtpReq);
    }

    @Then("I validate campaign of created coupon is not listed in basket campaigns")
    public void i_validate_campaign_of_created_coupon_is_not_listed_in_basket_response() {
        int index = getCreatedCouponIndexFromBasketCampaigns();
        assertTrue(index == -1, "Coupons should not list on the basket campaigns");
    }

    @Then("I check created coupon IsSelected value is {string}")
    public void i_check_created_coupon_is_selected_value_is(String isSelected) {
        List<Coupon> couponList = getBasketCouponList();
        boolean actualIsSelected = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getIsSelected();
        if (isSelected.equalsIgnoreCase("True")) {
            assertTrue(actualIsSelected, "Coupon is selected should be true");
        } else {
            assertTrue(!actualIsSelected, "Coupon is selected should be false");
        }
    }

    @Then("Staff delete created campaign in marketing")
    public void staff_delete_created_campaign_in_marketing() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Staff delete created tag in tagging  createdUserId {string},createdUserName {string}")
    public void staff_delete_created_tag_in_tagging(String createdUserId, String createdUserName) {
        String createdTagId = getScenarioContext().getContext(Context.CREATED_TAG_ID).toString();
      Response response = getInternalTaggingClient().deleteUserTag(createdTagId, createdUserId, createdUserName);
      assertTrue(response.statusCode() == 200,"Delete tag should be 200");

    }

}
