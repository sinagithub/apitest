package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.ProductDetail.ProductDetailResponse;
import io.restassured.response.Response;

public class CarsiProductClient extends CarsiClient {
    public CarsiProductClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<ProductDetailResponse> getProduct(String catalogName, String productId) {
        Response response = request
                .header("YS-Catalog", catalogName)
                .pathParam("productId", productId)
                .get(Route.getProduct());
        writeStepLog();
        return new RestResponse(ProductDetailResponse.class, response);
    }
}