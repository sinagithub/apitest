package stepDefinitions;

import apiEngine.Utilies.DateUtil;
import apiEngine.Utilies.GenerateFakeData;
import apiEngine.models.requests.InternalVendor.Tagging.UserTagRequest;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SuppressWarnings("unchecked")
public class InternalTaggingSteps extends BaseSteps {
    public InternalTaggingSteps(TestContext testContext) {
        super(testContext);
    }

    @When("Staff define users for tag creation$")
    public void staff_define_users_for_tag_creating(List<String> userIdList) {
        getScenarioContext().setContext(Context.TAG_USER_USER_LIST, userIdList);
    }


    @Then("Staff create user tag name {string}, description {string}, createdUserId {string}," +
            "createdUserName {string}, endDate")
    public void staff_select_user_tag_name_description_created_user_id_created_user_name_end_date(String tagName,
                                                                                                  String description,
                                                                                                  String createdUserId,
                                                                                                  String createdUserName) throws IOException {
        String randomTagName = tagName + "-" + GenerateFakeData.getRandomNameWithNumbers();
        List<String> userIdList = (List<String>) getScenarioContext().getContext(Context.TAG_USER_USER_LIST);
        String endDate = DateUtil.getTimeAfterHour(2);
        UserTagRequest userTagRequest = new UserTagRequest(randomTagName, description, createdUserId, createdUserName,
                endDate, userIdList);
        Response response = getInternalTaggingClient().setUserTag(userTagRequest);
        String tagId = response.getBody().asString();
        getScenarioContext().setContext(Context.CREATED_TAG_ID, tagId);
    }

}



