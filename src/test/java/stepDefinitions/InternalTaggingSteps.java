package stepDefinitions;

import apiEngine.Utilies.DateUtil;
import apiEngine.Utilies.GenerateFakeData;
import apiEngine.Utilies.Utils;
import apiEngine.models.requests.InternalVendor.Tagging.TagRequest;
import apiEngine.models.response.MahalleVendor;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class InternalTaggingSteps extends BaseSteps {
    public InternalTaggingSteps(TestContext testContext) {
        super(testContext);
    }

    @When("Staff define users for tag creation$")
    public void staff_define_users_for_tag_creating(List<String> userIdList) {
        getScenarioContext().setContext(Context.TAG_USER_LIST, userIdList);
    }
    
    @When("Staff define vendors for tag creation$")
    public void staff_define_vendor_list_for_tagging(List<String> vendorIdList){
        getScenarioContext().setContext(Context.TAG_VENDOR_LIST, vendorIdList);
    }

    private String getSelectedVendorId(String vendorName){
        List<MahalleVendor> vendorList = (List<MahalleVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        int index = -1;
        for (MahalleVendor vendor : vendorList){
            if (vendor.getName().equalsIgnoreCase(vendorName)){
                index = vendorList.indexOf(vendor);
            }
        }
        return vendorList.get(index).getId();
    }


    @When("Staff define vendor id list with home index for tag creation {string}")
    public void staff_define_vendor_for_tag_creating(String vendorName) throws IOException {
        String vendor = Utils.getGlobalValue(vendorName);
        String vendorId = getSelectedVendorId(vendor);
        getScenarioContext().setContext(Context.SELECTED_VENDOR_ID_FOR_CAMPAIGN, vendorId);
    }


    @Then("Staff create user tag name {string}, description {string}, createdUserId {string}," +
            "createdUserName {string}, endDate")
    public void staff_select_user_tag_name_description_created_user_id_created_user_name_end_date(String tagName,
                                                                                                  String description,
                                                                                                  String createdUserId,
                                                                                                  String createdUserName) throws IOException {
        String randomTagName = tagName + "-" + GenerateFakeData.getRandomNameWithNumbers();
        List<String> details = (List<String>) getScenarioContext().getContext(Context.TAG_USER_LIST);
        String endDate = DateUtil.getTimeAfterHour(2);

        TagRequest tagRequest = new TagRequest(randomTagName, description, createdUserId, createdUserName,
                endDate, details);

        Response response = getInternalTaggingClient().createUserTag(tagRequest);
        String tagId = response.getBody().asString();
        getScenarioContext().setContext(Context.CREATED_USER_TAG_ID, tagId);
        assertTrue(response.statusCode() == 200, "Tag create response should be 200");
    }

    @Then("Staff create vendor tag name {string}, description {string}, createdUserId {string}," +
            "createdUserName {string}, endDate")
    public void staff_select_vendor_tag_name_description_created_user_id_created_user_name_end_date(String tagName,
                                                                                                  String description,
                                                                                                  String createdUserId,
                                                                                                  String createdUserName) throws IOException {
        String randomTagName = tagName + "-" + GenerateFakeData.getRandomNameWithNumbers();
        List<String> details = (List<String>) getScenarioContext().getContext(Context.TAG_VENDOR_LIST);
        String endDate = DateUtil.getTimeAfterHour(2);

        TagRequest tagRequest = new TagRequest(randomTagName, description, createdUserId, createdUserName,
                endDate, details);

        Response response = getInternalTaggingClient().createVendorTag(tagRequest);
        String tagId = response.getBody().asString();
        getScenarioContext().setContext(Context.CREATED_VENDOR_TAG_ID, tagId);
        assertTrue(response.statusCode() == 200, "Tag create response should be 200");
    }

    @Then("Staff delete created user tag in tagging createdUserId {string},createdUserName {string}")
    public void staff_delete_created_user_tag_in_tagging(String createdUserId, String createdUserName) {
        String createdTagId = getScenarioContext().getContext(Context.CREATED_USER_TAG_ID).toString();
        Response response = getInternalTaggingClient().deleteUserTag(createdTagId, createdUserId, createdUserName);
        assertTrue(response.statusCode() == 200, "Delete tag should be 200");
    }

    @Then("Staff delete created vendor tag in tagging createdUserId {string},createdUserName {string}")
    public void staff_delete_created_vendor_tag_in_tagging(String createdUserId, String createdUserName) {
        String createdTagId = getScenarioContext().getContext(Context.CREATED_USER_TAG_ID).toString();
        Response response = getInternalTaggingClient().deleteVendorTag(createdTagId, createdUserId, createdUserName);
        assertTrue(response.statusCode() == 200, "Delete tag should be 200");

    }

}



