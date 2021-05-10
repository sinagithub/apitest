package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.Route;
import apiEngine.models.response.HomePage.HomePageBanabiResponse;
import apiEngine.models.response.HomePage.HomePageBannersResponse;
import apiEngine.models.response.HomePage.HomePageCarsiResponse;
import apiEngine.models.response.HomePage.HomePagePlatformResponse;
import io.restassured.response.Response;

@SuppressWarnings("unchecked")
public class CarsiHomePageClient extends CarsiClient {
    public CarsiHomePageClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<HomePageCarsiResponse> getVendorList(
                                                              String addressId,
                                                              String areaId,
                                                              Double latitude,
                                                              Double longitude) {

        Response response = createRequest().log().all()
                .queryParam("AddressId", addressId)
                .queryParam("AreaId", areaId)
                .queryParam("Latitude", latitude)
                .queryParam("Longitude", longitude)
                .get(Route.homepageCarsi());
        writeStepLog();
        return new RestResponse(HomePageCarsiResponse.class, response);
    }

    public IRestResponse<HomePageBanabiResponse> getBanabiVendor(
                                                                 String addressId,
                                                                 String areaId,
                                                                 Double latitude,
                                                                 Double longitude,
                                                                 String guid) {
        Response response = createRequest().
                queryParam("AddressId", addressId)
                .queryParam("AreaId", areaId)
                .queryParam("Latitude", latitude)
                .queryParam("Longitude", longitude)
                .queryParam("SessionId",guid)
                .get(Route.homepageBanabi());
        writeStepLog();
        return new RestResponse(HomePageBanabiResponse.class, response);
    }

    public IRestResponse<HomePageBannersResponse> getHomePageBanners(
                                                                     String addressId,
                                                                     String areaId,
                                                                     Double latitude,
                                                                     Double longitude) {
        Response response = createRequest().
                queryParam("AddressId", addressId)
                .queryParam("AreaId", areaId)
                .queryParam("Latitude", latitude)
                .queryParam("Longitude", longitude)
                .get(Route.homepageBanners());
        writeStepLog();
        return new RestResponse(HomePageBannersResponse.class, response);
    }

    public IRestResponse<HomePagePlatformResponse> getPlatform() {
        Response response = createRequest()
                .get(Route.homepagePlatform());
        writeStepLog();
        return new RestResponse(HomePagePlatformResponse.class, response);
    }




}
