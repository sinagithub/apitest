package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.Route;
import apiEngine.Routes.VendorRoute;
import apiEngine.models.response.Vendor.VendorProductSearchResponse;
import apiEngine.models.response.Vendor.VendorProductsResponse;
import apiEngine.models.response.Vendor.VendorResponse;
import io.restassured.response.Response;

@SuppressWarnings("unchecked")
public class CarsiVendorClient extends CarsiClient {
    public CarsiVendorClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<VendorProductsResponse> getProducts(String vendorId, String categoryId, int offset) {
        Response response = createRequest().pathParam("vendorId", vendorId)
                .queryParam("categoryId", categoryId)
                .queryParam("offset", offset)
                .get(VendorRoute.getVendorProducts());
        writeStepLog();
        return new RestResponse<>(VendorProductsResponse.class, response);
    }

    public IRestResponse<VendorResponse> getVendor(String vendorId) {
        Response response = createRequest().pathParam("vendorId", vendorId)
                .get(VendorRoute.getVendor());
        writeStepLog();
        return new RestResponse<>(VendorResponse.class, response);
    }

    public IRestResponse<VendorProductSearchResponse> searchProduct(String vendorId, String searchText, int pageIndex) {
        Response response = createRequest().
                pathParam("vendorId", vendorId)
                .queryParam("searchText", searchText)
                .queryParam("pageIndex", pageIndex)
                .get(VendorRoute.getVendorProductSearch());
        return new RestResponse<>(VendorProductSearchResponse.class, response);
    }

}
