package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Address;
import apiEngine.models.response.AddressResponse;
import clients.carsi.CarsiUserClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class AccountSteps extends BaseSteps {

    public AccountSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I am an authorized  user {string}")
    public void i_am_an_authorized_user(String userType) throws IOException {

        String userName = Utils.getGlobalValue("test1_userName");
        String passWord = Utils.getGlobalValue("test1_password");
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, passWord);
        getOauthCoreClient().authenticateUser(authRequest, userType.equalsIgnoreCase("Login"));
        getOauthCoreClient().resetToken();
    }

    @Given("I have pinned address")
    public void i_have_pinned_address() {
        System.out.println("List address and get address info");


    }

    @Given("I have pinned available address on {string}")
    public void i_have_pinned_available_address_on(String catalogName) {
        CarsiUserClient mockBanabi = new CarsiUserClient("https://store-user-api.yemeksepeti.com");
        IRestResponse<AddressResponse> addressesResponse = mockBanabi.getAddresses(catalogName);
        Address address = addressesResponse.getBody().getData().get(0);
        getScenarioContext().setContext(Context.ADDRESS,address);
        getScenarioContext().setContext(Context.SELECTED_CATALOG_NAME,catalogName);
    }


    @Then("I should see the product on my favorites")
    public void i_should_see_the_product_on_my_favorites() {
        System.out.println("Check selected product is on favorite list");
    }


}
