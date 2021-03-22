package clients.carsi;

import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.Splash.SplashResponse;
import io.restassured.response.Response;

public class CarsiSplashClient extends CarsiClient {
    public CarsiSplashClient(String baseUrl) {
        super(baseUrl);
    }

    public RestResponse getSplash(){
        Response response = request
                .get(Route.getSplash());
        writeStepLog();
        return new RestResponse(SplashResponse.class, response);
    }
}
