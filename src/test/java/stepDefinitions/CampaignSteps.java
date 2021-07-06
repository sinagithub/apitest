package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.JsonUtil;
import apiEngine.models.requests.Campaign.ApplyCampaignRequest;
import apiEngine.models.requests.Campaign.ApplyCouponRequest;
import apiEngine.models.requests.InternalVendor.Marketing.Campaign;
import apiEngine.models.requests.InternalVendor.Marketing.DescriptionEn;
import apiEngine.models.requests.InternalVendor.Marketing.DescriptionTr;
import apiEngine.models.response.Basket.BasketResponse;
import apiEngine.models.response.Basket.Campaign.ApplyCampaignResponse;
import apiEngine.models.response.Basket.Campaign.ApplyCouponResponse;
import apiEngine.models.response.Basket.Campaign.Coupon;
import apiEngine.models.response.Basket.Campaign.DeleteCouponResponse;
import apiEngine.models.response.Campaign.CampaignCouponsResponse;
import apiEngine.models.response.Campaign.CampaignsData;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SuppressWarnings("unchecked")
public class CampaignSteps extends BaseSteps {

    public CampaignSteps(TestContext testContext) {
        super(testContext);
    }

    private String getBasketId() {
        return (String) getScenarioContext().getContext(Context.BASKET_ID);
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
        String selectedCampaignName = getSelectedCampaignDescriptionTr().getTitle();
        int selectedCouponIndex = -1;
        for (Coupon coupon : couponList) {
            if (coupon.getName().equalsIgnoreCase(selectedCampaignName)) {
                selectedCouponIndex = couponList.indexOf(coupon);
                break;
            }
        }
        return selectedCouponIndex;
    }

