package stepDefinitions;


import apiEngine.CatalogSelector;
import apiEngine.IRestResponse;
import apiEngine.Utilies.GuidHelper;
import apiEngine.Utilies.LatLongHelper;
import apiEngine.models.requests.Address.AddAddressRequest;
import apiEngine.models.response.Address.*;
import apiEngine.models.response.Vendor.VendorResponse;
import clients.BaseUrls;
import clients.carsi.CarsiAddressClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class AddressSteps extends BaseSteps {

    public AddressSteps(TestContext testContext) {
        super(testContext);
    }

    private IRestResponse<VendorResponse> getSelectedVendorResponse() {
        return (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
    }

    private List<AvailableAddressData> getAllAddress(){
        return (List<AvailableAddressData>) getScenarioContext().getContext(Context.ADDRESS_LIST);
    }

    private List<AvailableAddressData> getCheckoutAvailableAddresses(){
        return (List<AvailableAddressData>) getScenarioContext().getContext(Context.CHECKOUT_ADDRESS_LIST);
    }


    private IRestResponse<AvailableAddressResponse> getAvailableAddressResponse() {
        return (IRestResponse<AvailableAddressResponse>) getScenarioContext().getContext(Context.AVAILABLE_ADDRESS_RESPONSE);
    }

    private IRestResponse<AddAddressResponse> getEditAddressResponse() {
        return (IRestResponse<AddAddressResponse>) getScenarioContext().getContext(Context.EDIT_ADDRESS_RESPONSE);
    }

    private IRestResponse<DeleteAddressResponse> getDeleteAddressResponse() {
        return (IRestResponse<DeleteAddressResponse>) getScenarioContext().getContext(Context.DELETE_ADDRESS_RESPONSE);
    }

    private String getAddressId() {
        return (String) getScenarioContext().getContext(Context.ADDRESS_ID);
    }

    private String getBasketId() {
        return (String) getScenarioContext().getContext(Context.BASKET_ID);
    }

    private IRestResponse<AddressActionResponse> getAddressActionResponse() {
        return (IRestResponse<AddressActionResponse>) getScenarioContext().getContext(Context.ADDRESS_ACTION_RESPONSE);
    }

    private IRestResponse<AddAddressResponse> getAddAddressResponse() {
        return  (IRestResponse<AddAddressResponse>) getScenarioContext().getContext(Context.ADD_ADDRESS_RESPONSE);
    }

    private IRestResponse<AddressDetailResponse> getAddressDetailResponse() {
        return (IRestResponse<AddressDetailResponse>) getScenarioContext().getContext(Context.ADDRESS_DETAIL_RESPONSE);
    }
    private HashMap getDefinedAddressInfo() {
        return (HashMap) getScenarioContext().getContext(Context.ADDRESS_INFO_LIST);
    }

    private void updateAddressInfoContext(HashMap definedAddressInfo) {
        getScenarioContext().setContext(Context.ADDRESS_INFO_LIST, definedAddressInfo);
    }

    private List<AvailableAddressData> getAvailableAddress(){
        List<AvailableAddressData> addressDataList = getAllAddress();

        List<AvailableAddressData> availableAddresses = new ArrayList<>();
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getIsAvailable()) {
                availableAddresses.add(addressData);
            }
        }
        return availableAddresses;
    }

    private List<AvailableAddressData> getUnpinnedAddress(){
        List<AvailableAddressData> addressDataList = getAllAddress();

        List<AvailableAddressData> unPinnedAddresses = new ArrayList<>();
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getLatitude()==null) {
                unPinnedAddresses.add(addressData);
            }
        }
        return unPinnedAddresses;
    }

    private boolean isAddressOnTheCheckoutAvailableList(String expectedAddressId) {
        List<AvailableAddressData> checkoutAddressList = getCheckoutAvailableAddresses();
        for (AvailableAddressData addressData : checkoutAddressList) {
            if (addressData.getAddressId().equals(expectedAddressId)) {
                return true;
            }
        }
        return false;
    }

    @Given("My addresses list should be available")
    public void my_addresses_list_available() {
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<AvailableAddressResponse> addressesResponse = carsiAddressClient.getAddresses();
        Assert.assertTrue(addressesResponse.isSuccessful());
        getScenarioContext().setContext(Context.AVAILABLE_ADDRESS_RESPONSE, addressesResponse);
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

    @Given("I select unpinned address")
    public void i_select_unpinned_address() {
        List<AvailableAddressData> addressDataList = getUnpinnedAddress();
        AvailableAddressData selectedAddress;
        Random random = new Random();
        assertFalse(addressDataList.size() == 0);
        int index =  random.nextInt(addressDataList.size());
        selectedAddress = addressDataList.get(index);
        getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
    }

    @Given("I select pinned address with id {string}")
    public void i_select_pinned_address_with_id(String id) {
        List<AvailableAddressData> addressDataList = getAllAddress();

        AvailableAddressData selectedAddress;
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getAddressId().equals(id)) {
                selectedAddress = addressData;
                String addressId = selectedAddress.getAddressId();
                boolean addressReadOnly = selectedAddress.getReadOnly();
                getScenarioContext().setContext(Context.ADDRESS, selectedAddress);
                getScenarioContext().setContext(Context.ADDRESS_ID, addressId);
                getScenarioContext().setContext(Context.ADDRESS_READONLY, addressReadOnly);
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

    @Given("I check my address list size is {int}")
    public void i_check_my_address_list_size_is(int addressSize) {
        List<AvailableAddressData> addressDataList = getAllAddress();
        int addressCount = 0;
        for (AvailableAddressData addressData : addressDataList) {
            if (addressData.getIsAvailable().equals(false)) {
                addressCount ++;
            }
        }
        if (addressCount != addressSize) {
            Assert.fail("Address size should be " + addressSize + "not" + addressCount);
        }
    }

    @Then("I create address info list")
    public void i_create_address_info_list() {
        HashMap definedAddressInfo = new HashMap();
        updateAddressInfoContext(definedAddressInfo);
    }

    @Given("I set address info parameter is {string} value is {string}")
    public void i_set_address_info_parameter_is_value_is(String parameter, String value) {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        definedAddressInfo.put(parameter, value);
        updateAddressInfoContext(definedAddressInfo);
    }

    @Given("I set address info parameter is AddressType value is {int}")
    public void i_set_address_info_parameter_is_address_type_value_is(Integer value) {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        definedAddressInfo.put("AddressType", value);
        updateAddressInfoContext(definedAddressInfo);
    }

    @Given("I set address info parameter is {string} value is {double}")
    public void i_set_address_info_parameter_is_value_is(String parameter, Double value) {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        definedAddressInfo.put(parameter, value);
        updateAddressInfoContext(definedAddressInfo);
    }

    @Given("I add address with defined parameters")
    public void i_add_address_with_defined_parameters() {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        String addressLine1 = (String) definedAddressInfo.get("AddressLine1");
        String addressName = (String) definedAddressInfo.get("AddressName");
        Integer addressType = (Integer) definedAddressInfo.get("AddressType");
        String city = (String) definedAddressInfo.get("City");
        String description = (String) definedAddressInfo.get("Description");
        String email = (String) definedAddressInfo.get("Email");
        String firstName = (String) definedAddressInfo.get("FirstName");
        String lastName = (String) definedAddressInfo.get("LastName");
        Double latitude = (Double) definedAddressInfo.get("Latitude");
        Double longitude = (Double) definedAddressInfo.get("Longitude");
        String areaId = (String) definedAddressInfo.get("AreaId");
        String telephoneNumber = (String) definedAddressInfo.get("TelephoneNumber");

        AddAddressRequest addAddressRequest = new AddAddressRequest(addressLine1, addressName, addressType, city, description,
                email, firstName, lastName, latitude, longitude, areaId, telephoneNumber);
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<AddAddressResponse> addressResponse = carsiAddressClient.postAddress(addAddressRequest);
        getScenarioContext().setContext(Context.ADD_ADDRESS_RESPONSE, addressResponse);
        String addressId = addressResponse.getBody().getData();
        getScenarioContext().setContext(Context.ADDRESS_ID, addressId);
    }

    @Given("I check added address {string} error message and status is {int}")
    public void i_check_added_address_error_message_and_status_is(String expectedMessage, Integer expectedResponseStatus) {
        String actualMessage = getAddAddressResponse().getBody().getInfoList().get(0).getMessage();
        int actualResponseStatus = getAddAddressResponse().getStatusCode();
        assertEqual("Delete address message should be valid",actualMessage, expectedMessage);
        assertTrue(expectedResponseStatus == actualResponseStatus, "Status should be " + expectedResponseStatus + " not " + actualResponseStatus);

    }

    @When("I get selected address action with AreaId {string}")
    public void i_get_selected_address_action_with_area_id(String areaId) {
        String selectedAddressId = getAddressId();
        if ( getAllAddress().size()>0) {
            getScenarioContext().setContext(Context.ADDRESS_ID, selectedAddressId);
            getScenarioContext().setContext(Context.AREAID, areaId);
        }
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<AddressActionResponse> getAddressActionResponse = carsiAddressClient.getAddressAction(selectedAddressId, areaId);
        getScenarioContext().setContext(Context.ADDRESS_ACTION_RESPONSE, getAddressActionResponse);
        assertTrue(getAddressActionResponse.isSuccessful(), "Address action response status should be 200");
    }

    @Then("I validate address ActionType is {int} in address action response")
    public void i_validate_address_action_type_is_in_address_action_response(Integer actionType) {
        int actualActionType = getAddressActionResponse().getBody().getData().getActionType();
        int expectedActionType = actionType;
        assertTrue(actualActionType == expectedActionType, "Action Type should be " + expectedActionType + "not " + actualActionType);
    }

    @Then("I validate selected AddressId in address action response")
    public void i_validate_selected_address_id_in_address_action_response() {
        String actualAddressId = getAddressActionResponse().getBody().getData().getAddress().getAddressId();
        String expectedAddressId = getAddressId();
        assertEqual("Address Id should be " + expectedAddressId,  actualAddressId, expectedAddressId);
    }

    @Then("I validate selected address AddressLine1 {string} in address action response")
    public void i_validate_selected_address_address_line1_in_address_action_response(String expectedAddressLine) {
        String actualAddressLine = getAddressActionResponse().getBody().getData().getAddress().getAddressLine1();
        assertEqual("Address Line should be " + expectedAddressLine + " not " + actualAddressLine, actualAddressLine, expectedAddressLine);
    }

    @Then("I validate selected AddressType {int} in address action response")
    public void i_validate_selected_address_type_in_address_action_response(Integer expectedAddressType) {
        Integer actualAddressType = getAddressActionResponse().getBody().getData().getAddress().getAddressType();
        assertTrue(actualAddressType == expectedAddressType, "Address Type should be " + expectedAddressType + "not " + actualAddressType);
    }

    @Then("I validate selected address ReadOnly {string} in address action response")
    public void i_validate_selected_address_read_only_in_address_action_response(String readOnly) {
        boolean actualReadOnly = getAddressActionResponse().getBody().getData().getAddress().getReadOnly();
        if (readOnly.equalsIgnoreCase("False")) {
            assertTrue(!actualReadOnly, "ReadOnly should be false");
        }
        else
        {
            assertTrue(actualReadOnly, "Read Only should be true");
        }
    }

    @Then("I validate selected City {string} in address action response")
    public void i_validate_selected_city_in_address_action_response(String expectedCity) {
        String actualAddressCity = getAddressActionResponse().getBody().getData().getAddress().getCity();
        assertEqual("Address City should be " + expectedCity, actualAddressCity, expectedCity);
    }
    @Then("I validate selected Latitude {double} in address action response")
    public void i_validate_selected_latitude_in_address_action_response(Double expectedLat) {
        Double actualAddressLat = getAddressActionResponse().getBody().getData().getAddress().getLatitude();
        assertTrue(expectedLat == actualAddressLat, "Addres Latitude should be " + expectedLat + "not " + actualAddressLat);
    }
    @Then("I validate selected Longitude {double} in address action response")
    public void i_validate_selected_longitude_in_address_action_response(Double expectedLong) {
        Double actualAddressLong = getAddressActionResponse().getBody().getData().getAddress().getLongitude();
        assertTrue(expectedLong == actualAddressLong, "Addres Latitude should be " + expectedLong + "not " + actualAddressLong);
    }

    @Then("I validate selected Latitude is null in address action response")
    public void i_validate_selected_latitude_is_null_in_address_action_response() {
        Double actualAddressLat = getAddressActionResponse().getBody().getData().getAddress().getLatitude();
        assertTrue(actualAddressLat == null, "Address Latitude should be null");
    }

    @Then("I validate selected Longitude is null in address action response")
    public void i_validate_selected_longitude_is_null_in_address_action_response() {
        Double actualAddressLong = getAddressActionResponse().getBody().getData().getAddress().getLongitude();
        assertTrue(actualAddressLong == null, "Address Longitude should be null");
    }

    @Then("I validate selected Latitude is {double} in address action response")
    public void i_validate_selected_latitude_is_in_address_action_response(Double expectedAddressLat) {
        Double actualAddressLat = getAddressActionResponse().getBody().getData().getAddress().getLatitude();
        assertTrue(actualAddressLat == expectedAddressLat.doubleValue(), "Address Latitude should be " + expectedAddressLat + " not " + actualAddressLat);
    }
    @Then("I validate selected Longitude is {double} in address action response")
    public void i_validate_selected_longitude_is_in_address_action_response(Double expectedAddressLong) {
        Double actualAddressLong = getAddressActionResponse().getBody().getData().getAddress().getLongitude();
        assertTrue(actualAddressLong == expectedAddressLong.doubleValue(), "Address Longitude should be " + expectedAddressLong + " not " + actualAddressLong);
    }

    private apiEngine.models.response.Address.AvailableAddressData getAddedAddressDetailInAvailableAddresses() {
        int addedAddressIndex = getAddedAddressIndexInAvailableAddresses();
        AvailableAddressData availableAddressData = getAvailableAddressResponse().getBody().getData().get(addedAddressIndex);
        return availableAddressData;
    }

    private int getAddedAddressIndexInAvailableAddresses() {
        List<AvailableAddressData> addressDataList = (List<AvailableAddressData>) getScenarioContext().getContext(Context.ADDRESS_LIST);
        String selectedAddress = getAddressId();
        int addressIndex = -1;
        for (AvailableAddressData address : addressDataList) {
            if (address.getAddressId().equalsIgnoreCase(selectedAddress)) {
                addressIndex = addressDataList.indexOf(address);
                break;
            }
        }
        return addressIndex;
    }

    @Then("I check selected address exists in available addresses response")
    public void i_check_selected_address_exists_in_available_addresses_response() {
        int addressIndex = getAddedAddressIndexInAvailableAddresses();
        assertTrue(addressIndex > -1 , "Added address should be in the available address list");
    }

    @Then("I validate selected address IsAvailable {string} in available address response")
    public void i_validate_selected_address_is_available_in_available_address_response(String expectedIsAvailable) {
        String actualIsAvailable = getAddedAddressDetailInAvailableAddresses().getIsAvailable().toString();
        assertEqual("Address availability value should be " + expectedIsAvailable, actualIsAvailable , expectedIsAvailable);
    }


    @Then("I validate selected address AddressLine1 {string} in available address response")
    public void i_validate_selected_address_address_line1_in_available_address_response(String expectedAddressLine1) {
        String actualAddressLine1 = getAddedAddressDetailInAvailableAddresses().getAddressLine1();
        assertEqual("Address Line should be " + expectedAddressLine1, actualAddressLine1, expectedAddressLine1);
    }

    @Then("I validate selected address AddressType {int} in available address response")
    public void i_validate_selected_address_address_type_in_available_address_response(Integer expectedAddressType) {
        Integer actualAddressType = getAddedAddressDetailInAvailableAddresses().getAddressType();
        assertTrue(actualAddressType == expectedAddressType, "Address Type should be " + expectedAddressType + "not " + actualAddressType);
    }

    @Then("I validate selected address City {string} in available address response")
    public void i_validate_selected_address_city_in_available_address_response(String expectedAddressCity) {
        String actualAddressCity = getAddedAddressDetailInAvailableAddresses().getCity();
        assertEqual("Address City should be " + expectedAddressCity, actualAddressCity, expectedAddressCity);
    }
    @Then("I validate selected address Description {string} in available address response")
    public void i_validate_selected_address_description_in_available_address_response(String expectedAddressDesc) {
        String actualAddressDesc = getAddedAddressDetailInAvailableAddresses().getDescription();
        assertEqual("Address Desciption should be " + expectedAddressDesc, actualAddressDesc, expectedAddressDesc);
    }
    @Then("I validate selected address Email {string} in available address response")
    public void i_validate_selected_address_email_in_available_address_response(String expectedEmail) {
        String actualAddressEmail = getAddedAddressDetailInAvailableAddresses().getEmail();
        assertEqual("Address Email should be " + expectedEmail, actualAddressEmail, expectedEmail);
    }
    @Then("I validate selected address FirstName {string} in available address response")
    public void i_validate_selected_address_first_name_in_available_address_response(String expectedFirstName) {
        String actualFirstName = getAddedAddressDetailInAvailableAddresses().getFirstName();
        assertEqual("Address First name should be " + expectedFirstName, actualFirstName, expectedFirstName);
    }

    @Then("I validate selected address AreaId {string} in available address response")
    public void i_validate_selected_address_area_id_in_available_address_response(String expectedAreaId) {
        String actualAreaId = getAddedAddressDetailInAvailableAddresses().getAreaId();
        assertEqual("Address Area id should be " + expectedAreaId, actualAreaId, expectedAreaId);
    }

    @Then("I validate selected address TelephoneNumber {string} in available address response")
    public void i_validate_selected_address_telephone_number_in_available_address_response(String expectedTelNu) {
        String actualTelNu = getAddedAddressDetailInAvailableAddresses().getTelephoneNumber().replace("(","").replace(")","")
                .replace(" ", "");
        assertEqual("Address Area id should be " + expectedTelNu, actualTelNu, expectedTelNu);
    }

    @Then("I validate selected address Latitude {double} in available address response")
    public void i_validate_selected_address_latitude_in_available_address_response(Double expectedAddressLat) {
        Double actualAddressLat = getAddedAddressDetailInAvailableAddresses().getLatitude();
        assertTrue(actualAddressLat == expectedAddressLat.doubleValue(), "Address Latitude should be " + expectedAddressLat + " not " + actualAddressLat);

    }

    @Then("I validate selected address Longitude {double} in available address response")
    public void i_validate_selected_address_longitude_in_available_address_response(Double expectedAddressLong) {
        Double actualAddressLong = getAddedAddressDetailInAvailableAddresses().getLongitude();
        assertTrue(actualAddressLong == expectedAddressLong.doubleValue(), "Address Latitude should be " + expectedAddressLong + " not " + actualAddressLong);
    }

    @When("I navigate to added address details")
    public void i_navigate_to_added_address_details() {
        String addressId = getAddressId().replace("{", "").replace("}", "");
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<AddressDetailResponse> getAddressDetailResponse = carsiAddressClient.getAddressDetail(addressId);
        getScenarioContext().setContext(Context.ADDRESS_DETAIL_RESPONSE, getAddressDetailResponse);
        assertTrue(getAddressDetailResponse.isSuccessful(), "Get address detail response should be 200");
    }

    @When("I validate selected address IsAvailable {string} in address detail response")
    public void i_validate_selected_address_is_available_in_address_detail_response(String expectedIsAvailable) {
        String actualIsAvailable = getAddressDetailResponse().getBody().getData().getIsAvailable().toString();
        assertEqual("Address availability should be " + expectedIsAvailable, actualIsAvailable, expectedIsAvailable);
    }
    @When("I validate selected address AddressLine1 {string} in address detail response")
    public void i_validate_selected_address_address_line1_in_address_detail_response(String expectedAddressLine1) {
        String actualAddressLine1 = getAddressDetailResponse().getBody().getData().getAddressLine1().toString();
        assertEqual("Address line should be " + expectedAddressLine1, actualAddressLine1, expectedAddressLine1);
    }
    @When("I validate selected address AddressType {int} in address detail response")
    public void i_validate_selected_address_address_type_in_address_detail_response(Integer expectedAddressType) {
        Integer actualAddressType = getAddressDetailResponse().getBody().getData().getAddressType();
        assertTrue(actualAddressType == expectedAddressType, "Address Type should be " + expectedAddressType + "not "
                + actualAddressType);
    }

    @When("I validate selected address Latitude {double} in address detail response")
    public void i_validate_selected_address_latitude_in_address_detail_response(Double expectedLat) {
        Double actualLat = getAddressDetailResponse().getBody().getData().getLatitude();
        assertTrue(actualLat == expectedLat.doubleValue(), "Address Lat should be " + expectedLat + "not "
                + actualLat);
    }

    @When("I validate selected address Longitude {double} in address detail response")
    public void i_validate_selected_address_longitude_in_address_detail_response(Double expectedLong) {
        Double actualLong= getAddressDetailResponse().getBody().getData().getLongitude();
        assertTrue(actualLong == expectedLong.doubleValue(), "Address Longitude should be " + expectedLong + "not "
                + actualLong);
    }

    @When("I delete added user address")
    public void i_delete_added_user_address() {
        String addressId = getAddressId().replace("{", "").replace("}", "");
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        IRestResponse<DeleteAddressResponse> deleteAddressResponse = carsiAddressClient.deleteAddress(addressId);
        getScenarioContext().setContext(Context.DELETE_ADDRESS_RESPONSE, deleteAddressResponse);
    }

    @When("I check address delete response status is {int} and error message is {string}")
    public void i_check_address_delete_response_status_is_and_error_message_is(Integer expectedResponseStatus, String expectedMessage) {
        String actualMessage = getDeleteAddressResponse().getBody().getInfoList().get(0).getMessage();
        int actualDeleteResponseStatus = getDeleteAddressResponse().getStatusCode();
        assertEqual("Delete address message should be valid",actualMessage, expectedMessage);
        assertTrue(expectedResponseStatus == actualDeleteResponseStatus, "Status should be " + expectedResponseStatus + " not " + actualDeleteResponseStatus);

    }

    @When("I set selected address {string} {double}")
    public void i_set_selected_address(String parameter, Double expectedParamValue) {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        definedAddressInfo.replace(parameter, expectedParamValue);
        updateAddressInfoContext(definedAddressInfo);
    }
    @When("I set selected address {string} {string}")
    public void i_set_selected_address(String parameter, String expectedParamValue) {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        definedAddressInfo.replace(parameter, expectedParamValue);
        updateAddressInfoContext(definedAddressInfo);
    }

    @When("I edit selected address")
    public void i_edit_selected_address() throws UnsupportedEncodingException {
        HashMap definedAddressInfo = getDefinedAddressInfo();
        String addressLine1 = (String) definedAddressInfo.get("AddressLine1");
        String addressName = (String) definedAddressInfo.get("AddressName");
        Integer addressType = (Integer) definedAddressInfo.get("AddressType");
        String city = (String) definedAddressInfo.get("City");
        String description = (String) definedAddressInfo.get("Description");
        String email = (String) definedAddressInfo.get("Email");
        String firstName = (String) definedAddressInfo.get("FirstName");
        String lastName = (String) definedAddressInfo.get("LastName");
        Double latitude = (Double) definedAddressInfo.get("Latitude");
        Double longitude = (Double) definedAddressInfo.get("Longitude");
        String areaId = (String) definedAddressInfo.get("AreaId");
        String telephoneNumber = (String) definedAddressInfo.get("TelephoneNumber");
        AddAddressRequest editAddressRequest = new AddAddressRequest(addressLine1, addressName, addressType, city, description,
                email, firstName, lastName, latitude, longitude, areaId, telephoneNumber);
        String addressId = getAddressId();
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
//        IRestResponse<AddAddressResponse> editAddressResponse = carsiAddressClient.editAddress(addressId, editAddressRequest);
//        getScenarioContext().setContext(Context.EDIT_ADDRESS_RESPONSE, editAddressResponse);
    }

    @Given("I check edited address status is {int}")
    public void i_check_edited_address_status_is(Integer expectedResponseStatus) {
        int actualResponseStatus = getEditAddressResponse().getStatusCode();
        assertTrue(expectedResponseStatus == actualResponseStatus, "Status should be " + expectedResponseStatus + " not " + actualResponseStatus);

    }

    @Then("I list available addresses in checkout")
    public void i_list_available_addresses_in_checkout() {
        CarsiAddressClient carsiAddressClient = new CarsiAddressClient(BaseUrls.getCarsiBaseUrl());
        String selectedVendorId = getSelectedVendorResponse().getBody().getData().getId();
        IRestResponse<AvailableAddressResponse> availableAddressesResponse = carsiAddressClient.getAvailableCheckout(getBasketId(),
                selectedVendorId);
        Assert.assertTrue(availableAddressesResponse.isSuccessful());
        getScenarioContext().setContext(Context.CHECKOUT_AVAILABLE_ADDRESS_RESPONSE, availableAddressesResponse);
        List<AvailableAddressData> addressDataList = availableAddressesResponse.getBody().getData();
        getScenarioContext().setContext(Context.CHECKOUT_ADDRESS_LIST, addressDataList);
    }

    @Then("I validate address is not listed in available checkout response")
    public void i_validate_address_is_not_listed_in_available_checkout_response() {
        String expectedAddressId = getAddressId();
        assertTrue(!isAddressOnTheCheckoutAvailableList(expectedAddressId), "Address is in available checkout address list !");
    }

    @Then("I validate address is listed in available checkout response")
    public void i_validate_address_is_listed_in_available_checkout_response() {
        String expectedAddressId = getAddressId();
        assertTrue(isAddressOnTheCheckoutAvailableList(expectedAddressId), "Address not in available checkout address list !");
    }

}

