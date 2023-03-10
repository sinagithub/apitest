package clients.carsi;

import apiEngine.RestResponse;
import apiEngine.Routes.Route;
import apiEngine.models.response.Splash.SplashResponse;
import io.restassured.response.Response;

public class CarsiSplashClient extends CarsiClient {
    public CarsiSplashClient(String baseUrl) {
        super(baseUrl);
    }

    public RestResponse getSplash(){
        Response response = createRequest()
                .get(Route.getSplash());
        writeStepLog();
        return new RestResponse(SplashResponse.class, response);
    }
}
