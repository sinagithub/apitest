package stepDefinitions;

import apiEngine.models.response.Content.FaqData;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ContentSteps extends BaseSteps{
    
    private List<FaqData> getFaqDataList(){
        return (List<FaqData>) getScenarioContext().getContext(Context.GET_CONTENT_LIST);
    }

    private FaqData getSelectedFaqData(){
        return (FaqData) getScenarioContext().getContext(Context.SELECTED_CONTENT_DATA);
    }

    public ContentSteps(TestContext testContext) {
        super(testContext);
    }
    @When("I can list Faq content")
    public void i_can_list_faq_content() {
        List<FaqData> getFaqContentList = getCarsiContentClient().getFaqResponse().getBody().getData();
        getScenarioContext().setContext(Context.GET_CONTENT_LIST, getFaqContentList);
    }

    @Then("I select operation guide with id {string}")
    public void i_select_operation_guide_with_id(String expectedId) {
        FaqData selectedFaqData = new FaqData();
        List<FaqData> getFaqContentList = getFaqDataList();
        for (FaqData faqData : getFaqContentList){
            if (faqData.getId().equalsIgnoreCase(expectedId)){
                selectedFaqData = faqData;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_CONTENT_DATA, selectedFaqData);
    }

    @Then("I can validate selected operation guide text is {string}")
    public void i_can_validate_selected_operation_guide_text_is(String expectedText) {
       String actualSelectedFaqData = getSelectedFaqData().getText();
       assertEqual("Content text should be valid : " ,actualSelectedFaqData,expectedText);
    }

    @Then("I can validate selected operation guide header is {string}")
    public void i_can_validate_operation_guide_title_is(String expectedHeader) {
        String actualHeader = getSelectedFaqData().getHeader();
        assertEqual("Content header should be valid : " ,actualHeader,expectedHeader);
    }

    @Then("I can validate selected operation guide is active {string}")
    public void i_can_validate_operation_guide_is_active(String contentStatus) {
        Boolean actualContentStatus = getSelectedFaqData().getIsActive();
        if (contentStatus.equalsIgnoreCase("True")){
            assertTrue(actualContentStatus, "Content status should be true");

        }
        else {
            assertTrue(!actualContentStatus, "Content status should be false");
        }

    }
}
