package stepDefinitions;


import apiEngine.EmailSender;
import apiEngine.IRestResponse;
import apiEngine.Utils;
import apiEngine.models.requests.Basket.Checkout.Payment;
import apiEngine.models.requests.Checkout.*;
import apiEngine.models.response.Address.AvailableAddressData;
import apiEngine.models.response.Basket.Checkout.BasketCheckoutResponse;
import apiEngine.models.response.Basket.Checkout.DeliveryTimeOptions;
import apiEngine.models.response.Basket.Checkout.Foundation;
import apiEngine.models.response.Basket.Checkout.Option;
import apiEngine.models.response.Basket.Checkout.PutCheckout.*;
import apiEngine.models.response.CheckOut.PostCheckoutResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

import javax.mail.MessagingException;
import java.util.List;

@SuppressWarnings("unchecked")
public class CheckoutOrderSteps extends BaseSteps {

    public CheckoutOrderSteps(TestContext testContext) {
        super(testContext);
    }

    private IRestResponse<BasketPutResponse> getPutBasketCheckoutResponse() {
        return (IRestResponse<BasketPutResponse>) getScenarioContext().getContext(Context.PUT_BASKET_CHECKOUT_RESPONSE);
    }

    private IRestResponse<BasketCheckoutResponse> getBasketCheckoutResponse() {
        return (IRestResponse<BasketCheckoutResponse>) getScenarioContext().getContext(Context.BASKET_CHECKOUT_RESPONSE);
    }

    private BasketInfo getBasketInfoFromPutResponse() {
        return getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo();
    }

    private BasketCheckout getBasketCheckOutFromPutResponse() {
        return getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout();
    }

