package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.AddressRoute;
import apiEngine.models.response.Address.AvailableAddressResponse;
import io.restassured.response.Response;

public class CarsiAddressClient extends CarsiClient {
    public CarsiAddressClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<AvailableAddressResponse> getAddresses() {
        Response response = createRequest()
                .get(AddressRoute.getAvailable());
        return new RestResponse(AvailableAddressResponse.class, response);
    }
}
