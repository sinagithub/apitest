package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.Utilies.DateUtil;
import apiEngine.Utilies.GenerateFakeData;
import apiEngine.models.requests.InternalVendor.Marketing.*;
import apiEngine.models.response.MicroServices.InternalMarketing.CreateCampaignResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
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
        Campaign campaign = new Campaign(randomName, usageLimit,otpSelection,isOneTimePerUserSelection,isCouponRequiredSelection,isShownOnCheckoutSelection, dateNow,dateEnd );
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
        definedCampaignInfo.put("AwardTypeId", typeId);
        definedCampaignInfo.put("DiscountTypeId", discountTypeId);
        definedCampaignInfo.put("DiscountValue", discountValue);
        definedCampaignInfo.put("MaxDiscountValue", maxDiscountValue);
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
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        String createdTagId = getScenarioContext().getContext(Context.CREATED_TAG_ID).toString();
        int targetTagType = 4;
        Target target = new Target(createdTagId, targetTagType);
        List<Target> targetList = new ArrayList<>();
        targetList.add(target);

        definedCampaignInfo.put("TargetList", targetList);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Coupon with CreateCoupon {string}, CouponCount {int}, prefixSuffix {int}, " +
            "ConstantCode {string}, UsageLimit" +
            " {int}, couponCode {string}")
    public void staff_select_campaign_coupon_with_create_coupon_coupon_count_prefix_suffix_usage_limit_coupon_code(String createCoupon,
                                                                                                                   Integer couponCount, Integer prefixSuffix, String constantCode, Integer usageLimit, String couponCode) throws IOException {
        String randomCouponCode = couponCode + "--" + GenerateFakeData.getRandomNameWithNumbers();
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        boolean createCouponStatus = false;
        if (createCoupon.equalsIgnoreCase("True")) {
            createCouponStatus = true;
        }

        Coupon coupon = new Coupon(createCouponStatus, prefixSuffix, constantCode, couponCount, usageLimit,
                randomCouponCode);
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

    private Award getSelectedCampaignAward() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        int typeId = (int) definedCampaignInfo.get("AwardTypeId");
        int discountTypeId = (int) definedCampaignInfo.get("DiscountTypeId");
        int discountValue = (int) definedCampaignInfo.get("DiscountValue");
        int maxDiscountValue = (int) definedCampaignInfo.get("MaxDiscountValue");
        return new Award(typeId, discountTypeId, discountValue, maxDiscountValue);
    }


    @Then("Staff create campaign in marketing with selected campaign info operation User email {string}")
    public void staff_create_campaign_in_marketing(String operationUserMail) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();

        Campaign campaign = (Campaign) definedCampaignInfo.get("Campaign");
        DescriptionTr descriptionTr = getSelectedCampaignDescriptionTr();
        DescriptionEn descriptionEn = getSelectedCampaignDescriptionEn();
        Award award = getSelectedCampaignAward();
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

    @Then("Staff activate created campaign in marketing operation User email {string}")
    public void staff_activate_created_campaign_in_marketing(String operationEmail) {
        Response response = getInternalMarketingClient().activateCampaign(getCreatedCampaignId(), operationEmail);
        assertTrue(response.statusCode() == 200, "Campaign activate should be 200");
    }


}