    private DeliveryTimeOptions getDeliveryTimeOptions() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getDeliveryTimeOptions();
    }

    private IRestResponse<PostCheckoutResponse> getPostCheckoutResponse() {
        return (IRestResponse<PostCheckoutResponse>) getScenarioContext().getContext(Context.POST_CHECKOUT_RESPONSE);
    }

    private String getWrittenUserNote() {
        return (String) getScenarioContext().getContext(Context.WRITTEN_USER_NOTE);
    }

    private TipInfo getTipInfo() {
        return getBasketCheckOutFromPutResponse().getTipInfo();
    }


    private DonationInfo getDonationInfo() {
        return getBasketCheckOutFromPutResponse().getDonationInfo();
    }

    private Payment getSelectedPayment() {
        return (Payment) getScenarioContext().getContext(Context.PAYMENT_TYPE_SELECTION);
    }

    private List<Foundation> getDonationFoundations() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getDonationInfo().getFoundations();
    }

    private AvailableAddressData getSelectedAddress() {
        return (AvailableAddressData) getScenarioContext().getContext(Context.ADDRESS);
    }

    private Integer getSelectedAlternateProductOptionTypeId() {
        return (Integer) getScenarioContext().getContext(Context.SELECTED_ALTERNATE_PRODUCT_OPTION);
    }

    @Then("I write user note {string}")
    public void i_write_user_note(String userNote) {
        getScenarioContext().setContext(Context.WRITTEN_USER_NOTE, userNote);
    }

    @Then("I set use point {string}")
    public void i_set_use_point(String pointStatus) {
        if (pointStatus.equalsIgnoreCase("True")) {
            getScenarioContext().setContext(Context.USE_POINT_SELECTION, true);
        } else {
            getScenarioContext().setContext(Context.USE_POINT_SELECTION, false);
        }
    }

    @Then("I set delivery time for now - tomorrow")
    public void i_set_delivery_time_for_now() {
        String dayText = getDeliveryTimeOptions().getFuture().getDays().get(1).getDateText();
        getScenarioContext().setContext(Context.SELECTED_DELIVERY_TIME_TEXT, dayText);

    }

    @Then("I set threeDModel cardNumber {string} expireYear {string} expireMonth {string} saveCard {string} cardName " +
            "{} cvv {string} ys3DFormLogId {int} data3DValidationResponse {string}")
    public void i_set_3d_model(String cardNumber, Integer expireYear,
                               Integer expireMonth, String saveCard,
                               String cardName, String cvv, Integer ys3DFormLogId,
                               String data3DValidationResponse) {
        boolean saveCardSelection = false;
        if (saveCard.equalsIgnoreCase("True")) {
            saveCardSelection = true;
        }
        ThreeDModel threeDModel = new ThreeDModel(cardNumber, expireYear, expireMonth, saveCardSelection,
                cardName, cvv, ys3DFormLogId, data3DValidationResponse);

        getScenarioContext().setContext(Context.SELECTED_3D_CARD_MODEL, threeDModel);
    }

    @Then("I set saved card model cardName {string}, cvv {string}")
    public void i_set_saved_card_model(String cardName, String cvv) {
        SavedCardModel savedCardModel = new SavedCardModel(cardName, cvv);
        getScenarioContext().setContext(Context.SELECTED_SAVED_CARD_MODEL, savedCardModel);
    }

    @Then("I set credit card model cardNumber {string}, expireYear {int}, expireMonth {int}, saveCard {string}, " +
            "String cardName, String cvv")
    public void i_set_credit_card_model(String cardNumber, Integer expireYear,
                                        Integer expireMonth, String saveCard, String cardName, String cvv) {
        boolean saveCardSelection = false;
        if (saveCard.equalsIgnoreCase("True")) {
            saveCardSelection = true;
        }

        CreditCardModel creditCardModel = new CreditCardModel(cardNumber, expireYear,
                expireMonth, saveCardSelection, cardName, cvv);

        getScenarioContext().setContext(Context.SELECTED_CREDIT_CARD_MODEL, creditCardModel);
    }

    private boolean getTipIsSelected() {
        List<Option> tipOptions = getTipInfo().getOptions();
        boolean isSelected = false;
        if (tipOptions != null) {
            for (Option tipOption : tipOptions) {
                if (tipOption.getIsSelected()) {
                    isSelected = true;
                }
            }
        }

        return isSelected;
    }

    private boolean getDonationIsSelected() {
        List<Option> donationOptions = getDonationInfo().getOptions();
        boolean isSelected = false;
        if (donationOptions != null) {
            for (Option donationOption : donationOptions) {
                if (donationOption.getIsSelected()) {
                    isSelected = true;
                }
            }
        }
        return isSelected;
    }

    private int getSelectedTipIndex() {
        List<Option> tipOptions = getTipInfo().getOptions();
        int index = -1;
        for (Option tipOption : tipOptions) {
            if (tipOption.getIsSelected()) {
                return tipOptions.indexOf(tipOption);
            }
        }
        return index;
    }

    private int getSelectedDonationIndex() {
        List<Option> donationOptions = getDonationInfo().getOptions();
        int index = -1;
        for (Option donationOption : donationOptions) {
            if (donationOption.getIsSelected()) {
                index = donationOptions.indexOf(donationOption);
            }
        }
        return index;
    }


    @Then("I post checkout with selected options - checkout type is {int}")
    public void i_post_checkout_with_selected_options(int checkoutType) {
        String basketId = getBasketInfoFromPutResponse().getBasketId();
        String writtenNote = getWrittenUserNote();
        double basketTotal = getBasketInfoFromPutResponse().getTotal();
        boolean tipIsSelected = getTipIsSelected();

        Integer tipType = null;
        Integer tipAmount = null;

        if (tipIsSelected) {
            int selectedTipIndex = getSelectedTipIndex();
            tipType = getTipInfo().getOptions().get(selectedTipIndex).getTypeId();
            tipAmount = getTipInfo().getOptions().get(selectedTipIndex).getValue();
        }

        boolean donationIsSelected = getDonationIsSelected();

        Integer donationType = null;
        Integer donationAmount = null;
        String donationFoundationId = null;

        if (donationIsSelected) {
            int selectedDonationIndex = getSelectedDonationIndex();
            donationFoundationId = getDonationFoundations().get(selectedDonationIndex).getFoundationId();
            donationType = getDonationInfo().getOptions().get(selectedDonationIndex).getTypeId();
            donationAmount = getDonationInfo().getOptions().get(selectedDonationIndex).getValue();
        }


        String paymentGroupId = getSelectedPayment().getPaymentMethodId();
        Boolean isFutureOrder = getDeliveryTimeOptions().getFuture().getSelected();
        String addressId = getSelectedAddress().getAddressId();
        int alternateProductTypeIdd = getSelectedAlternateProductOptionTypeId();
        boolean isContactlessDelivery = getBasketCheckOutFromPutResponse().getContactlessDelivery();
        String selectedSlot = (String) getScenarioContext().getContext(Context.SELECTED_DELIVERY_TIME_TEXT);
        boolean usePoints = (boolean) getScenarioContext().getContext(Context.USE_POINT_SELECTION);
        ThreeDModel threeDModel = (ThreeDModel) getScenarioContext().getContext(Context.SELECTED_3D_CARD_MODEL);
        SavedCardModel savedCardModel =
                (SavedCardModel) getScenarioContext().getContext(Context.SELECTED_SAVED_CARD_MODEL);
        CreditCardModel creditCardModel =
                (CreditCardModel) getScenarioContext().getContext(Context.SELECTED_CREDIT_CARD_MODEL);

        TipAndDonationInfo tipAndDonationInfo = new TipAndDonationInfo(
                tipIsSelected,
                donationType
                , donationAmount,
                donationFoundationId,
                tipIsSelected,
                tipType,
                tipAmount);

        PostCheckoutRequest postCheckoutRequest = new PostCheckoutRequest(
                checkoutType,
                basketId,
                basketTotal,
                writtenNote,
                paymentGroupId,
                isFutureOrder,
                addressId,
                alternateProductTypeIdd,
                isContactlessDelivery,
                Utils.generateOrderDate(),
                selectedSlot,
                usePoints,
                threeDModel,
                savedCardModel,
                creditCardModel,
                tipAndDonationInfo
        );
        IRestResponse<PostCheckoutResponse> checkoutPostResponse =
                getCarsiCheckoutClient().postCheckout(postCheckoutRequest);
        getScenarioContext().setContext(Context.POST_CHECKOUT_RESPONSE, checkoutPostResponse);
    }

    @Then("I check checkout response is {int}")
    public void i_check_checkout_response_is(Integer expectedStatus) {
        int actualResponseStatus = getPostCheckoutResponse().getStatusCode();
        assertTrue(expectedStatus == actualResponseStatus, "Post checkout response status should be " + expectedStatus);
    }

    @Then("I check OrderId is created on checkout response")
    public void i_check_order_id_is_created_on_checkout_response() {
        String orderId = getPostCheckoutResponse().getBody().getData().getOrderId();
        assertNotNull(orderId, "Order Id should not null on post checkout response");
    }

    @Then("Send refund email to {string}")
    public void send_refund_email_to(String emailTo) throws MessagingException {
        boolean tipIsSelected = getTipIsSelected();
        double basketTotal = getBasketInfoFromPutResponse().getTotal();

        String orderId = getPostCheckoutResponse().getBody().getData().getOrderId();
        String mailBody = "Iade edilecek order id " + orderId
                + " Iade Miktari : " + basketTotal + " TL";

        if (tipIsSelected){
            int selectedDonationIndex = getSelectedDonationIndex();
            mailBody += " Tip Amount : " +  getTipInfo().getOptions().get(selectedDonationIndex).getValue();
        }


        EmailSender.emailSender(mailBody
                , emailTo, "Mahalle Sipariş Iptali : Automation");
    }



}
