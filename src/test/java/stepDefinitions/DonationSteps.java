package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.requests.Basket.Checkout.Donation;
import apiEngine.models.response.Basket.Checkout.*;
import apiEngine.models.response.Basket.Checkout.PutCheckout.BasketPutResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;


@SuppressWarnings("unchecked")
public class DonationSteps extends BaseSteps {

    public DonationSteps(TestContext testContext) {
        super(testContext);
    }

    private IRestResponse<BasketCheckoutResponse> getBasketCheckoutResponse() {
        return (IRestResponse<BasketCheckoutResponse>) getScenarioContext().getContext(Context.BASKET_CHECKOUT_RESPONSE);
    }

    private DonationInfo getDonationInfoFromGetBasket() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getDonationInfo();
    }

    private List<Foundation> getFoundationListFromGetBasket() {
        return getDonationInfoFromGetBasket().getFoundations();
    }

    private List<Option1> getDonationOptionsFromGetBasket() {
        return getDonationInfoFromGetBasket().getOptions();
    }

    private BasketInfo getBasketInfoFromGetBasket() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo();
    }

    private IRestResponse<BasketPutResponse> getPutBasketCheckoutResponse() {
        return (IRestResponse<BasketPutResponse>) getScenarioContext().getContext(Context.PUT_BASKET_CHECKOUT_RESPONSE);
    }

    private List<Option> getDonationOptionsFromPutBasket() {
        return getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getDonationInfo().getOptions();
    }


    private String getDonationInfoRoundedPaymentText(String text) {
        double tipValue = 5 - getBasketInfoFromGetBasket().getTotal() % 5;

        String roundedValue = String.format("%.1f", tipValue);
        return text + " " + roundedValue + " TL";
    }

    @Then("I check donation Enabled value is {string} on basket checkout response")
    public void i_check_donation_enabled_value_is_on_basket_checkout_response(String expectedEnabledValue) {
        boolean actualEnabledValue = getDonationInfoFromGetBasket().getEnabled();
        if (expectedEnabledValue.contains("true")) {
            assertTrue(actualEnabledValue, "Enabled value should be True");
        } else {
            assertFalse(actualEnabledValue);
        }
    }

    private boolean foundationNameIsExistOnList(String expectedFoundationName) {
        List<Foundation> foundationList = getFoundationListFromGetBasket();
        for (Foundation foundation : foundationList) {
            if (foundation.getFoundationName().equalsIgnoreCase(expectedFoundationName)) {
                return true;
            }
        }
        return false;
    }

    @Then("I check foundation name is listed {string}")
    public void i_check_foundation_name_is_listed(String expectedFoundationName) {
        assertTrue(foundationNameIsExistOnList(expectedFoundationName), "Foundation name should be exist on list");
    }

    private boolean foundationIdIsExistOnList(String expectedFoundationId) {
        List<Foundation> foundationList = getFoundationListFromGetBasket();
        for (Foundation foundation : foundationList) {
            if (foundation.getFoundationId().equalsIgnoreCase(expectedFoundationId)) {
                return true;
            }
        }
        return false;
    }

    @Then("I check foundation FoundationId is listed {string}")
    public void i_check_foundation_foundation_id_is_listed(String expectedFoundationId) {
        assertTrue(foundationIdIsExistOnList(expectedFoundationId), "Foundation id should be exist on list");
    }

    private boolean foundationDescIsExistOnList(String expectedFoundationDesc) {
        List<Foundation> foundationList = getFoundationListFromGetBasket();
        for (Foundation foundation : foundationList) {
            if (foundation.getFoundationDescription().equalsIgnoreCase(expectedFoundationDesc)) {
                return true;
            }
        }
        return false;
    }

    @Then("I check foundation FoundationDescription is listed {string}")
    public void i_check_foundation_foundation_description_is_listed(String expectedFoundationDesc) {
        assertTrue(foundationDescIsExistOnList(expectedFoundationDesc), "Foundation Description should be exist on " +
                "list");
    }

    private boolean foundationIconIsExistOnList(String expectedFoundationIcon) {
        List<Foundation> foundationList = getFoundationListFromGetBasket();
        for (Foundation foundation : foundationList) {
            if (foundation.getFoundationIconUrl().equalsIgnoreCase(expectedFoundationIcon)) {
                return true;
            }
        }
        return false;
    }

    @Then("I check foundation FoundationIconUrl is listed {string}")
    public void i_check_foundation_foundation_icon_url_is_listed(String expectedFoundationIcon) {
        assertTrue(foundationIconIsExistOnList(expectedFoundationIcon), "FoundationIconUrl should be exist on " +
                "list");
    }

    private Boolean getFoundationIsActive(String expectedFoundationId) {
        List<Foundation> foundationList = getFoundationListFromGetBasket();
        int index = -1;

        for (Foundation foundation : foundationList) {
            String actualFoundationId = foundation.getFoundationId();
            if (actualFoundationId.equalsIgnoreCase(expectedFoundationId)) {
                index = foundationList.indexOf(foundation);
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        return foundationList.get(index).getIsActive();
    }

    @Then("I check foundation IsActive is {string} {string}")
    public void i_check_foundation_is_active_is(String expectedIsActive, String foundationId) {
        if (expectedIsActive.equalsIgnoreCase("True")) {
            assertTrue(getFoundationIsActive(foundationId),
                    "Expected foundation should be true " + " id is " + foundationId);
        }
    }


    @When("I check donation {int} {int} on get basket checkout")
    public void i_check_donation_on_get_basket_checkout(Integer expectedTypeId, Integer rank) {
        int actualTypeId = getDonationOptionsFromGetBasket().get(rank).getTypeId();
        assertTrue(expectedTypeId == actualTypeId, "ExpectedDonationTypeId should be equal with actual " + "Actual is" +
                " :" + actualTypeId);
    }

    @When("I check donation {string} {int} {int} on get basket checkout")
    public void i_check_donation_on_get_basket_checkout(String expectedValueText, Integer rank, int typeId) {
        String actualDonationValueText = getDonationOptionsFromGetBasket().get(rank).getValueText();
        if (typeId == 1) {
            String expectedRoundedDonationText = getDonationInfoRoundedPaymentText(expectedValueText);
            assertTrue(actualDonationValueText.contains(expectedRoundedDonationText),"Value text should contain" + expectedRoundedDonationText );
        } else {
            assertTrue(actualDonationValueText.contains(expectedValueText),"Value text should contain" + expectedValueText );
        }
    }

    @When("I check donation status {string} {int} on get basket checkout")
    public void i_check_donation_status_on_get_basket_checkout(String expectedStatus, Integer rank) {
        boolean actualStatus = getDonationOptionsFromGetBasket().get(rank).getIsSelected();
        if (expectedStatus.equalsIgnoreCase("True")) {
            assertTrue(actualStatus, "Status should be true");
        } else {
            assertTrue(!actualStatus, "Status should be false");
        }
    }

    @When("I check donation value is valid {int}")
    public void i_check_donation_value_is_valid(Integer donationTypeId) {
        List<Option1> optionList = getDonationOptionsFromGetBasket();

        if (donationTypeId == 3) {
            assertTrue(optionList.get(2).getValue() == 0, "Donation value should be 0");
        } else if (donationTypeId == 2) {
            assertTrue(optionList.get(1).getValue() == 5, "Donation value should be 5");
        } else if (donationTypeId == 1) {
            double actualValue = optionList.get(0).getValue();
            double expectedValue =
                    5 - (getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo().getTotal() % 5);
            assertTrue(actualValue == roundDouble(expectedValue, "#.#"),
                    "Donation value should be " + expectedValue + " not " + actualValue);
        }
    }

    @Then("I set donation to {int} tl option type is {int} foundation id is {string}")
    public void i_set_donation_to_tl_option_type_is(Integer donationValue, Integer optionTypeId, String foundationId) {
        Donation donation = new Donation(foundationId, optionTypeId, donationValue);
        getScenarioContext().setContext(Context.DONATION_SELECTION, donation);
    }

    @Then("I check Donation is selected with {int} tl typeId {int} on put basket checkout response")
    public void i_check_donation_is_selected_with_type_id_on_put_basket_checkout_response(Integer expectedValue,
                                                                                          Integer expectedTypeId) {
        List<Option> optionList = getDonationOptionsFromPutBasket();
        int index = -1;
        for (Option option : optionList) {
            int actualTypeId = option.getTypeId();
            if (actualTypeId == expectedTypeId) {
                index = optionList.indexOf(option);
                break;
            }
        }

        int actualValue = getDonationOptionsFromPutBasket().get(index).getValue();
        assertTrue(actualValue == expectedValue,
                "Donation option value should be " + expectedTypeId + " not : " + actualValue);
    }

    @Then("I validate put basket checkout response status is {int} with Message {string}")
    public void i_validate_put_basket_checkout_response_status_is_with_message(Integer expectedStatus, String expectedMessage) {
      String actualMessage =   getPutBasketCheckoutResponse().getBody().getInfoList().get(0).getMessage();
      int actualResponseStatus = getBasketCheckoutResponse().getStatusCode();
      assertEqual("Donation error message should be valid.",expectedMessage,actualMessage);
      assertTrue(actualResponseStatus == 200, "Status should be " + expectedStatus + " not " + actualResponseStatus);
    }

}

