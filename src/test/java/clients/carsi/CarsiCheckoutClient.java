package clients.carsi;


import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.CheckOutRoute;
import apiEngine.models.requests.Checkout.PostCheckoutRequest;
import apiEngine.models.response.CheckOut.PostCheckoutResponse;
import io.restassured.response.Response;

public class CarsiCheckoutClient extends CarsiClient {
    public CarsiCheckoutClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<PostCheckoutResponse> postCheckout(PostCheckoutRequest postCheckoutRequest){
        Response response = createRequest()
                .body(postCheckoutRequest)
                .post(CheckOutRoute.postCheckout());
        writeStepLog();
        return new RestResponse<>(PostCheckoutResponse.class, response);
    }

}
