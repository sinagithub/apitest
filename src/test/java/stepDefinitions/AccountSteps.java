package stepDefinitions;


import apiEngine.ApiClient;
import apiEngine.CatalogSelector;
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
import org.junit.Assert;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
@SuppressWarnings("unchecked")
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
    }

    @Given("I have pinned address")
    public void i_have_pinned_address() {
        System.out.println("List address and get address info");


    }



    @Given("My addresses list should be available")
    public void my_addresses_list_available() {
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);
        CarsiUserClient mockBanabi = new CarsiUserClient("https://store-user-api.yemeksepeti.com");

        IRestResponse<AddressResponse> addressesResponse = mockBanabi.getAddresses(catalogName);
        Assert.assertTrue(addressesResponse.isSuccessful());
        List<Address> addressList = addressesResponse.getBody().getData();
        getScenarioContext().setContext(Context.ADDRESS_LIST, addressList);

    }

    @Given("I select pinned available address")
    public void i_select_pinned_available_address_on_selected_catalog() {
        List<Address> addressList = (List<Address>) getScenarioContext().getContext(Context.ADDRESS_LIST);
        Address selectedAddress;
        for (Address address : addressList){
            if (address.getAvailabilityStatus() == 1){
                selectedAddress = address;
                getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
                break;
            }
        }
    }

    @Given("I select city {string}")
    public void i_select_city(String catalogName) {
        CatalogSelector.getInstance().setCatalogName(catalogName);
        getScenarioContext().setContext(Context.SELECTED_CATALOG_NAME, catalogName);
    }


    @Then("I should see the product on my favorites")
    public void i_should_see_the_product_on_my_favorites() {
        System.out.println("Check selected product is on favorite list");
    }


}
