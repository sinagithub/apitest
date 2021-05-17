package stepDefinitions;


import apiEngine.GenerateFakeData;
import apiEngine.IRestResponse;
import apiEngine.models.response.Order.GetOrderNoteData;
import apiEngine.models.response.Order.GetOrderNotesResponse;
import apiEngine.models.response.Order.WriteOrderNoteResponse;
import com.sun.org.apache.regexp.internal.RE;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class OrderSteps extends BaseSteps {

    public OrderSteps(TestContext testContext) {
        super(testContext);
    }

    private IRestResponse<GetOrderNotesResponse> getOrderNoteResponse() {
        return getCarsiOrderClient().getOrderNotes();
    }

    private IRestResponse<WriteOrderNoteResponse> writeOrderNote(String note) {
        return getCarsiOrderClient().writeOrderNote(note);
    }

    private IRestResponse<WriteOrderNoteResponse> getAddedOrderNoteResponse() {
        return (IRestResponse<WriteOrderNoteResponse>) getScenarioContext().getContext(Context.WRITE_ORDER_NOTE_RESPONSE);
    }

    @When("I get order notes")
    public void i_get_order_notes() {
        IRestResponse<GetOrderNotesResponse> getOrderNotes = getOrderNoteResponse();
        List<GetOrderNoteData> getOrderNoteDataList = getOrderNotes.getBody().getData();
        getScenarioContext().setContext(Context.GET_ORDER_NOTE_RESPONSE, getOrderNoteResponse());
        getScenarioContext().setContext(Context.GET_ORDER_NOTE_LIST, getOrderNoteDataList);

    }

    @Then("I can validate order note list is empty")
    public void i_can_validate_order_note_list_is_empty() {
        int orderNotesSize = getOrderNoteResponse().getBody().getData().size();
        assertTrue(orderNotesSize == 0, "Order note size should be 0" + " not " + orderNotesSize);
    }

    @Then("I can write order not with upper than max character {int}")
    public void i_can_write_order_not_with_upper_than_max_character_limit_is(int maxCharacterSize) throws IOException {
        String note = GenerateFakeData.getFakeLorem(maxCharacterSize + 1);
        getScenarioContext().setContext(Context.WRITED_NOTE_TEXT, note);
        IRestResponse<WriteOrderNoteResponse> writeOrderNoteResponse = writeOrderNote(note);
        getScenarioContext().setContext(Context.WRITE_ORDER_NOTE_RESPONSE, writeOrderNoteResponse);
    }

    @Then("I can write order note with character count {int}")
    public void i_can_write_order_not_with_than_max_character(int maxCharacterSize) throws IOException {
        String note = GenerateFakeData.getFakeLorem(maxCharacterSize);
        getScenarioContext().setContext(Context.WRITED_NOTE_TEXT, note);
        IRestResponse<WriteOrderNoteResponse> writeOrderNoteResponse = writeOrderNote(note);
        getScenarioContext().setContext(Context.WRITE_ORDER_NOTE_RESPONSE, writeOrderNoteResponse);
    }

    private String orderNoteFirstXCharacterFromNote(int characterSize) {
        String note = (String) getScenarioContext().getContext(Context.WRITED_NOTE_TEXT);
        String expectedTitle;
        if (note.length() > characterSize) {
            expectedTitle = note.substring(0, characterSize);
        } else {
            expectedTitle = note;
        }

        return expectedTitle;

    }

    private List<GetOrderNoteData> getOrderNoteDataList() {
        return (List<GetOrderNoteData>) getScenarioContext().getContext(Context.GET_ORDER_NOTE_LIST);
    }

    private GetOrderNoteData getAddedOrderNoteData() {
        String expectedTitle = orderNoteFirstXCharacterFromNote(20);
        int index = -1;
        for (GetOrderNoteData getOrderNoteData : getOrderNoteDataList()) {
            if (getOrderNoteData.getTitle().equalsIgnoreCase(expectedTitle)) {
                index = getOrderNoteDataList().indexOf(getOrderNoteData);
            }
        }
        return getOrderNoteDataList().get(index);
    }


    @Then("I can validate added note is exist on order notes response")
    public void i_can_validate_added_note_is_exist_on_order_notes_response() {
        String expectedTitle = orderNoteFirstXCharacterFromNote(20);
        assertTrue(getAddedOrderNoteData().getTitle().equalsIgnoreCase(expectedTitle), "Order note can not found in " +
                "the");
    }

    @Then("I can validate added note created date is valid")
    public void i_can_validate_added_note_created_date_is_valid() {
        assertNotNull(getAddedOrderNoteData().getCreatedDate());
    }

    @Then("Order can validate order title is saved with first {int} character")
    public void order_can_validate_order_title_is_saved_with_first_character(int firstCharacterSize) {
        String actualTitle = getAddedOrderNoteData().getTitle();
        String expectedTitle = orderNoteFirstXCharacterFromNote(firstCharacterSize);
        assertEqual("Expected title should be equal first " + firstCharacterSize, actualTitle, expectedTitle);

    }

    @Then("I can validate order note list size is {int}")
    public void i_can_validate_order_note_list_size_is(Integer expectedSize) {
        assertTrue(getOrderNoteDataList().size() == expectedSize,
                "Order not list siz should be " + expectedSize);
    }

    @Then("I can validate order note response status code is {int}")
    public void i_can_validate_order_note_response_is(Integer statusCode) {
        IRestResponse<WriteOrderNoteResponse> writeOrderNoteResponse =
                (IRestResponse<WriteOrderNoteResponse>) getScenarioContext().getContext(Context.WRITE_ORDER_NOTE_RESPONSE);

        int actualStatus = writeOrderNoteResponse.getStatusCode();
        assertTrue(actualStatus == statusCode,
                "Assert status code should be "
                + statusCode + "not " + actualStatus);
    }


}