    @Then("I get compensation coupon code with created campaign id")
    public void i_get_compensation_coupon_code_with_created_campaign_id() {
        String createdCampaignId = getCreatedCampaignId();
        apiEngine.models.requests.InternalVendor.Marketing.Coupon couponInfo =
                (apiEngine.models.requests.InternalVendor.Marketing.Coupon) getDefinedCampaignInfo().get("Coupon");
        String couponCode = couponInfo.getCouponCode();

        Response response = getInternalMarketingClient().getCampaignDetail(createdCampaignId);
        String code = JsonUtil.getJsonElement(response, "Code").replace("[", "").replace("]", "");
        ;
        String[] codes = code.split(",");
        int index = -1;
        for (String c : codes) {
            if (!c.contains(couponCode)) {
                index = Arrays.asList(codes).lastIndexOf(c);
                break;
            }
        }
        String convertedCoupon = codes[index];
        getScenarioContext().setContext(Context.CREATED_COUPON_CODE, convertedCoupon.replace(" ", ""));
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

    @Then("I validate created coupon is not listed in basket response")
    public void i_validate_created_coupon_is_not_listed_in_basket_response() {
        assertTrue(getCreatedCouponIndexFromBasketCoupons() == -1,
                "Created Coupon should not be on the basket coupons");
    }

    @Then("I validate coupon image url is valid in basket response")
    public void i_validate_coupon_image_url_is_valid_in_basket_response() {
        List<Coupon> couponList = getBasketCouponList();
        String actualImageUrl = couponList.get(getCreatedCouponIndexFromBasketCoupons()).getImageUrl();
        String expectedImageUrl = getSelectedCampaignDescriptionTr().getImageUrl();
        assertEqual("Image url should be match on basket coupons", actualImageUrl, expectedImageUrl);
    }

    @Then("I validate coupon name is valid in basket response")
    public void i_validate_coupon_name_is_valid_in_basket_response() {
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

    @Then("I validate created coupon IsSelected value is {string}")
    public void i_check_created_coupon_is_selected_value_is(String isSelected) {
        List<Coupon> couponList = getBasketCouponList();
        int selectedCouponIndex = getCreatedCouponIndexFromBasketCoupons();
        if (selectedCouponIndex == -1) {
            Assert.fail("Coupon not on the basket coupon list");
        }
        boolean actualIsSelected = couponList.get(selectedCouponIndex).getIsSelected();
        if (isSelected.equalsIgnoreCase("True")) {
            assertTrue(actualIsSelected, "Coupon is selected should be true");
        } else {
            assertTrue(!actualIsSelected, "Coupon is selected should be false");
        }
    }

    private String getCreatedCampaignId() {
        return (String) getScenarioContext().getContext(Context.CREATED_CAMPAIGN_ID);
    }

    @Then("I get coupon code with created campaign id")
    public void i_get_coupon_code_with_created_campaign_id() {
        String createdCampaignId = getCreatedCampaignId();

        Response response = getInternalMarketingClient().getCampaignDetail(createdCampaignId);
        String code = JsonUtil.getJsonElement(response, "Code").replace("[", "").replace("]", "");

        getScenarioContext().setContext(Context.CREATED_COUPON_CODE, code);
    }

    @Then("I add created coupon to basket PaymentMethodId is {string}, UserHasOtpValidation is {string}")
    public void i_add_created_coupon_to_basket_payment_method_id_is_user_has_otp_validation_is(String paymentMethodId
            , String userHasOtpValidation) {
        i_get_coupon_code_with_created_campaign_id();
        String basketId = getBasketId();
        String couponCode = (String) getScenarioContext().getContext(Context.CREATED_COUPON_CODE);
        boolean hasOtp = false;
        if (userHasOtpValidation.equalsIgnoreCase("True")) {
            hasOtp = true;
        }
        ApplyCouponRequest applyCouponRequest = new ApplyCouponRequest(couponCode, null, hasOtp);
        IRestResponse<ApplyCouponResponse> applyCouponResponse =
                getCarsiBasketClient().applyCoupon(applyCouponRequest, basketId);
        getScenarioContext().setContext(Context.APPLY_COUPON_RESPONSE, applyCouponResponse);
    }

    @Then("I add created compensation coupon to basket PaymentMethodId is {string}, UserHasOtpValidation is {string}")
    public void i_add_compensation_created_coupon_to_basket_payment_method_id_is_user_has_otp_validation_is(String paymentMethodId
            , String userHasOtpValidation) {
        i_get_compensation_coupon_code_with_created_campaign_id();
        String basketId = getBasketId();
        String couponCode = (String) getScenarioContext().getContext(Context.CREATED_COUPON_CODE);
        boolean hasOtp = false;
        if (userHasOtpValidation.equalsIgnoreCase("True")) {
            hasOtp = true;
        }
        ApplyCouponRequest applyCouponRequest = new ApplyCouponRequest(couponCode, null, hasOtp);
        IRestResponse<ApplyCouponResponse> applyCouponResponse =
                getCarsiBasketClient().applyCoupon(applyCouponRequest, basketId);
        getScenarioContext().setContext(Context.APPLY_COUPON_RESPONSE, applyCouponResponse);
        assertTrue(applyCouponResponse.isSuccessful(), "Apply coupon should be 200");
    }

    @Then("I validate apply coupon status is {int} and message is {string}")
    public void i_validate_apply_coupon_status_is(int status, String message) {
        IRestResponse<ApplyCouponResponse> applyCouponResponse =
                (IRestResponse<ApplyCouponResponse>) getScenarioContext().getContext(Context.APPLY_COUPON_RESPONSE);
        int actualStatus = applyCouponResponse.getStatusCode();
        assertTrue(actualStatus == status, "Apply coupon status should " + status + " not " + actualStatus);

        if (status == 400) {
            String actualMessage = applyCouponResponse.getBody().getInfoList().get(0).getMessage();
            assertEqual("Error message should be match", actualMessage, message);
        }
    }

    @Then("I validate calculated SubTotal value for DiscountType is FixedDiscount and AwardType is SubTotal in basket")
    public void i_validate_calculated_sub_total_value_for_discount_type_is_fixed_discount_and_award_type_is_sub_total_in_basket() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I validate apply campaign status is {int} and message is {string}")
    public void i_validate_apply_campaign_status_is(int status, String message) {
        IRestResponse<ApplyCampaignResponse> applyCampaignResponse =
                (IRestResponse<ApplyCampaignResponse>) getScenarioContext().getContext(Context.APPLY_CAMPAIGN_RESPONSE);
        int actualStatus = applyCampaignResponse.getStatusCode();
        assertTrue(actualStatus == status, "Apply campaign status should " + status + " not " + actualStatus);

        if (status == 400 || status == 404) {
            String actualMessage = applyCampaignResponse.getBody().getInfoList().get(0).getMessage();
            assertEqual("Error message should be match", actualMessage, message);
        }
    }

    @Then("I validate calculated Total value for DiscountType is ConstantPrice and AwardType is Basket Total in basket")
    public void i_validate_calculated_total_value_for_discount_type_is_constant_price_and_award_type_is_basket_total_in_basket() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I validate calculated delivery fee value for DiscountType is ConstantPrice and AwardType is Delivery Fee " +
            "in basket")
    public void i_validate_calculated_delivery_fee_value_for_discount_type_is_constant_price_and_award_type_is_delivery_fee_in_basket() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I validate coupon CampaignTitle is {string}, Description is {string}, ImageUrl is {string} is listed in " +
            "campaign coupons response")
    public void i_validate_coupon_is_listed_in_campaign_coupons_response(String campaignTitle,
                                                                         String description,
                                                                         String imageUrl) {
        List<CampaignsData> campaignsList = getCampaignCouponDataList();
        int campaignIndex = -1;
        for (CampaignsData campaign : campaignsList) {
            if (campaign.getCampaignTitle().equalsIgnoreCase(campaignTitle)) {
                campaignIndex = campaignsList.indexOf(campaign);
                break;
            }
        }
        CampaignsData campaign = campaignsList.get(campaignIndex);
        String actualTitle = campaign.getCampaignTitle();
        String actualDescription = campaign.getDescription();
        String actualImageUrl = campaign.getImageUrl();
        assertEqual("Title should be match ", actualTitle, campaignTitle);
        assertEqual("Description should be match ", actualDescription, description);
        assertEqual("actualImageUrl should be match ", actualImageUrl, imageUrl);
    }

