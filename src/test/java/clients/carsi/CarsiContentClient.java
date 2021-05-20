package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.BasketRoute;
import apiEngine.Routes.ContentRoute;
import apiEngine.models.response.Content.FaqResponse;
import apiEngine.models.response.DeleteBasketResponse;
import io.restassured.response.Response;

public class CarsiContentClient extends CarsiClient {
    public CarsiContentClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<FaqResponse> getFaqResponse() {
        Response response = createRequest()
                .get(ContentRoute.getFaq());
        writeStepLog();
        return new RestResponse<>(FaqResponse.class, response);
    }


}
