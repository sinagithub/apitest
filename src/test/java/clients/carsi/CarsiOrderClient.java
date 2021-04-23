package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.Route;
import apiEngine.models.response.Order.ActiveOrdersResponse;
import io.restassured.response.Response;


public class CarsiOrderClient extends CarsiClient {
    public CarsiOrderClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<ActiveOrdersResponse> getActiveOrders() {
        Response response = request
                .get(Route.getActiveOrders());
        return new RestResponse<>(ActiveOrdersResponse.class, response);
    }


}
