package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.Utilies.PlatformTypeHelper;
import apiEngine.Utilies.Utils;
import apiEngine.models.response.*;
import apiEngine.models.response.Address.AvailableAddressData;
import apiEngine.models.response.HomePage.*;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class HomePageSteps extends BaseSteps {

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    private List<MahalleVendor> getHomeVendorList(){
        return  (List<MahalleVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
    }

    private AvailableAddressData getSelectedAddress(){
        return (AvailableAddressData) getScenarioContext().getContext(Context.ADDRESS);
    }

    @Given("A list of Carşı Vendor are available on home page")
    public void a_list_of_Vendor_are_available() {
        AvailableAddressData availableAddress = getSelectedAddress();
        IRestResponse<HomePageCarsiResponse> homePageCarsiResponse = getCarsiHomePageClient().getVendorList(
                availableAddress.getAddressId(),
                availableAddress.getAreaId(),
                availableAddress.getLatitude(),
                availableAddress.getLongitude());
        Assert.assertTrue(homePageCarsiResponse.isSuccessful());
        List<MahalleVendor> vendorList = homePageCarsiResponse.getBody().getData().getCarsiVendors();
        assertTrue(vendorList.size() > 0, "Vendor list should not be empty");
        getScenarioContext().setContext(Context.HOME_VENDOR_LIST, vendorList);
        getScenarioContext().setContext(Context.HOME_VENDOR_RESPONSE, homePageCarsiResponse);
        setCurrentPlatformType("Mahalle");
    }

    @Given("I select Banabi platform")
    public void i_select_banabi_platform() {
        setCurrentPlatformType("Banabi");
    }

    @Given("I select Mahalle platform")
    public void i_select_mahalle_platform() {
        setCurrentPlatformType("Mahalle");
    }

    @Then("I select first vendor from {string} category on home page")
    public void select_first_vendor_from_category(String categoryName) {
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList) {
            if (vendor.getCategoryName().equalsIgnoreCase(categoryName) && vendor.getIsOpen()) {
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Then("I select mahalle vendor from defined vendors type is {string} on home page")
    public void select_vendor_with_defined_vendorName(String vendorType) throws IOException {
        String vendorName = Utils.getGlobalValue(vendorType);
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList) {
            if (vendor.getName().equalsIgnoreCase(vendorName)) {
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Then("I select {string} mahalle vendor name on home page")
    public void select_vendor_with_vendorName(String vendorName) {
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList) {
            if (vendor.getName().equalsIgnoreCase(vendorName)) {
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Then("I select Carsı vendor with order - {int}")
    public void select_carsi_vendor_with_order(int vendorOrder) {
        PlatformTypeHelper.getInstance().setPlatformType("Mahalle");
        List<MahalleVendor> vendorList = (List<MahalleVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
        MahalleVendor selectedVendor = vendorList.get(vendorOrder);
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }


    @Then("I select random vendor from {string} category on home page")
    public void select_random_vendor_from_category(String categoryName) {
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList) {
            if (vendor.getCategoryName().equalsIgnoreCase(categoryName)) {
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Then("I select closed Carsı vendor")
    public void select_closed_carsi_vendor() {
        PlatformTypeHelper.getInstance().setPlatformType("Mahalle");
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList){
            if (!vendor.getIsOpen()){
                selectedVendor = vendor;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Then("I should see closed vendor on home vendor list")
    public void check_closed_vendor() {
        List<MahalleVendor> vendorList = getHomeVendorList();
        MahalleVendor selectedVendor = null;
        for (MahalleVendor vendor : vendorList){
            if (!vendor.getIsOpen()){
                selectedVendor = vendor;
                break;
            }
        }

        if (selectedVendor == null){
            Assert.fail("There are no closed vendor on the vendor list");
        }

        else {
            assertTrue(!selectedVendor.getIsOpen(),"Vendor status should be false");
        }
    }


    @Then("I select banabi vendor")
    public void i_select_banabi_vendor() {
        MahalleVendor banabiVendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        getScenarioContext().setContext(Context.SELECTED_VENDOR, banabiVendor);
        setCurrentPlatformType("Banabi");
    }


    @When("I navigate banabi vendor")
    public void i_navigate_banabi_vendor() {
        MahalleVendor banabiVendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        MahalleVendor selectedVendor = banabiVendor;
        getScenarioContext().setContext(Context.SELECTED_VENDOR, selectedVendor);
    }

    @Given("Banabi Vendor is available")
    public void banabi_are_available() {
        IRestResponse<HomePageBanabiResponse> homePageBanabi = getCarsiHomePageClient().getBanabiVendor();
        MahalleVendor banabiVendor = homePageBanabi.getBody().getData().getVendorInfo();
        getScenarioContext().setContext(Context.BANABI_VENDOR_INFO, banabiVendor);
        getScenarioContext().setContext(Context.BANABI_VENDOR_RESPONSE, homePageBanabi);
        setCurrentPlatformType("Banabi");
    }


    @Then("Check Banabi vendor image url not empty")
    public void check_banabi_vendor_image_not_empty() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getImageUrl().isEmpty());
    }

    @Then("Check Banabi vendor id is valid")
    public void check_banabi_vendor_id_is_valid() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getId().isEmpty());
    }

    @Then("Check Banabi vendor DeliveryTimeInfo is not empty")
    public void check_banabi_vendor_DeliveryTimeInfo_is_not_empty() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getDeliveryTimeInfo().isEmpty());
    }

    @Then("Check Banabi vendor MinBasketPriceInfo is not empty")
    public void check_banabi_vendor_MinBasketPriceInfo_is_not_empty() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getMinBasketPriceInfo().isEmpty());
    }

    @Then("Check Banabi vendor DeliveryFeeInfo is not empty")
    public void check_banabi_vendor_DeliveryFeeInfo_is_not_empty() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getDeliveryFeeInfo().isEmpty());
    }

    @Then("Check Banabi vendor name is not empty")
    public void check_banabi_vendor_name_is_not_empty() {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        Assert.assertFalse(vendor.getName().isEmpty());
    }

    @Then("Check Banabi vendor IsOpen should be {string}")
    public void check_banabi_vendor_IsOpen_should_be(String isOpen) {
        MahalleVendor vendor = (MahalleVendor) getScenarioContext().getContext(Context.BANABI_VENDOR_INFO);
        boolean status = isOpen.equalsIgnoreCase("true");
        if (status) {
            assertTrue(vendor.getIsOpen(), "Banabi vendor should be open");
        } else {
            Assert.assertFalse(vendor.getIsOpen());
        }
    }


    @Then("I check all carsı vendor names is not empty")
    public void check_carsiVendor_names_is_valid() {
        List<MahalleVendor> vendorList = getHomeVendorList();

        for (MahalleVendor vendor : vendorList) {
            assertTrue(!vendor.getName().isEmpty(), "Vendor name should not empty");
        }

    }

    @Then("I check all vendor id is not empty")
    public void check_carsiVendor_id_is_valid() {
        List<MahalleVendor> vendorList = getHomeVendorList();

        for (MahalleVendor vendor : vendorList) {
            assertTrue(!vendor.getId().isEmpty(), "Vendor id should not empty");
        }

    }


    @Then("I check all carsı vendor image url status is 200")
    public void check_carsiVendor_imageUrl_is_valid() {
        List<MahalleVendor> vendorList = getHomeVendorList();

        for (MahalleVendor vendor : vendorList) {
            String imageUrl = vendor.getImageUrl();
            int statusCode = getCarsiHomePageClient().getImageUrlResponse(imageUrl).getStatusCode();
            assertTrue(statusCode == 200,
                    "\n"
                            + "Status : " + statusCode
                            +"\n"
                            + "Image url :" + imageUrl);
        }

    }

    @Given("HomePage banners are available")
    public void home_banners_are_available() {
        IRestResponse<HomePageBannersResponse> homeBanners = getCarsiHomePageClient().getHomePageBanners();
        Assert.assertTrue(homeBanners.isSuccessful());
        List<Banner> bannerList = homeBanners.getBody().getData().getBanners();
        getScenarioContext().setContext(Context.BANNER_LIST, bannerList);
    }

    @Then("HomePage banners urls are valid")
    public void check_banner_urls_is_valid() {
        List<Banner> banners = (List<Banner>) getScenarioContext().getContext(Context.BANNER_LIST);
        for (Banner banner : banners) {
            String bannerImageUrl = banner.getImageUrl();
            Response response = getCarsiHomePageClient().getImageUrlResponse(bannerImageUrl);
            assertTrue(response.getStatusCode() == 200,
                    "\n"
                            + "Expected : " + 200 + " Actual " + response.getStatusCode()
                            + "\n"
                            + " Url : "
                            + bannerImageUrl);
            Assert.assertEquals(200, response.getStatusCode());
        }
    }


    @Then("Set platform type to {string}")
    public void set_platform_type_to(String platformType) {
        setCurrentPlatformType(platformType);
    }
}

