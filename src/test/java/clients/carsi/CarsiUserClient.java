package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.AddressResponse;
import io.restassured.response.Response;

public class CarsiUserClient extends CarsiClient {
    public CarsiUserClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<AddressResponse> getAddresses(String catalogName) {
        Response response = request.
                queryParam("PrimaryCatalogName",catalogName)
                .get(Route.availableAddresses());
        return new RestResponse(AddressResponse.class, response);
    }
}
