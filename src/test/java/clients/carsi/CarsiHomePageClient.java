package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Route;
import apiEngine.models.response.Address;
import apiEngine.models.response.HomePageCarsiResponse;
import clients.CarsiClient;
import io.restassured.response.Response;

public class CarsiHomePageClient extends CarsiClient {
    public CarsiHomePageClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<HomePageCarsiResponse> getVendorList(String catalogName,
                                                              String addressId,
                                                              String areaId,
                                                              Double latitude,
                                                              Double longitude) {
        Response response = request.
                queryParam("AddressId", addressId)
                .queryParam("AreaId", areaId)
                .queryParam("Latitude", latitude)
                .queryParam("Longitude", longitude)
                .header("YS-Catalog", catalogName)
                .get(Route.homepageCarsi());

        return new RestResponse(HomePageCarsiResponse.class, response);
    }

}
