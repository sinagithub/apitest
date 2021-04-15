package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import apiEngine.models.response.HomePage.*;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class HomePageSteps extends BaseSteps {

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("A list of Carşı Vendor are available on home page")
    public void a_list_of_Vendor_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        IRestResponse<HomePageCarsiResponse> homePageCarsiResponse = getCarsiHomePageClient().getVendorList(
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        Assert.assertTrue(homePageCarsiResponse.isSuccessful());
        List<CarsiVendor> vendorList = homePageCarsiResponse.getBody().getData().getCarsiVendors();
        assertTrue(vendorList.size() > 0,"Vendor list should not be empty");
        getScenarioContext().setContext(Context.HOME_VENDOR_LIST, vendorList);
        getScenarioContext().setContext(Context.HOME_VENDOR_RESPONSE, homePageCarsiResponse);
    }

    @Then("Select first vendor from {string} category from home page")
    public void select_first_vendor_from_category(String categoryName) {
        List<CarsiVendor> vendorList = (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        CarsiVendor selectedVendor = null;
        for (CarsiVendor vendor : vendorList){
            if (vendor.getCategoryName().equalsIgnoreCase(categoryName)){
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }



    @When("I navigate a vendor")
    public void i_navigate_a_vendor() {
        List<CarsiVendor> vendorList = (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        CarsiVendor vendor = vendorList.get(2);
        System.out.println(vendor.getName());
    }

    @When("I navigate banabi vendor")
    public void i_navigate_banabi_vendor() {
        CarsiVendor banabiVendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        System.out.println(banabiVendor.getName());
        System.out.println(banabiVendor.getDeliveryFeeInfo());
    }

    @Given("Banabi Vendor is available")
    public void banabi_are_available() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        IRestResponse<HomePageBanabiResponse> homePageBanabi = getCarsiHomePageClient().getBanabiVendor(
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        CarsiVendor banabiVendor = homePageBanabi.getBody().getData().getVendorInfo();
        getScenarioContext().setContext(Context.BANABI_VENDOR_INFO, banabiVendor);
        getScenarioContext().setContext(Context.BANABI_VENDOR_RESPONSE, homePageBanabi);
    }


    @Then("Check Banabi vendor image url not empty")
    public void check_banabi_vendor_image_not_empty() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getImageUrl().isEmpty());
    }

    @Then("Check Banabi vendor id is valid")
    public void check_banabi_vendor_id_is_valid() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getId().isEmpty());
    }

    @Then("Check Banabi vendor DeliveryTimeInfo is not empty")
    public void check_banabi_vendor_DeliveryTimeInfo_is_not_empty() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getDeliveryTimeInfo().isEmpty());
    }

    @Then("Check Banabi vendor MinBasketPriceInfo is not empty")
    public void check_banabi_vendor_MinBasketPriceInfo_is_not_empty() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getMinBasketPriceInfo().isEmpty());
    }

    @Then("Check Banabi vendor DeliveryFeeInfo is not empty")
    public void check_banabi_vendor_DeliveryFeeInfo_is_not_empty() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getDeliveryFeeInfo().isEmpty());
    }

    @Then("Check Banabi vendor name is not empty")
    public void check_banabi_vendor_name_is_not_empty() {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getName().isEmpty());
    }

    @Then("Check Banabi vendor IsOpen should be {string}")
    public void check_banabi_vendor_IsOpen_should_be(String isOpen) {
        CarsiVendor vendor = (CarsiVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        boolean status = isOpen.equalsIgnoreCase("true");
        if (status){
            assertTrue(vendor.getIsOpen(),"Banabi vendor should be open");
        }
        else {
            Assert.assertFalse(vendor.getIsOpen());
        }
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
        IRestResponse<HomePageBannersResponse> homeBanners = getCarsiHomePageClient().getHomePageBanners(
                address.getAddressId(),
                address.getAreaId(),
                address.getLatitude(),
                address.getLongitude());
        Assert.assertTrue(homeBanners.isSuccessful());
        List<Banner> bannerList = homeBanners.getBody().getData().getBanners();
        getScenarioContext().setContext(Context.BANNER_LIST, bannerList);
    }

    @Then("HomePage banners are valid")
    public void check_banner_urls_is_valid() {
        List<Banner> banners = (List<Banner>) getScenarioContext().getContext(Context.BANNER_LIST);
        for (Banner banner : banners) {
            Response response = getCarsiHomePageClient().getImageUrlResponse(banner.getImageUrl());
            Assert.assertEquals(200, response.getStatusCode());
        }
    }

    @When("HomePage platform is available")
    public void homepage_platform_is_available() {
        IRestResponse<HomePagePlatformResponse> platformResponse = getCarsiHomePageClient().getPlatform();
        getScenarioContext().setContext(Context.HOME_PLATFORM_RESPONSE, platformResponse);
    }

    @Then("HomePage platform is valid$")
    public void homepage_platform_is_valid(List<String> testData) {
        IRestResponse<HomePagePlatformResponse> homePagePlatformResponse =
                (IRestResponse<HomePagePlatformResponse>) getScenarioContext().getContext(Context.HOME_PLATFORM_RESPONSE);
        List<PlatformData> platformList = homePagePlatformResponse.getBody().getData();
        List<String> platformNameList = new ArrayList<>();
        for (PlatformData platform : platformList){
            platformNameList.add(platform.getPlatform());
        }

        for (String platformName : testData){
           int  index = platformNameList.indexOf(platformName);
            System.out.println(index);
           assertTrue(index != -1,"Platform should be available on selected city : " + platformName);
        }

    }
}

