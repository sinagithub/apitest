package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.Route;
import apiEngine.models.response.ProductDetail.ProductResponse;
import io.restassured.response.Response;

public class CarsiProductClient extends CarsiClient {
    public CarsiProductClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<ProductResponse> getProduct(String productId, String vendorId, String basketId) {
        Response response = request
                .pathParam("productId", productId)
                .queryParam("vendorId", vendorId)
                .queryParam("basketId", basketId)
                .get(Route.getProduct());
        writeStepLog();
        return new RestResponse(ProductResponse.class, response);
    }


}
