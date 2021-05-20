package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.PaymentRoute;
import apiEngine.models.response.Payment.UserCardsResponse;
import io.restassured.response.Response;

public class CarsiPaymentClient extends CarsiClient {
    public CarsiPaymentClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<UserCardsResponse> getUserCards() {
        Response response = createRequest()
                .get(PaymentRoute.getCards());
        writeStepLog();
        return new RestResponse<>(UserCardsResponse.class, response);
    }

}
