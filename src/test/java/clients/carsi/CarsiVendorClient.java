package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.Vendor.VendorProductsResponse;
import apiEngine.models.response.Vendor.VendorResponse;
import io.restassured.response.Response;

public class CarsiVendorClient extends CarsiClient {
    public CarsiVendorClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<VendorProductsResponse> getProducts(String vendorId, String categoryId, int offset) {
        Response response = request.pathParam("vendorId", vendorId)
                .queryParam("categoryId", categoryId)
                .queryParam("offset", offset)
                .get(Route.getVendorProducts());
        writeStepLog();
        return new RestResponse(VendorProductsResponse.class, response);
    }

    public IRestResponse<VendorResponse> getVendor(String vendorId){
        Response response = request.pathParam("vendorId", vendorId)
                .get(Route.getVendor());
        writeStepLog();
        return new RestResponse<>(VendorResponse.class, response);
    }




}
