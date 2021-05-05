package clients.carsi;

import apiEngine.PlatformTypeHelper;
import apiEngine.RestResponse;
import apiEngine.Routes.FavoriteRoute;
import apiEngine.models.requests.Favorite.AddFavoriteProductRequest;
import apiEngine.models.requests.Favorite.AddFavoriteVendorRequest;
import apiEngine.models.response.Favorite.GetFavoritesResponse;
import apiEngine.models.response.Favorite.VendorDeleteFavoriteResponse;
import apiEngine.models.response.Favorite.VendorPutFavoriteResponse;
import apiEngine.models.response.Favorite.VendorFavoriteResponse;
import io.restassured.response.Response;

@SuppressWarnings("unchecked")
public class CarsiFavoriteClient extends CarsiClient {
    public CarsiFavoriteClient(String baseUrl) {
        super(baseUrl);
    }


    public RestResponse<GetFavoritesResponse> getFavoriteList(Double latitude, Double longitude) {
        Response response = createRequest()
                .header("X-Address-Lat", latitude)
                .header("X-Address-Long", longitude)
                .get(FavoriteRoute.getFavorite());
        return new RestResponse(GetFavoritesResponse.class, response);
    }

    public RestResponse<VendorFavoriteResponse> getFavoriteVendorDetail(String vendorId,
                                                                        double latitude,
                                                                        double longitude
                                                                        ) {
        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .header("X-Address-Lat", latitude)
                .header("X-Address-Long", longitude)
                .header("PlatformType",PlatformTypeHelper.getInstance().getPlatformType())
                .get(FavoriteRoute.getFavoriteVendorDetail());
        return new RestResponse<>(VendorFavoriteResponse.class, response);
    }


    public RestResponse<VendorPutFavoriteResponse> addProductToFavorite(String vendorId,
                                                                        AddFavoriteProductRequest addFavoriteProductRequest) {

        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .body(addFavoriteProductRequest)
                .put(FavoriteRoute.getAddFavoriteProduct());
        return new RestResponse<>(VendorPutFavoriteResponse.class, response);
    }

    public RestResponse<VendorPutFavoriteResponse> addVendorToFavorite(AddFavoriteVendorRequest addFavoriteVendorRequest) {

        Response response = createRequest()
                .body(addFavoriteVendorRequest)
                .put(FavoriteRoute.getAddFavoriteVendor());
        return new RestResponse<>(VendorPutFavoriteResponse.class, response);
    }

    public RestResponse<VendorDeleteFavoriteResponse> deleteFavoriteProduct(String productId, String vendorId,
                                                                            String platformType, double lat, double lng) {

        if (platformType.equalsIgnoreCase("1")){
            PlatformTypeHelper.getInstance().setPlatformType("Carsi");
        }
        else {
            PlatformTypeHelper.getInstance().setPlatformType("Banabi");
        }
        Response response = createRequest()
                .pathParam("productId", productId)
                .pathParam("vendorId", vendorId)
                .header("X-Address-Lat", lat)
                .header("X-Address-Long", lng)
                .header("PlatformType",PlatformTypeHelper.getInstance().getPlatformType())
                .delete(FavoriteRoute.getDeleteFavoriteProduct());
        return new RestResponse<>(VendorDeleteFavoriteResponse.class, response);
    }

    public RestResponse<VendorDeleteFavoriteResponse> deleteFavoriteVendor(String vendorId,
                                                                          double lat, double lng){

        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .header("X-Address-Lat", lat)
                .header("X-Address-Long", lng)
                .header("PlatformType",PlatformTypeHelper.getInstance().getPlatformType())
                .delete(FavoriteRoute.getDeleteVendor());
        return new RestResponse<>(VendorDeleteFavoriteResponse.class, response);
    }

}
