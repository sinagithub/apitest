package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.JsonUtil;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Addresses;
import apiEngine.models.response.Token;
import clients.CarsiClient;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class CarsiUserClient extends CarsiClient {
    public CarsiUserClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<Addresses> getAddresses(String catalogName) {
        Response response = request.
                queryParam("PrimaryCatalogName",catalogName)
                .header("YS-Catalog",catalogName)
                .get(Route.availableAddresses());
        return new RestResponse(Addresses.class, response);
    }
}
