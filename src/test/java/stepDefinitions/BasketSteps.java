package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.models.response.Address;
import apiEngine.models.response.Basket.BasketIdResponse;
import clients.BaseUrls;
import clients.carsi.CarsiBasketClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

public class BasketSteps extends BaseSteps {

    public BasketSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("I get unique basket id")
    public void user_get_unique_basket_id() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = address.getAddressId();

        CarsiBasketClient mockBasketClient = new CarsiBasketClient(BaseUrls.mockBaseUrl());
        IRestResponse<BasketIdResponse> basketIdResponse = mockBasketClient.getBasketId(addressId);
        String basketId = basketIdResponse.getBody().getBasketId();

        getScenarioContext().setContext(Context.BASKET_ID, basketId);
    }

    @Then("I can get basket id : same old basket id")
    public void i_can_get_basket_id_same_old_basket_id() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = address.getAddressId();

        String oldBasketId = (String) getScenarioContext().getContext(Context.BASKET_ID);

        CarsiBasketClient mockBasketClient = new CarsiBasketClient(BaseUrls.mockBaseUrl());
        IRestResponse<BasketIdResponse> basketIdResponse = mockBasketClient.getBasketId(addressId);
        String newBasketId = basketIdResponse.getBody().getBasketId();

        assertTrue(newBasketId.equals(oldBasketId),"New basket id and old basket id should be equal");

    }


}
