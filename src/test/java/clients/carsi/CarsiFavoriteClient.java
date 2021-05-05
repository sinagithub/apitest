package clients.carsi;

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
                .queryParam("lat", latitude)
                .queryParam("lng", longitude)
                .get(FavoriteRoute.getFavorite());
        return new RestResponse(GetFavoritesResponse.class, response);
    }

    public RestResponse<VendorFavoriteResponse> getFavoriteVendorDetail(String vendorId,
                                                                        double latitude, double longitude) {
        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .queryParam("lat", latitude)
                .queryParam("lng", longitude)
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

    public RestResponse<VendorDeleteFavoriteResponse> deleteFavoriteProduct(String productId, String vendorId) {
        Response response = createRequest()
                .pathParam("productId", productId)
                .pathParam("vendorId", vendorId)
                .delete(FavoriteRoute.getDeleteFavoriteProduct());
        return new RestResponse<>(VendorDeleteFavoriteResponse.class, response);
    }

    public RestResponse<VendorDeleteFavoriteResponse> deleteFavoriteVendor(String vendorId){
        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .delete(FavoriteRoute.getDeleteVendor());
        return new RestResponse<>(VendorDeleteFavoriteResponse.class, response);
    }

}
