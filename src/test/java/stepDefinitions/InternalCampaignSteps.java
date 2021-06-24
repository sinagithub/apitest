package stepDefinitions;

import apiEngine.Utilies.DateUtil;
import apiEngine.models.requests.InternalVendor.Marketing.*;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
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

    @Then("Staff select Campaign with Name {string}, UsageLimit {int}, IsOtpRequired {string}, IsOneTimePerUser " +
            "{string}, IsCouponRequired {string}, IsShownOnCheckout {string}, StartDate, EndDate")
    public void staff_select_campaign_with_name_usage_limit_is_otp_required_is_one_time_per_user_is_coupon_required_is_shown_on_checkout_start_date_end_date(String name, Integer usageLimit, String isOtpRequired, String isOneTimePerUser, String isCouponRequired, String isShownOnCheckout) {
        HashMap definedCampaignInfo = new HashMap();
        definedCampaignInfo.put("CampaignName", name);
        definedCampaignInfo.put("UsageLimit", usageLimit);

        if (isOtpRequired.contains("true")) {
            definedCampaignInfo.put("IsOtpRequired", true);
        } else {
            definedCampaignInfo.put("IsOtpRequired", false);
        }

        if (isOneTimePerUser.contains("true")) {
            definedCampaignInfo.put("IsOneTimePerUser", true);
        } else {
            definedCampaignInfo.put("IsOneTimePerUser", false);
        }

        if (isCouponRequired.contains("true")) {
            definedCampaignInfo.put("IsCouponRequired", true);
        } else {
            definedCampaignInfo.put("IsCouponRequired", false);
        }

        if (isShownOnCheckout.contains("true")) {
            definedCampaignInfo.put("IsShownOnCheckout", true);
        } else {
            definedCampaignInfo.put("IsShownOnCheckout", false);
        }
        String dateNow = DateUtil.generateDateNow();
        String dateEnd = DateUtil.getTimeAfterHour(2);

        definedCampaignInfo.put("StartDate", dateNow);
        definedCampaignInfo.put("EndDate", dateEnd);

        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Award with TypeId {int}, DiscountTypeId {int}, DiscountValue {int}, MaxDiscountValue {int}")
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
                                                                                      String imageUrl) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        DescriptionTr descriptionTr = new DescriptionTr(title,description,imageUrl);
        DescriptionEn descriptionEn = new DescriptionEn(title,description,imageUrl);
        definedCampaignInfo.put("DescriptionTr", descriptionTr);
        definedCampaignInfo.put("DescriptionEn", descriptionEn);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Conditions with TypeId {int}, OperatorTypeId {int}, Value {string}")
    public void staff_select_campaign_conditions_with_type_id_operator_type_id_value(Integer conditionTypeId,
                                                                                     Integer operatorTypeId,
                                                                                     String value) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        Condition condition = new Condition(conditionTypeId,operatorTypeId,value);
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
        Target target = new Target(createdTagId,targetTagType);
        List<Target> targetList = new ArrayList<>();
        targetList.add(target);

        definedCampaignInfo.put("TargetList", targetList);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select campaign Coupon with CreateCoupon {string}, CouponCount {int}, prefixSuffix {int}, ConstantCode {string}, UsageLimit" +
            " {int}, couponCode {string}")
    public void staff_select_campaign_coupon_with_create_coupon_coupon_count_prefix_suffix_usage_limit_coupon_code(String createCoupon,
                                                                                                                   Integer couponCount, Integer prefixSuffix, String constantCode, Integer usageLimit, String couponCode) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        boolean createCouponStatus = false;
        if (couponCode.equalsIgnoreCase("True")){
            createCouponStatus = true;
        }

        Coupon coupon = new Coupon(createCouponStatus,prefixSuffix,constantCode,couponCount,usageLimit,couponCode);
        definedCampaignInfo.put("Coupon", coupon);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    @Then("Staff select  StateInfo {string}")
    public void staff_select_state_info(String stateInfo) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        definedCampaignInfo.put("StateInfo", stateInfo);
        updateDefinedCampaignInfoFromContext(definedCampaignInfo);
    }

    private Campaign getSelectedCampaign() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        String name = definedCampaignInfo.get("CampaignName").toString();
        int usageLimit = (Integer) definedCampaignInfo.get("UsageLimit");
        boolean isOtpRequired = (Boolean) definedCampaignInfo.get("IsOtpRequired");
        boolean isOneTimePerUser = (Boolean) definedCampaignInfo.get("IsOneTimePerUser");
        boolean isCouponRequired = (Boolean) definedCampaignInfo.get("IsCouponRequired");
        boolean isShownOnCheckout = (Boolean) definedCampaignInfo.get("IsShownOnCheckout");
        String startDate = (String) definedCampaignInfo.get("StartDate");
        String endDate = (String) definedCampaignInfo.get("EndDate");

        return new Campaign(name, usageLimit, isOtpRequired, isOneTimePerUser, isCouponRequired, isShownOnCheckout,
                startDate, endDate);
    }

    private DescriptionTr getSelectedCampaignDescriptionTr() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        DescriptionTr descriptionTr = (DescriptionTr) definedCampaignInfo.get("DescriptionTr");
        return descriptionTr;
    }

    private DescriptionEn getSelectedCampaignDescriptionEn() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        DescriptionEn descriptionEn = (DescriptionEn) definedCampaignInfo.get("DescriptionEn");
        return descriptionEn;
    }

    private Award getSelectedCampaignAward() {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();
        int typeId = (int) definedCampaignInfo.get("AwardTypeId");
        int discountTypeId = (int) definedCampaignInfo.get("DiscountTypeId");
        int discountValue = (int) definedCampaignInfo.get("DiscountValue");
        int maxDiscountValue = (int) definedCampaignInfo.get("MaxDiscountValue");
        return new Award(typeId,discountTypeId,discountValue,maxDiscountValue);
    }


    @Then("Staff create campaign in marketing with selected campaign info operation User email {string}")
    public void staff_create_campaign_in_marketing(String operationUserMail) {
        HashMap definedCampaignInfo = getDefinedCampaignInfo();

        Campaign campaign = getSelectedCampaign();
        DescriptionTr descriptionTr = getSelectedCampaignDescriptionTr();
        DescriptionEn descriptionEn = getSelectedCampaignDescriptionEn();
        Award award = getSelectedCampaignAward();
        List<Condition> conditionList = (List<Condition>) getDefinedCampaignInfo().get("Conditions");
        List<Target> targetList = (List<Target>) definedCampaignInfo.get("TargetList");
        Coupon coupon =(Coupon) definedCampaignInfo.get("Coupon");
        String stateInfo = (String) definedCampaignInfo.get("StateInfo");

        PostCampaignRequest postCampaignRequest = new PostCampaignRequest(campaign, descriptionTr, descriptionEn,award,conditionList,targetList,coupon,stateInfo);
        getInternalMarketingClient().createCampaign(postCampaignRequest,operationUserMail);

    }

    @Then("Staff activate created campaign in marketing")
    public void staff_activate_created_campaign_in_marketing() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Staff get created campaign coupon id in marketing")
    public void staff_get_created_campaign_coupon_id_in_marketing() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}



