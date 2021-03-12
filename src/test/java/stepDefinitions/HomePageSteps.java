package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import clients.BaseUrls;
import clients.carsi.CarsiHomePageClient;
import clients.carsi.CarsiVendorClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("A list of Vendor are available")
    public void a_list_of_Vendor_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        CarsiHomePageClient mockHomePage = new CarsiHomePageClient(BaseUrls.mockBaseUrl());
        String catalogName = getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME).toString();

        IRestResponse<HomePageCarsiResponse> homePageCarsiResponse = mockHomePage.getVendorList(
                catalogName,
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        CarsiVendors vendor =
                homePageCarsiResponse.getBody().getData().getCarsiCategories().get(0).getCarsiVendors().get(0);
        getScenarioContext().setContext(Context.VENDOR_BASIC_INFO, vendor);

    }

    @When("I navigate a vendor")
    public void i_navigate_a_vendor() {
        CarsiVendors vendor = (CarsiVendors) getScenarioContext().getContext(Context.VENDOR_BASIC_INFO);
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);

        CarsiVendorClient mockVendorClient = new CarsiVendorClient(BaseUrls.mockBaseUrl());
        IRestResponse<VendorResponse> vendorResponse = mockVendorClient.getVendor(catalogName, vendor.getVendorId());
        VendorDetail vendorDetail = vendorResponse.getBody().getData();

        getScenarioContext().setContext(Context.VENDOR_DETAIL, vendorDetail);
    }
}
