package stepDefinitions;

import apiEngine.GuidHelper;
import apiEngine.IRestResponse;
import apiEngine.Routes.InternalVendorRoute;
import apiEngine.Routes.Route;
import apiEngine.models.requests.InternalVendor.UpdateVendorRequest;
import apiEngine.models.response.BanabiAddress;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.HomePage.HomePagePlatformResponse;
import apiEngine.models.response.HomePage.PlatformData;
import apiEngine.models.response.MicroServices.InternalVendor.Category;
import apiEngine.models.response.MicroServices.InternalVendor.DeliveryType;
import apiEngine.models.response.MicroServices.InternalVendor.InternalVendorDetailResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SuppressWarnings("unchecked")
public class InternalVendorSteps extends BaseSteps {
    public InternalVendorSteps(TestContext testContext) {
        super(testContext);
    }

    private List<CarsiVendor> getHomeVendorList() {
        return (List<CarsiVendor>) getScenarioContext().getContext(Context.HOME_VENDOR_LIST);
    }

    private CarsiVendor getSelectedVendor() {
        return (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
    }

    @Then("Vendor staff close the selected shop")
    public void vendor_staff_close_the_selected_shop() {
        String selectedVendorId = getSelectedVendor().getId();
        GuidHelper.getInstance().setGuid();
        String operatingUserId = GuidHelper.getInstance().getGuid();
        ;
        getCarsiInternalVendor().setVendorClose(selectedVendorId, operatingUserId);
    }

    @Then("Vendor staff open the selected shop")
    public void vendor_staff_open_the_selected_shop() {
        String selectedVendorId = getSelectedVendor().getId();
        GuidHelper.getInstance().setGuid();
        String operatingUserId = GuidHelper.getInstance().getGuid();
        ;
        getCarsiInternalVendor().setVendorOpen(selectedVendorId, operatingUserId);
    }

    private boolean paymentMethodIsExist(List<String> vendorPaymentMethodList, String paymentMethodId) {

        for (String paymentMethod : vendorPaymentMethodList) {
            if (paymentMethod.equalsIgnoreCase(paymentMethodId)) {
                return true;
            }
        }
        return false;
    }

    private boolean paymentMethodsIsExist(List<String> vendorPaymentMethodList, List<String> expectedPaymentMethods) {
        return vendorPaymentMethodList.containsAll(expectedPaymentMethods);
    }

    @When("I select vendor with payment method {string}")
    public void i_select_vendor_with_payment_method(String paymentMethodId) {
        List<CarsiVendor> vendorList = getHomeVendorList();
        for (CarsiVendor vendor : vendorList) {
            String vendorId = vendor.getId();
            List<String> paymentsMethods = getCarsiInternalVendor().getPaymentTypes(vendorId).jsonPath().get();
            if (paymentMethodIsExist(paymentsMethods, paymentMethodId)) {
                getScenarioContext().setContext(Context.SELECTED_VENDOR, vendor);
                break;
            }
        }
    }

    @When("I select vendor with payment methods$")
    public void i_select_vendor_with_payment_methods(List<String> expectedPaymentMethodIdList) {
        List<CarsiVendor> vendorList = getHomeVendorList();
        for (CarsiVendor vendor : vendorList) {
            String vendorId = vendor.getId();
            List<String> paymentsMethods = getCarsiInternalVendor().getPaymentTypes(vendorId).jsonPath().get();
            if (paymentMethodsIsExist(paymentsMethods, expectedPaymentMethodIdList)) {
                getScenarioContext().setContext(Context.SELECTED_VENDOR, vendor);
                break;
            }
        }
    }


    @Then("Staff get selected vendor details from internal vendor service")
    public void staff_get_selected_vendor_details_from_internal_vendor() {
        String selectedVendorId = getSelectedVendor().getId();
        IRestResponse<InternalVendorDetailResponse> vendorDetailResponse =
                getCarsiInternalVendor().getVendorDetail(selectedVendorId);
        getScenarioContext().setContext(Context.INTERNAL_VENDOR_DETAIL, vendorDetailResponse);
    }

    private IRestResponse<InternalVendorDetailResponse> getSelectedVendorDetail() {
        return (IRestResponse<InternalVendorDetailResponse>) getScenarioContext().getContext(Context.INTERNAL_VENDOR_DETAIL);
    }

    @Then("Staff update vendor payment method$")
    public void staff_update_vendor_payment_method(List<String> paymentMethodList) {
        BanabiAddress banabiAddress = (BanabiAddress) getScenarioContext().getContext(Context.ADDRESS);
        GuidHelper.getInstance().setGuid();
        String selectedVendorId = getSelectedVendor().getId();
        String operatingUserId = "12345";
        IRestResponse<InternalVendorDetailResponse> internalVendorDetails = getSelectedVendorDetail();
        String name = internalVendorDetails.getBody().getName();
        String cityId = internalVendorDetails.getBody().getCity();
        String area = internalVendorDetails.getBody().getArea();
        String email = internalVendorDetails.getBody().getEmail();
        String phone = internalVendorDetails.getBody().getPhone();
        String address = internalVendorDetails.getBody().getAddress();
        String areaId = banabiAddress.getAreaId();
        int latitude = internalVendorDetails.getBody().getLatitude();
        int longitude = internalVendorDetails.getBody().getLongitude();
        int minDeliveryTime = internalVendorDetails.getBody().getMinDeliveryMinutes();
        int maxDeliveryMinutes = internalVendorDetails.getBody().getMaxDeliveryMinutes();
        int minBasketAmount = internalVendorDetails.getBody().getMinBasketAmount();
        int maxBasketCapacity = internalVendorDetails.getBody().getMaxBasketCapacity();
        double deliveryFee = internalVendorDetails.getBody().getDeliveryFee();
        String logoUrl = internalVendorDetails.getBody().getLogoUrl();
        String brandImageUrl = internalVendorDetails.getBody().getBrandImageUrl();
        boolean acceptFutureOrder = internalVendorDetails.getBody().getAcceptsFutureOrder();
        boolean isTipAvailable = internalVendorDetails.getBody().getIsTipAvailable();
        List<DeliveryType> deliveryTypes = internalVendorDetails.getBody().getDeliveryTypes();
        List<Category> categoryList = internalVendorDetails.getBody().getCategories();

        UpdateVendorRequest updateVendorRequest = new UpdateVendorRequest(
                name,
                cityId,
                areaId, area,
                email, phone,
                address, latitude,
                longitude, minDeliveryTime,
                maxDeliveryMinutes, minBasketAmount,
                maxBasketCapacity, deliveryFee,
                logoUrl, brandImageUrl,
                acceptFutureOrder, isTipAvailable,
                deliveryTypes, categoryList, paymentMethodList, operatingUserId);
        getCarsiInternalVendor().setVendorInformation(updateVendorRequest,selectedVendorId);
    }


    @Then("Staff update vendor delivery time method set AcceptsFutureOrder {string}")
    public void staff_update_vendor_payment_method(String acceptsFutureOrder) {
        BanabiAddress banabiAddress = (BanabiAddress) getScenarioContext().getContext(Context.ADDRESS);
        GuidHelper.getInstance().setGuid();
        String selectedVendorId = getSelectedVendor().getId();
        String operatingUserId = "12345";
        IRestResponse<InternalVendorDetailResponse> internalVendorDetails = getSelectedVendorDetail();
        String name = internalVendorDetails.getBody().getName();
        String cityId = internalVendorDetails.getBody().getCity();
        String area = internalVendorDetails.getBody().getArea();
        String email = internalVendorDetails.getBody().getEmail();
        String phone = internalVendorDetails.getBody().getPhone();
        String address = internalVendorDetails.getBody().getAddress();
        String areaId = banabiAddress.getAreaId();

        int latitude = internalVendorDetails.getBody().getLatitude();
        int longitude = internalVendorDetails.getBody().getLongitude();
        int minDeliveryTime = internalVendorDetails.getBody().getMinDeliveryMinutes();
        int maxDeliveryMinutes = internalVendorDetails.getBody().getMaxDeliveryMinutes();
        int minBasketAmount = internalVendorDetails.getBody().getMinBasketAmount();
        int maxBasketCapacity = internalVendorDetails.getBody().getMaxBasketCapacity();
        double deliveryFee = internalVendorDetails.getBody().getDeliveryFee();
        String logoUrl = internalVendorDetails.getBody().getLogoUrl();
        String brandImageUrl = internalVendorDetails.getBody().getBrandImageUrl();
        boolean isTipAvailable = internalVendorDetails.getBody().getIsTipAvailable();
        List<String> paymentMethodList = Arrays.asList("111fb8a2-45a4-4e09-8a10-4d7d94d70be3", "de2e3a82-8b55-4334-8a2e-467fe7f7db24");

        boolean acceptFutureOrder = true;
        if (acceptsFutureOrder.equalsIgnoreCase("True")){
            acceptFutureOrder = true;
        }
        else {
            acceptFutureOrder = false;
        }


        List<DeliveryType> deliveryTypes = internalVendorDetails.getBody().getDeliveryTypes();
        List<Category> categoryList = internalVendorDetails.getBody().getCategories();

        UpdateVendorRequest updateVendorRequest = new UpdateVendorRequest(
                name,
                cityId,
                areaId, area,
                email, phone,
                address, latitude,
                longitude, minDeliveryTime,
                maxDeliveryMinutes, minBasketAmount,
                maxBasketCapacity, deliveryFee,
                logoUrl, brandImageUrl,
                acceptFutureOrder, isTipAvailable,
                deliveryTypes, categoryList, paymentMethodList, operatingUserId);
        getCarsiInternalVendor().setVendorInformation(updateVendorRequest,selectedVendorId);
    }


}