    @Then("I validate campaign is not listed campaign title is {string} in basket response")
    public void i_validate_campaign_is_not_listed_campaign_title_is_in_basket_response(String campaignTitle) {
        List<apiEngine.models.response.Basket.Campaign.Campaign> campaignList =
                (List<apiEngine.models.response.Basket.Campaign.Campaign>) getScenarioContext().getContext(Context.BASKET_CAMPAIGN_LIST);
        for (apiEngine.models.response.Basket.Campaign.Campaign campaign : campaignList) {
            if (campaign.getCampaignItem().getTitle().equalsIgnoreCase(campaignTitle)) {
                Assert.fail("Campaign should not be on the basket campaigns");
            }
        }
    }

    @Then("I apply campaign to basket campaign id is {string} hasOtp is {string}")
    public void i_add_campaign_to_basket_campaign_id_is(String campaignId, String hasOtp) {
        boolean hasOtpSelection = Boolean.parseBoolean(hasOtp);
        String basketId = getBasketId();
        ApplyCampaignRequest applyCampaignRequest = new ApplyCampaignRequest(campaignId, null, hasOtpSelection);
        IRestResponse<ApplyCampaignResponse> applyCampaign =
                getCarsiBasketClient().applyCampaign(applyCampaignRequest, basketId);
        getScenarioContext().setContext(Context.APPLY_CAMPAIGN_RESPONSE, applyCampaign);
    }

    @Then("I delete created coupon from basket")
    public void i_delete_created_coupon_from_basket() {
        String basketId = getBasketId();
        i_get_coupon_code_with_created_campaign_id();
        String couponCode = (String) getScenarioContext().getContext(Context.CREATED_COUPON_CODE);
        IRestResponse<DeleteCouponResponse> deleteCouponResponse = getCarsiBasketClient().deleteCoupon(basketId,
                couponCode);
        assertTrue(deleteCouponResponse.isSuccessful(), "Delete coupon response sstatus should be 200");
    }


    @Then("I validate calculated Total value when no campaign applied")
    public void i_validate_calculated_total_value_when_no_campaign_applied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
