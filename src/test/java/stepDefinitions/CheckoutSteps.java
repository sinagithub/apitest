package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.Payment.CreditCard;
import apiEngine.models.response.Payment.UserCardsResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

@SuppressWarnings("unchecked")
public class CheckoutSteps extends BaseSteps {

    public CheckoutSteps(TestContext testContext) {
        super(testContext);
    }

    @When("I list my credit cards")
    public void i_list_my_credit_cards() {
        IRestResponse<UserCardsResponse> getUserCardsResponse = getCarsiPaymentClient().getUserCards();

        getScenarioContext().setContext(Context.USER_CARDS_RESPONSE, getUserCardsResponse);
    }

    private IRestResponse<UserCardsResponse> getUserCardResponse() {
        return (IRestResponse<UserCardsResponse>) getScenarioContext().getContext(Context.USER_CARDS_RESPONSE);
    }

    private List<CreditCard> getUserCreditCardList() {
        return getUserCardResponse().getBody().getData().getCreditCards();
    }

    @Then("I select card with {string}")
    public void i_select_card_with(String panNumber) {
        List<CreditCard> cardList = getUserCreditCardList();
        CreditCard selectedCreditCard = null;
        for (CreditCard creditCard : cardList) {
            String actualCardPanNumber = creditCard.getPan();
            if (actualCardPanNumber.equalsIgnoreCase(panNumber)) {
                selectedCreditCard = creditCard;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_CREDIT_CARD, selectedCreditCard);
    }

    private CreditCard getSelectedCreditCard() {
        return (CreditCard) getScenarioContext().getContext(Context.SELECTED_CREDIT_CARD);
    }

    @Then("I validate card name is {string}")
    public void i_validate_card_name_is(String expectedCardName) {
        String actualCardName = getSelectedCreditCard().getName();
        assertEqual("Selected card name should be " + expectedCardName, actualCardName, expectedCardName);
    }

    @Then("I validate selected card BankKod is {string}")
    public void i_validate_selected_card_bank_kod_is(String expectedBankKod) {
        String actualBankKod = getSelectedCreditCard().getBankCode();
        assertEqual("Selected BankKod should be " + expectedBankKod, actualBankKod, expectedBankKod);
    }

    @Then("I validate selected card IsMaxiMobile status {string}")
    public void i_validate_selected_card_is_maxi_mobile_status(String isMaxiMobile) {
        Boolean actualIsMaxiValue = getSelectedCreditCard().getIsMaxiMobile();
        if (isMaxiMobile.equalsIgnoreCase("True")) {
            assertTrue(actualIsMaxiValue, "IsMaxi value should be true");
        } else {
            assertTrue(!actualIsMaxiValue, "IsMaxi value should be false");
        }
    }

    @Then("I validate selected card PointAmount is {int}")
    public void i_validate_selected_card_point_amount_is(int expectedPoint) {
        int actualPoint = getSelectedCreditCard().getPointAmount();
        assertTrue(actualPoint == expectedPoint, "Selected card PointAmount should be " + expectedPoint);
    }

    @Then("I validate selected card CardBrand is {string}")
    public void i_validate_selected_card_card_brand_is(String expectedCardBrand) {
        String actualCardBrand = getSelectedCreditCard().getCardBrand();
        assertEqual("Selected card CardBrand should be " + expectedCardBrand, actualCardBrand, expectedCardBrand);
    }

    @Then("I validate selected card image is {string}")
    public void i_validate_selected_card_image_is(String expectedImage) {
        String actualImage = getSelectedCreditCard().getImage();
        assertEqual("Selected card Image should be " + expectedImage, actualImage, expectedImage);

    }

    @Then("I validate selected card ImageHttps is {string}")
    public void i_validate_selected_card_image_https_is(String expectedImageHttps) {
        String actualImageHttps = getSelectedCreditCard().getImageHttps();
        assertEqual("Selected card ImageHttps should be " + expectedImageHttps, actualImageHttps, expectedImageHttps);
    }


    @Then("I validate user cards response AskCVV is {string}")
    public void i_validate_user_cards_response_ask_cvv_is(String expectedAskCvv) {
        boolean actualUserCvvStatus = getUserCardResponse().getBody().getData().getAskCVV();
        if (expectedAskCvv.equalsIgnoreCase("True")) {
            assertTrue(actualUserCvvStatus, "Actual cvv should be true");
        } else {
            assertTrue(!actualUserCvvStatus, "Actual cvv should be false");
        }

    }

    @Then("I validate user cards response code {string}")
    public void i_validate_user_cards_response_code(String expectedResponseCode) {
        String actualResponseCode = getUserCardResponse().getBody().getData().getResponseCode();
        assertTrue(actualResponseCode.equalsIgnoreCase( expectedResponseCode), "ResponseCode should be " + expectedResponseCode);
    }

    @Then("I validate user cards response HasSavedCreditCard is {string}")
    public void i_validate_user_cards_response_has_saved_credit_card_is(String expectedHasSavedCreditCard) {
        boolean actualHasSavedCreditCard = getUserCardResponse().getBody().getData().getHasSavedCreditCard();
        if (expectedHasSavedCreditCard.equalsIgnoreCase("True")) {
            assertTrue(actualHasSavedCreditCard, "Actual cvv should be true");
        } else {
            assertTrue(!actualHasSavedCreditCard, "Actual cvv should be false");
        }
    }

    @Then("I validate user cards response Success is {string}")
    public void i_validate_user_cards_response_success_is(String expectedSuccessStatus) {
        boolean actualSuccessStatus = getUserCardResponse().getBody().getData().getSuccess();
        if (expectedSuccessStatus.equalsIgnoreCase("True")) {
            assertTrue(actualSuccessStatus, "Actual Success should be true");
        } else {
            assertTrue(!actualSuccessStatus, "Actual Success should be false");
        }
    }

    @Then("I validate CreditCards list is empty in user cards response")
    public void i_validate_credit_cards_list_is_empty_in_user_cards_response() {
       int cardListSize = getUserCreditCardList().size();
       assertTrue(cardListSize == 0, "CreditCards should be empty");
    }


}
