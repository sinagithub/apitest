package clients.carsi.microServiceClients;

import apiEngine.ApiClient;
import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.InternalVendorRoute;
import apiEngine.models.requests.InternalVendor.SetVendorWorkingDaysRequest;
import apiEngine.models.requests.InternalVendor.UpdateVendorRequest;
import apiEngine.models.response.MicroServices.InternalVendor.InternalVendorBasicResponse;
import apiEngine.models.response.MicroServices.InternalVendor.InternalVendorDetailResponse;
import io.restassured.response.Response;

public class CarsiInternalVendorClient extends ApiClient {

    public CarsiInternalVendorClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<InternalVendorBasicResponse> getVendorBasic(String vendorId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .get(InternalVendorRoute.getVendorBasic());
        writeStepLog();
        return new RestResponse<>(InternalVendorBasicResponse.class, response);
    }

    public Response setVendorClose(String vendorId, String operatingUserId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .queryParam("operatingUserId",operatingUserId)
                .put(InternalVendorRoute.closeVendor());
        writeStepLog();
        return response;
    }

    public Response setVendorOpen(String vendorId, String operatingUserId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .queryParam("operatingUserId",operatingUserId)
                .put(InternalVendorRoute.openVendor());
        writeStepLog();
        return response;
    }

    public Response getPaymentTypes(String vendorId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .get(InternalVendorRoute.vendorPaymentTypes());
        writeStepLog();
        return response;
    }

    public IRestResponse<InternalVendorDetailResponse> getVendorDetail(String vendorId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .get(InternalVendorRoute.getVendor());
        writeStepLog();
        return new RestResponse<>(InternalVendorDetailResponse.class, response);
    }

    public Response setVendorInformation(UpdateVendorRequest updateVendorRequest, String vendorId){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .body(updateVendorRequest)
                .put(InternalVendorRoute.getVendor());
        writeStepLog();
        return response;
    }

    public Response setVendorWorkingDay(String vendorId, SetVendorWorkingDaysRequest setVendorWorkingDaysRequest){
        Response response = createRequest()
                .pathParam("vendorId",vendorId)
                .body(setVendorWorkingDaysRequest)
                .put(InternalVendorRoute.getWorkingDay());
        writeStepLog();
        return response;
    }

}
