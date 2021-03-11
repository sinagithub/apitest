package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Address;
import apiEngine.models.response.Addresses;
import clients.OauthCoreClient;
import clients.carsi.CarsiUserClient;
import cucumber.TestContext;
import cucumber.TestRunner;
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
        getOauthCoreClient().authenticateUser(authRequest,userType.equalsIgnoreCase("Login"));
    }

    @Given("I have pinned address")
    public void i_have_pinned_address() {
        System.out.println("List address and get address info");


    }

    @Given("I have pinned available address on {string}")
    public void i_have_pinned_available_address_on(String catalogName) {
        CarsiUserClient mockBanabi = new CarsiUserClient("https://store-user-api.yemeksepeti.com");

        IRestResponse<Addresses> addressesResponse = mockBanabi.getAddresses(catalogName);
        System.out.println(addressesResponse.getStatusCode());
        System.out.println(addressesResponse.getResponse().asString());
        Address address = addressesResponse.getBody().Addresses.get(0);
        System.out.println(address);
    }


    @Then("I should see the product on my favorites")
    public void i_should_see_the_product_on_my_favorites() {
        System.out.println("Check selected product is on favorite list");
    }



}
