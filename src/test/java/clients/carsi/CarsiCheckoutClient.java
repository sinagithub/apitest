package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.PaymentRoute;
import apiEngine.models.response.Payment.UserCardsResponse;
import io.restassured.response.Response;

public class CarsiCheckoutClient extends CarsiClient {
    public CarsiCheckoutClient(String baseUrl) {
        super(baseUrl);
    }

}
