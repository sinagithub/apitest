package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.ProductsResponse;
import apiEngine.models.response.VendorResponse;
import clients.CarsiClient;
import io.restassured.response.Response;

public class CarsiVendorClient extends CarsiClient {
    public CarsiVendorClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<VendorResponse> getVendor(String catalogName, String vendorId) {
        Response response = request
                .pathParam("vendorId", vendorId)
                .header("YS-Catalog",catalogName)
                .get(Route.getVendor() +"/{vendorId}");
        return new RestResponse(VendorResponse.class, response);
    }

    public IRestResponse<ProductsResponse> getProducts(String catalogName, String vendorId) {
        Response response = request
                .pathParam("vendorId", vendorId)
                .header("YS-Catalog",catalogName)
                .get(Route.getProducts());
        return new RestResponse(ProductsResponse.class, response);
    }





}
