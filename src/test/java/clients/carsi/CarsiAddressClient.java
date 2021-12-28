package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.AddressRoute;
import apiEngine.models.requests.Address.AddAddressRequest;
import apiEngine.models.response.Address.*;
import io.restassured.response.Response;
import java.io.UnsupportedEncodingException;

public class CarsiAddressClient extends CarsiClient{

    public CarsiAddressClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<AvailableAddressResponse> getAddresses() {
        Response response = createRequest()
                .get(AddressRoute.getAvailable());
        writeStepLog();
        return new RestResponse<>(AvailableAddressResponse.class, response);
    }

    public IRestResponse<AddressActionResponse> getAddressAction(String addressId, String areaId) {
        Response response = createRequest()
                .queryParam("addressId", addressId)
                .queryParam("areaId", areaId)
                .get(AddressRoute.getAction());
        writeStepLog();
        return new RestResponse<>(AddressActionResponse.class, response);
    }

    public IRestResponse<AddAddressResponse> postAddress(AddAddressRequest addAddressRequest) {
        Response response = createRequest()
                .body(addAddressRequest)
                .post(AddressRoute.getAddress());
        writeStepLog();
        return new RestResponse<>(AddAddressResponse.class, response);
    }

    public IRestResponse<AddressDetailResponse> getAddressDetail(String addressId) {
        Response response = createRequest()
                .pathParam("addressId", addressId)
                .get(AddressRoute.getAddressDetail());
        writeStepLog();
        return new RestResponse<>(AddressDetailResponse.class, response);
    }

    public IRestResponse<DeleteAddressResponse> deleteAddress(String addressId) {
        Response response = createRequest()
                .pathParam("addressId", addressId)
                .delete(AddressRoute.getAddressDetail());
        writeStepLog();
        return new RestResponse<>(DeleteAddressResponse.class, response);
    }

    public IRestResponse<AddAddressResponse> editAddress(String addressId, AddAddressRequest addAddressRequest) throws UnsupportedEncodingException {
        Response response = createRequest()
                .pathParam("addressId",urlEncodeString(addressId))
                .body(addAddressRequest)
                .put(AddressRoute.getAddressDetail());
        writeStepLog();
        return new RestResponse<>(AddAddressResponse.class, response);
    }


    public IRestResponse<AvailableAddressResponse> getAvailableCheckout(String basketId, String vendorId) {
        Response response = createRequest()
                .queryParam("basketId", basketId)
                .queryParam("vendorId", vendorId)
                .get(AddressRoute.getAvailableCheckout());
        writeStepLog();
        return new RestResponse<>(AvailableAddressResponse.class, response);
    }
}
