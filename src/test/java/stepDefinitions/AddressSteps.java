package stepDefinitions;


import apiEngine.*;
import apiEngine.models.response.Address.AvailableAddressData;
import apiEngine.models.response.Address.AvailableAddressResponse;
import clients.BaseUrls;
import clients.carsi.CarsiAddressesClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class AddressSteps extends BaseSteps {

    public AddressSteps(TestContext testContext) {
        super(testContext);
    }

    private List<AvailableAddressData> getAllAddress(){
        return (List<AvailableAddressData>) getScenarioContext().getContext(Context.ADDRESS_LIST);
    }

    private List<AvailableAddressData> getAvailableAddress(){
        List<AvailableAddressData> addressDataList = getAllAddress();

        List<AvailableAddressData> availableAddresses = new ArrayList<AvailableAddressData>();
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getIsAvailable()) {
                availableAddresses.add(addressData);
            }
        }
        return availableAddresses;
    }

    @Given("My addresses list should be available")
    public void my_addresses_list_available() throws IOException {
        CarsiAddressesClient carsiAddressesClient = new CarsiAddressesClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<AvailableAddressResponse> addressesResponse = carsiAddressesClient.getAddresses();
        Assert.assertTrue(addressesResponse.isSuccessful());

        List<AvailableAddressData> addressDataList = addressesResponse.getBody().getData();
        getScenarioContext().setContext(Context.ADDRESS_LIST, addressDataList);

    }

    @Given("I select pinned available address")
    public void i_select_pinned_available_address_on_selected_catalog() {
        List<AvailableAddressData> addressDataList = getAvailableAddress();
        AvailableAddressData selectedAddress;

        Random random = new Random();
        assertFalse(addressDataList.size() == 0);
        int index =  random.nextInt(addressDataList.size());
        selectedAddress = addressDataList.get(index);

        getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
        LatLongHelper.getInstance().setLatitude(selectedAddress.getLatitude());
        LatLongHelper.getInstance().setLongitude(selectedAddress.getLongitude());
    }

    @Given("I select pinned address with id {string}")
    public void i_select_pinned_address_with_id(String id) {
        List<AvailableAddressData> addressDataList = getAllAddress();

        AvailableAddressData selectedAddress;
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getAddressId().equals(id)) {
                selectedAddress = addressData;
                getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
                break;
            }
        }
    }

    @Given("I select pinned available address with order  {int}")
    public void i_select_pinned_available_address_on_selected_catalog_with_order(int order) {
        List<AvailableAddressData> addressDataList = getAvailableAddress();
        AvailableAddressData selectedAddress;
        selectedAddress = addressDataList.get(order);
        getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
    }

    @Given("I select city {string}")
    public void i_select_city(String catalogName) {
        CatalogSelector.getInstance().setCatalogName(catalogName);
        getScenarioContext().setContext(Context.SELECTED_CATALOG_NAME, catalogName);
        GuidHelper.getInstance().setGuid();
    }

}
