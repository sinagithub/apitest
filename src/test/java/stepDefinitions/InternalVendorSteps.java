package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.Utilies.GuidHelper;
import apiEngine.Utilies.Utils;
import apiEngine.models.requests.InternalVendor.SetVendorWorkingDaysRequest;
import apiEngine.models.requests.InternalVendor.UpdateVendorRequest;
import apiEngine.models.requests.InternalVendor.WorkingDay;
import apiEngine.models.response.Address.AvailableAddressData;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.MicroServices.InternalVendor.Category;
import apiEngine.models.response.MicroServices.InternalVendor.DeliveryType;
import apiEngine.models.response.MicroServices.InternalVendor.InternalVendorDetailResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


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

    private AvailableAddressData getSelectedAddress(){
      return (AvailableAddressData) getScenarioContext().getContext(Context.ADDRESS);
    }

    @Then("Vendor staff close the selected shop")
    public void vendor_staff_close_the_selected_shop() {
        String selectedVendorId = getSelectedVendor().getId();
        GuidHelper.getInstance().setGuid();
        String operatingUserId = GuidHelper.getInstance().getGuid();
        getCarsiInternalVendorClient().setVendorClose(selectedVendorId, operatingUserId);
    }

    @Then("Vendor staff open the selected shop")
    public void vendor_staff_open_the_selected_shop() {
        String selectedVendorId = getSelectedVendor().getId();
        GuidHelper.getInstance().setGuid();
        String operatingUserId = GuidHelper.getInstance().getGuid();
        getCarsiInternalVendorClient().setVendorOpen(selectedVendorId, operatingUserId);
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
            List<String> paymentsMethods = getCarsiInternalVendorClient().getPaymentTypes(vendorId).jsonPath().get();
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
            List<String> paymentsMethods = getCarsiInternalVendorClient().getPaymentTypes(vendorId).jsonPath().get();
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
                getCarsiInternalVendorClient().getVendorDetail(selectedVendorId);
        getScenarioContext().setContext(Context.INTERNAL_VENDOR_DETAIL, vendorDetailResponse);
    }

    private IRestResponse<InternalVendorDetailResponse> getSelectedVendorDetail() {
        return (IRestResponse<InternalVendorDetailResponse>) getScenarioContext().getContext(Context.INTERNAL_VENDOR_DETAIL);
    }

    @Then("Staff update vendor payment method$")
    public void staff_update_vendor_payment_method(List<String> paymentMethodList) {
       AvailableAddressData selectedAddress = getSelectedAddress();
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
        String areaId = selectedAddress.getAreaId();
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
        getCarsiInternalVendorClient().setVendorInformation(updateVendorRequest, selectedVendorId);
    }


    @Then("Staff update vendor delivery time method set AcceptsFutureOrder {string}")
    public void staff_update_vendor_payment_method(String acceptsFutureOrder) {
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
        String areaId = getSelectedAddress().getAreaId();

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
        List<String> paymentMethodList = Arrays.asList("111fb8a2-45a4-4e09-8a10-4d7d94d70be3", "de2e3a82-8b55-4334" +
                "-8a2e-467fe7f7db24");

        boolean acceptFutureOrderReq;
        acceptFutureOrderReq = acceptsFutureOrder.equalsIgnoreCase("True");


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
                acceptFutureOrderReq, isTipAvailable,
                deliveryTypes, categoryList, paymentMethodList, operatingUserId);
        getCarsiInternalVendorClient().setVendorInformation(updateVendorRequest, selectedVendorId);
    }

    @Then("Staff create working pool for selected vendor")
    public void staff_create_working_pool_for_selected_vendor() {
        List<WorkingDay> workingDays = new ArrayList<>();
        getScenarioContext().setContext(Context.WORK_DAY_POOL, workingDays);
    }

    @Then("Staff select working day DayOfWeek {int}, StartHour {int}, StartMinute {int}, EndHour {int}, EndMinute " +
            "{int}")
    public void staff_select_working_day_of_week_start_hour_start_minute_end_hour_end_minute(Integer dayOfWeek,
                                                                                             Integer startHour,
                                                                                             Integer startMinute,
                                                                                             Integer endHour,
                                                                                             Integer endMinute) {
        List<WorkingDay> workingDayPool = (List<WorkingDay>) getScenarioContext().getContext(Context.WORK_DAY_POOL);
        WorkingDay workingDay = new WorkingDay(dayOfWeek, startHour, startMinute, endHour, endMinute);
        workingDayPool.add(workingDay);
        getScenarioContext().setContext(Context.WORK_DAY_POOL, workingDayPool);

    }

    @Then("Staff update vendor working days with selected times for deliveryInterval {int}")
    public void staff_update_vendor_working_days_with_selected_times(int deliveryInterval) throws IOException {
        String selectedVendorId = getSelectedVendor().getId();
        String operationUserId = Utils.getGlobalValue("internalOperationUserId");
        List<WorkingDay> workingDayPool = (List<WorkingDay>) getScenarioContext().getContext(Context.WORK_DAY_POOL);
        SetVendorWorkingDaysRequest setVendorWorkingDaysRequest = new SetVendorWorkingDaysRequest(deliveryInterval,
                workingDayPool, operationUserId);
        getCarsiInternalVendorClient().setVendorWorkingDay(selectedVendorId, setVendorWorkingDaysRequest);
    }

    @Then("Staff select vendor workday for only tomorrow StartHour {int}, StartMinute {int}, EndHour {int}, EndMinute" +
            " {int}")
    public void staff_select_vendor_workday_for_only_tomorrow(int startHour, int startMinute, int endHour,
                                                              int endMinute) {
        int nextDayOfWeek = LocalDate.now().getDayOfWeek().getValue() + 1;
        staff_select_working_day_of_week_start_hour_start_minute_end_hour_end_minute(nextDayOfWeek,startHour,startMinute,endHour,endMinute);

    }



}
