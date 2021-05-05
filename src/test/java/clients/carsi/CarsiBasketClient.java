package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.BasketRoute;
import apiEngine.Routes.Route;
import apiEngine.models.requests.Basket.AddProductReq;
import apiEngine.models.requests.Basket.Campaigns.ApplyCampaignRequest;
import apiEngine.models.response.Basket.AddProductResponse;
import apiEngine.models.response.Basket.BasketIdResponse;
import apiEngine.models.response.Basket.Campaign.GetCampaignsResponse;
import apiEngine.models.response.Basket.DeleteBasketResponse;
import apiEngine.models.response.Basket.GetBasketResponse;
import io.restassured.response.Response;


public class CarsiBasketClient extends CarsiClient {

    public CarsiBasketClient(String baseUrl) {
        super(baseUrl);
    }


    public IRestResponse<BasketIdResponse> getBasketId(String addressId) {
        Response response = createRequest().queryParam("addressId", addressId)
                .get(Route.getBasketId());
        writeStepLog();
        return new RestResponse<>(BasketIdResponse.class, response);
    }

    public IRestResponse<GetBasketResponse> getBasketInfo(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(Route.getBasket());
        writeStepLog();
        return new RestResponse<>(GetBasketResponse.class, response);
    }

    public IRestResponse<GetBasketResponse> getBasketLite(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(Route.getBasketLite());
        writeStepLog();
        return new RestResponse<>(GetBasketResponse.class, response);
    }

    public IRestResponse<DeleteBasketResponse> deleteBasket(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .delete(Route.getBasket());
        writeStepLog();
        return new RestResponse<>(DeleteBasketResponse.class, response);
    }

    public IRestResponse<GetCampaignsResponse> getCampaigns(String basketId) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .get(Route.getCampaign());
        return new RestResponse<>(GetCampaignsResponse.class, response);

    }

    public IRestResponse<GetCampaignsResponse> applyCampaign(String basketId,
                                                             ApplyCampaignRequest applyCampaignRequest) {
        Response response = createRequest()
                .pathParam("id", basketId)
                .body(applyCampaignRequest)
                .post(Route.getCampaign());
        writeStepLog();
        return new RestResponse<>(GetCampaignsResponse.class, response);
    }

    public IRestResponse<AddProductResponse> addProduct(String basketId, AddProductReq addProductReq){
        Response response = createRequest().
                pathParam("id", basketId)
                .body(addProductReq)
                .post(BasketRoute.getAddProduct());
        writeStepLog();
        return new RestResponse<>(AddProductResponse.class, response);
    }

}
