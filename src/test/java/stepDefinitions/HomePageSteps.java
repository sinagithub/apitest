package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import cucumber.Storage;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("A list of Vendor are available")
    public void a_list_of_Vendor_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String catalogName = getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME).toString();
        IRestResponse<HomePageCarsiResponse> homePageCarsiResponse = getCarsiHomePageClient().getVendorList(
                catalogName,
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        Assert.assertTrue(homePageCarsiResponse.isSuccessful());
        List<CarsiVendor> vendorList = homePageCarsiResponse.getBody().getData().getCarsiVendors();
        assertTrue(vendorList.size() > 0);
        getScenarioContext().setContext(Context.HOME_VENDOR_LIST, vendorList);
        getScenarioContext().setContext(Context.HOME_VENDOR_RESPONSE, homePageCarsiResponse);

    }

    @When("I navigate a vendor")
    public void i_navigate_a_vendor() {
        List<CarsiVendor> vendorList = (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        CarsiVendor vendor = vendorList.get(2);
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);
        System.out.println(vendor.getName());
    }

    @When("I navigate banabi vendor")
    public void i_navigate_banabi_vendor() {
        CarsiVendor banabiVendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);
        System.out.println(banabiVendor.getName());
        System.out.println(banabiVendor.getDeliveryFeeInfo());
    }

    @Given("Banabi Vendor is available")
    public void banabi_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String catalogName = getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME).toString();
        IRestResponse<HomePageBanabiResponse> homePageBanabi = getCarsiHomePageClient().getBanabiVendor(
                catalogName,
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        CarsiVendor banabiVendor = homePageBanabi.getBody().getData().getVendorInfo();
        getScenarioContext().setContext(Context.BANABI_VENDOR_INFO, banabiVendor);
        getScenarioContext().setContext(Context.BANABI_VENDOR_RESPONSE, homePageBanabi);
    }

    @Then("Check Banabi vendor properties are valid")
    public void check_banabi_vendor_is_valid() {
        IRestResponse<HomePageBanabiResponse> homePageBanabiResponse =
                (IRestResponse<HomePageBanabiResponse>) getScenarioContext().getContext(Context.BANABI_VENDOR_RESPONSE);
        Assert.assertTrue(homePageBanabiResponse.isSuccessful());
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getId().isEmpty());
        Assert.assertFalse(vendor.getImageUrl().isEmpty());
        Assert.assertFalse(vendor.getName().isEmpty());
    }

    @Then("Check vendor properties are valid")
    public void check_vendor_properties_are_valid() {
        IRestResponse<HomePageCarsiResponse> homePageBanabiResponse =
                (IRestResponse<HomePageCarsiResponse>) getScenarioContext().getContext(Context.HOME_VENDOR_RESPONSE);
        Assert.assertTrue(homePageBanabiResponse.isSuccessful());

        List<CarsiVendor> vendorList = (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        CarsiVendor vendor = vendorList.get(0);
        Assert.assertFalse(vendor.getId().isEmpty());
        Assert.assertFalse(vendor.getImageUrl().isEmpty());
        Assert.assertFalse(vendor.getName().isEmpty());
    }

    @Given("HomePage banners are available")
    public void home_banners_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String catalogName = getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME).toString();
        IRestResponse<HomePageBannersResponse> homeBanners = getCarsiHomePageClient().getHomePageBanners(
                catalogName,
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        Assert.assertTrue(homeBanners.isSuccessful());
        List<Banner> bannerList = homeBanners.getBody().getData().getBanners();
        getScenarioContext().setContext(Context.BANNER_LIST, bannerList);
    }

    @Then("HomePage banners are valid")
    public void check_banner_urls_is_valid(){
        List<Banner> banners = (List<Banner>) getScenarioContext().getContext(Context.BANNER_LIST);
        for (Banner banner : banners){
          Response response =  getCarsiHomePageClient().getBannerUrlResponse(banner.getImageUrl());
            Assert.assertEquals(200, response.getStatusCode());
        }
    }
}

