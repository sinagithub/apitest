package stepDefinitions;

import apiEngine.Utilies.DateUtil;
import apiEngine.Utilies.GenerateFakeData;
import apiEngine.models.requests.InternalVendor.Tagging.UserTagRequest;
import apiEngine.models.response.CarsiVendor;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
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

    @When("Staff define vendor id list with home index for tag creation {int}")
    public void staff_define_vendor_for_tag_creating(int index) {
        List<CarsiVendor> vendorList = (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        List<String> vendorIdList = new ArrayList<>();
        vendorIdList.add(vendorList.get(index).getId());
        getScenarioContext().setContext(Context.TAG_VENDOR, vendorIdList);
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

        UserTagRequest userTagRequest = new UserTagRequest(randomTagName, description, createdUserId, createdUserName,
                endDate, details);

        Response response = getInternalTaggingClient().createUserTag(userTagRequest);
        String tagId = response.getBody().asString();
        getScenarioContext().setContext(Context.CREATED_TAG_ID, tagId);
        assertTrue(response.statusCode() == 200, "Tag create response should be 200");
    }

    @Then("Staff delete created tag in tagging createdUserId {string},createdUserName {string}")
    public void staff_delete_created_tag_in_tagging(String createdUserId, String createdUserName) {
        String createdTagId = getScenarioContext().getContext(Context.CREATED_TAG_ID).toString();
        Response response = getInternalTaggingClient().deleteUserTag(createdTagId, createdUserId, createdUserName);
        assertTrue(response.statusCode() == 200, "Delete tag should be 200");

    }

}



