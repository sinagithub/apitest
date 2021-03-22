package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.requests.Basket.Campaigns.ApplyCampaignRequest;
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
        Response response = request.queryParam("addressId", addressId)
                .get(Route.getBasketId());
        return new RestResponse<>(BasketIdResponse.class, response);
    }

    public IRestResponse<GetBasketResponse> getBasket(String basketId) {
        Response response = request
                .pathParam("id", basketId)
                .get(Route.getBasket());
        return new RestResponse<>(GetBasketResponse.class, response);
    }

    public IRestResponse<GetBasketResponse> getBasketLite(String basketId) {
        Response response = request
                .pathParam("id", basketId)
                .get(Route.getBasketLite());
        return new RestResponse<>(GetBasketResponse.class, response);
    }

    public IRestResponse<DeleteBasketResponse> deleteBasket(String basketId) {
        Response response = request
                .pathParam("id", basketId)
                .delete(Route.getBasket());
        return new RestResponse<>(DeleteBasketResponse.class, response);
    }

    public IRestResponse<GetCampaignsResponse> getCampaigns(String basketId) {
        Response response = request
                .pathParam("id", basketId)
                .get(Route.getCampaign());
        return new RestResponse<>(GetCampaignsResponse.class, response);
    }

    public IRestResponse<GetCampaignsResponse> applyCampaign(String basketId,
                                                             ApplyCampaignRequest applyCampaignRequest) {
        Response response = request
                .pathParam("id", basketId)
                .body(applyCampaignRequest)
                .post(Route.getCampaign());
        return new RestResponse<>(GetCampaignsResponse.class, response);
    }
}
