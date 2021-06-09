package stepDefinitions;


import apiEngine.*;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.BanabiAddress;
import apiEngine.models.response.AddressResponse;
import clients.carsi.CarsiUserClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Given("I am an authorized user with {string} {string}")
    public void i_am_an_authorized_user_with_parameters(String userName, String password) throws IOException {
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, password);
        getOauthCoreClient().authenticateUser(authRequest, true);
    }

    @Given("I am an authorized new user")
    public void i_am_a_new_authorized_user() throws IOException {
        String userName = GenerateFakeData.getFakeEmail();
        getOauthCoreClient().registerNewUser(userName);
        String passWord = Utils.getGlobalValue("test1_password");
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, passWord);
        getOauthCoreClient().authenticateUser(authRequest, true);
    }

    @Given("My addresses list should be available")
    public void my_addresses_list_available() {
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);
        CarsiUserClient mockBanabi = new CarsiUserClient("https://store-user-api.yemeksepeti.com");

        IRestResponse<AddressResponse> addressesResponse = mockBanabi.getAddresses(catalogName);
        Assert.assertTrue(addressesResponse.isSuccessful());
        List<BanabiAddress> banabiAddressList = addressesResponse.getBody().getData();
        getScenarioContext().setContext(Context.ADDRESS_LIST, banabiAddressList);

    }

    @Given("I select pinned available address")
    public void i_select_pinned_available_address_on_selected_catalog() {
        List<BanabiAddress> banabiAddressList = (List<BanabiAddress>) getScenarioContext().getContext(Context.ADDRESS_LIST);
        BanabiAddress selectedBanabiAddress;
        List<BanabiAddress> availableBanabiAddresses = new ArrayList<BanabiAddress>();
        for (BanabiAddress banabiAddress : banabiAddressList) {
            if (banabiAddress.getLatitude() != 0.0 && banabiAddress.getAvailabilityStatus() ==1) {
                availableBanabiAddresses.add(banabiAddress);
            }
        }
        Random random = new Random();
        assertFalse(availableBanabiAddresses.size() == 0);
        int index =  random.nextInt(availableBanabiAddresses.size());

        selectedBanabiAddress = availableBanabiAddresses.get(index);
        getScenarioContext().setContext(Context.ADDRESS, selectedBanabiAddress);
        LatLongHelper.getInstance().setLatitude(selectedBanabiAddress.getLatitude());
        LatLongHelper.getInstance().setLongitude(selectedBanabiAddress.getLongitude());
    }

    @Given("I select pinned address with id {string}")
    public void i_select_pinned_address_with_id(String id) {
        List<BanabiAddress> banabiAddressList = (List<BanabiAddress>) getScenarioContext().getContext(Context.ADDRESS_LIST);
        BanabiAddress selectedBanabiAddress;
        for (BanabiAddress banabiAddress : banabiAddressList) {
            if (banabiAddress.getAddressId().equals(id)) {
                selectedBanabiAddress = banabiAddress;
                getScenarioContext().setContext(Context.ADDRESS, selectedBanabiAddress);
                break;
            }
        }
    }

    @Given("I select pinned available address with order  {int}")
    public void i_select_pinned_available_address_on_selected_catalog_with_order(int order) {
        List<BanabiAddress> banabiAddressList = (List<BanabiAddress>) getScenarioContext().getContext(Context.ADDRESS_LIST);
        BanabiAddress selectedBanabiAddress;
        List<BanabiAddress> availableBanabiAddresses = new ArrayList<>();
        for (BanabiAddress banabiAddress : banabiAddressList) {
            if (banabiAddress.getAvailabilityStatus() == 1) {
                availableBanabiAddresses.add(banabiAddress);
            }
        }
        selectedBanabiAddress = availableBanabiAddresses.get(order);
        getScenarioContext().setContext(Context.ADDRESS, selectedBanabiAddress);
    }

    @Given("I select city {string}")
    public void i_select_city(String catalogName) {
        CatalogSelector.getInstance().setCatalogName(catalogName);
        getScenarioContext().setContext(Context.SELECTED_CATALOG_NAME, catalogName);
        GuidHelper.getInstance().setGuid();
    }


    @Then("I should see the product on my favorites")
    public void i_should_see_the_product_on_my_favorites() {
        System.out.println("Check selected product is on favorite list");
    }

}
