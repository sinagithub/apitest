package clients.carsi;

import apiEngine.RestResponse;
import apiEngine.Routes.CampaignRoute;
import apiEngine.Routes.Route;
import apiEngine.models.response.Campaign.CampaignCouponsResponse;
import apiEngine.models.response.Campaign.GetCampaignsResponse;
import apiEngine.models.response.Campaign.GetVendorCampaignsResponse;
import apiEngine.models.response.Splash.SplashResponse;
import io.restassured.response.Response;

public class CarsiCampaignsClient extends CarsiClient {

    public CarsiCampaignsClient(String baseUrl) {
        super(baseUrl);
    }

    public RestResponse<CampaignCouponsResponse> getCoupons(){
        Response response = createRequest()
                .get(CampaignRoute.getCoupons());
        writeStepLog();
        return new RestResponse<>(CampaignCouponsResponse.class, response);
    }

    public RestResponse<GetCampaignsResponse> getCampaigns(){
        Response response = createRequest()
                .get(CampaignRoute.getCampaign());
        writeStepLog();
        return new RestResponse<>(GetCampaignsResponse.class, response);
    }

    public RestResponse<GetVendorCampaignsResponse> getVendorCampaigns(String vendorId){
        Response response = createRequest()
                .pathParam("vendorId", vendorId)
                .get(CampaignRoute.getVendorCampaigns());
        writeStepLog();;
        return new RestResponse<>(GetVendorCampaignsResponse.class, response);
    }


}
