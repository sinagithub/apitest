package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.BasketRoute;
import apiEngine.Routes.Route;
import apiEngine.models.requests.Basket.AddProductWithoutCampaignToBasketReq;
import apiEngine.models.response.Basket.*;
import apiEngine.models.response.DeleteBasketResponse;
import io.restassured.response.Response;


public class CarsiBasketClient extends CarsiClient {

    public CarsiBasketClient(String baseUrl) {
        super(baseUrl);
    }


    public IRestResponse<BasketIdResponse> getBasketId(String addressId) {
        Response response = createRequest().queryParam("addressId", addressId)
                .get(BasketRoute.getBasketId());
        writeStepLog();
        return new RestResponse<>(BasketIdResponse.class, response);
    }

    public IRestResponse<AddProductToBasketResponse> addProduct(String basketId,
                                                                AddProductWithoutCampaignToBasketReq addProductWithoutCampaignToBasketReq) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .body(addProductWithoutCampaignToBasketReq)
                .post(BasketRoute.getAddProduct());
        writeStepLog();
        return new RestResponse<>(AddProductToBasketResponse.class, response);
    }

    public IRestResponse<DeleteBasketResponse> deleteBasket(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .delete(BasketRoute.getBasket());
        writeStepLog();
        return new RestResponse<>(DeleteBasketResponse.class, response);
    }

    public IRestResponse<BasketResponse> getBasket(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(BasketRoute.getBasket());
        writeStepLog();
        return new RestResponse<>(BasketResponse.class, response);
    }

    public IRestResponse<LiteBasketResponse> getLiteBasket(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(BasketRoute.getBasketLite());
        writeStepLog();
        return new RestResponse<>(LiteBasketResponse.class, response);
    }

    public IRestResponse<AlternateProductResponse> getAlternateOptions(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(BasketRoute.getAlternateProductOptions());
        writeStepLog();
        return new RestResponse<>(AlternateProductResponse.class, response);
    }
}
