package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.Utilies.DateUtil;
import apiEngine.Utilies.GenerateFakeData;
import apiEngine.models.requests.Campaign.CreateCompensationRequest;
import apiEngine.models.requests.Campaign.UpdateCampaignRequest;
import apiEngine.models.requests.InternalVendor.Marketing.*;
import apiEngine.models.response.MicroServices.InternalMarketing.CreateCampaignResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class InternalCampaignSteps extends BaseSteps {
    public InternalCampaignSteps(TestContext testContext) {
        super(testContext);
    }

    private HashMap getDefinedCampaignInfo() {
        return (HashMap) getScenarioContext().getContext(Context.DEFINATED_CAMPAIGN);
    }

    private void updateDefinedCampaignInfoFromContext(HashMap definedCampaignInfo) {
        getScenarioContext().setContext(Context.DEFINATED_CAMPAIGN, definedCampaignInfo);
    }

    private String getCreatedCampaignId() {
        return (String) getScenarioContext().getContext(Context.CREATED_CAMPAIGN_ID);
    }

    @Then("Staff select Campaign with Name {string}, UsageLimit {int}, IsOtpRequired {string}, IsOneTimePerUser " +
            "{string}, IsCouponRequired {string}, IsShownOnCheckout {string}, StartDate, EndDate")
    public void staff_select_campaign_with_name_usage_limit_is_otp_required_is_one_time_per_user_is_coupon_required_is_shown_on_checkout_start_date_end_date(String name, Integer usageLimit, String isOtpRequired, String isOneTimePerUser, String isCouponRequired, String isShownOnCheckout) throws IOException {
        String randomName = name + "--" + GenerateFakeData.getRandomNameWithNumbers();
        HashMap definedCampaignInfo = new HashMap();
        definedCampaignInfo.put("CampaignName", randomName);
        definedCampaignInfo.put("UsageLimit", usageLimit);
        boolean otpSelection = false;
        if (isOtpRequired.contains("true")) {
            otpSelection = true;
        }
        boolean isOneTimePerUserSelection = false;
        if (isOneTimePerUser.contains("true")) {
            isOneTimePerUserSelection = true;
        }
        boolean isCouponRequiredSelection = false;
        if (isCouponRequired.contains("true")) {
            isCouponRequiredSelection = true;
        }
        boolean isShownOnCheckoutSelection = false;
        if (isShownOnCheckout.contains("true")) {
            isShownOnCheckoutSelection = true;
        }
        String dateNow = DateUtil.generateDateNow();
        String dateEnd = DateUtil.getNextDay(1);
        Campaign campaign = new Campaign(randomName, usageLimit, otpSelection, isOneTimePerUserSelection,
                isCouponRequiredSelection, isShownOnCheckoutSelection, dateNow, dateEnd);
        definedCampaignInfo.put("Campaign", campaign);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Award with TypeId {int}, DiscountTypeId {int}, DiscountValue {int}, MaxDiscountValue" +
            " {int}")
    public void staff_select_campaign_award_with_type_id_discount_type_id_discount_value(Integer typeId,
                                                                                         Integer discountTypeId,
                                                                                         Integer discountValue,
                                                                                         Integer maxDiscountValue) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        Award award = new Award(typeId, discountTypeId, discountValue, maxDiscountValue);
        definedCampaignInfo.put("Award", award);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign DescriptionTr with Title {string}, Description {string}, ImageUrl {string}")
    public void staff_select_campaign_description_tr_with_title_description_image_url(String title, String description,
                                                                                      String imageUrl) throws IOException {
        String randomTitle = title + "--" + GenerateFakeData.getRandomNameWithNumbers();
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        DescriptionTr descriptionTr = new DescriptionTr(randomTitle, description, imageUrl);
        DescriptionEn descriptionEn = new DescriptionEn(randomTitle, description, imageUrl);
        definedCampaignInfo.put("DescriptionTr", descriptionTr);
        definedCampaignInfo.put("DescriptionEn", descriptionEn);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Conditions with TypeId {int}, OperatorTypeId {int}, Value {string}")
    public void staff_select_campaign_conditions_with_type_id_operator_type_id_value(Integer conditionTypeId,
                                                                                     Integer operatorTypeId,
                                                                                     String value) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        Condition condition = new Condition(conditionTypeId, operatorTypeId, value);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(condition);
        definedCampaignInfo.put("Conditions", conditions);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign target TypeId for created user tag")
    public void staff_select_campaign_targets_with_type_id_target_id() {
        String createdTagId = getScenarioContext().getContext(Context.CREATED_TAG_ID).toString();
        int targetType = 4;
        Target target = new Target(createdTagId, targetType);
        List<Target> targetList = (List<Target>) getScenarioContext().getContext(Context.TARGET_LIST);
        targetList.add(target);
        getScenarioContext().setContext(Context.TARGET_LIST, targetList);
    }

    @Given("Staff select campaign target TypeId for all users")
    public void staff_select_campaign_target_type_id_for_all_users() {
        int targetType = 1;
        Target targetAllUser = new Target(null, targetType);
        List<Target> targetList = (List<Target>) getScenarioContext().getContext(Context.TARGET_LIST);
        targetList.add(targetAllUser);
        getScenarioContext().setContext(Context.TARGET_LIST, targetList);
    }

    @Then("Staff create target poll")
    public void staff_create_target_poll() {
        List<Target> targetList = new ArrayList<>();
        getScenarioContext().setContext(Context.TARGET_LIST, targetList);
    }

    @Then("Staff set selected targets")
    public void staff_set_selected_target() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        List<Target> targetList = (List<Target>) getScenarioContext().getContext(Context.TARGET_LIST);
        definedCampaignInfo.put("TargetList", targetList);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign target TypeId of defined Vendor index")
    public void staff_select_campaign_target_type_id_of_selected_vendor() {
        String targetVendorId =
                getScenarioContext().getContext(Context.TAG_VENDOR).toString().replace("[", "").replace("]", "");
        int targetType = 2;
        List<Target> targetList = (List<Target>) getScenarioContext().getContext(Context.TARGET_LIST);
        Target target = new Target(targetVendorId, targetType);
        targetList.add(target);
        getScenarioContext().setContext(Context.TARGET_LIST, targetList);
    }

    @Then("Staff select campaign Coupon with CreateCoupon false, CouponCount {int}, prefixSuffix 0, UsageLimit {int}," +
            " " +
            "couponCode {string}")
    public void staff_select_campaign_coupon_with_create_coupon_coupon_count_prefix_suffix_usage_limit_coupon_code(
            Integer couponCount, Integer usageLimit, String couponCode) throws IOException {
        String randomCouponCode = couponCode + "--" + GenerateFakeData.getRandomNameWithNumbers();
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        Coupon coupon = new Coupon(false, null, null, couponCount, usageLimit,
                randomCouponCode);
        definedCampaignInfo.put("Coupon", coupon);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Coupon with CreateCoupon true, CouponCount {int}, UsageLimit {int}, prefixSuffix " +
            "{int}, constantCode {string}")
    public void staff_select_campaign_coupon_with_create_coupon_coupon_count_usage_limit_prefix_suffix_constant_code(Integer couponCount, Integer usageLimit, Integer prefixSuffix, String constantCode) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        boolean createCouponStatus = true;
        Coupon coupon = new Coupon(createCouponStatus, prefixSuffix, constantCode, couponCount, usageLimit,
                null);

        definedCampaignInfo.put("Coupon", coupon);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select  StateInfo {string}")
    public void staff_select_state_info(String stateInfo) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        definedCampaignInfo.put("StateInfo", stateInfo);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    private DescriptionTr getSelectedCampaignDescriptionTr() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        return (DescriptionTr) definedCampaignInfo.get("DescriptionTr");
    }

    private DescriptionEn getSelectedCampaignDescriptionEn() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        return (DescriptionEn) definedCampaignInfo.get("DescriptionEn");
    }

    @Then("Staff create campaign in marketing with selected campaign info operation User email {string}")
    public void staff_create_campaign_in_marketing(String operationUserMail) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();

        Campaign campaign = (Campaign) definedCampaignInfo.get("Campaign");
        DescriptionTr descriptionTr = getSelectedCampaignDescriptionTr();
        DescriptionEn descriptionEn = getSelectedCampaignDescriptionEn();
        Award award = (Award) getDefinedCampaignInfo().get("Award");
        List<Condition> conditionList = (List<Condition>) getDefinedCampaignInfo().get("Conditions");
        List<Target> targetList = (List<Target>) definedCampaignInfo.get("TargetList");
        Coupon coupon = (Coupon) definedCampaignInfo.get("Coupon");
        String stateInfo = (String) definedCampaignInfo.get("StateInfo");

        PostCampaignRequest postCampaignRequest = new PostCampaignRequest(campaign, descriptionTr, descriptionEn,
                award, conditionList, targetList, coupon, stateInfo);
        IRestResponse<CreateCampaignResponse> campaignResponse =
                getInternalMarketingClient().createCampaign(postCampaignRequest, operationUserMail);
        assertTrue(campaignResponse.isSuccessful(), "Create campaign status should be true");
        String campaignId = campaignResponse.getBody().getCampaignId();
        getScenarioContext().setContext(Context.CREATED_CAMPAIGN_ID, campaignId);
    }

    @Then("Staff delete created campaign in marketing")
    public void staff_delete_created_campaign_in_marketing() {
        String campaignId = getCreatedCampaignId();
        getInternalMarketingClient().deleteCampaign(campaignId);
    }

    @Then("Staff activate created campaign in marketing operation User email {string}")
    public void staff_activate_created_campaign_in_marketing(String operationEmail) {
        Response response = getInternalMarketingClient().activateCampaign(getCreatedCampaignId(), operationEmail);
        assertTrue(response.statusCode() == 200, "Campaign activate should be 200");
    }

    @When("Staff convert campaign to compensation coupon campaign in marketing")
    public void staff_convert_campaign_to_compensation_coupon_campaign_in_marketing() {
        String campaignId = getCreatedCampaignId();
        int compensationStatus = 6;
        UpdateCampaignRequest updateCampaignRequest = new UpdateCampaignRequest(compensationStatus,null,null);
        getInternalMarketingClient().updateCampaign(campaignId,"automation@gmail.com",updateCampaignRequest);
    }
    @When("Staff create compensation coupon for user id {string} whose endDate is next {int} day in marketing")
    public void staff_create_compensation_coupon_for_user_in_marketing(String userId, Integer nextDayValue) {
        String campaignId = getCreatedCampaignId();
        String endDate = DateUtil.getNextDay(nextDayValue);
        CreateCompensationRequest createCompensationRequest = new CreateCompensationRequest(campaignId,userId,endDate);
        Response response = getInternalMarketingClient().createCompensation(createCompensationRequest);
        assertTrue(response.statusCode() == 200, "Create compensation status should be 200");
    }

    @When("Staff get created compensation campaign coupon id in marketing")
    public void staff_get_created_compensation_campaign_coupon_id_in_marketing() {
        String campaignId = getCreatedCampaignId();

    }

}



