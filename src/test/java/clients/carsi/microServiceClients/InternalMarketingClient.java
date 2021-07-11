package clients.carsi.microServiceClients;

import apiEngine.ApiClient;
import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.MarketingRoute;
import apiEngine.models.requests.Campaign.CreateCompensationRequest;
import apiEngine.models.requests.Campaign.UpdateCampaignRequest;
import apiEngine.models.requests.InternalVendor.Marketing.PostCampaignRequest;
import apiEngine.models.response.MicroServices.InternalMarketing.CreateCampaignResponse;
import io.restassured.response.Response;

public class InternalMarketingClient extends ApiClient {

    public InternalMarketingClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<CreateCampaignResponse> createCampaign(PostCampaignRequest postCampaignRequest,
                                                                String operationUserEmail) {
        Response response = createRequest()
                .queryParam("operatingUserEmail", operationUserEmail)
                .body(postCampaignRequest)
                .post(MarketingRoute.getCampaign());
        writeStepLog();
        return new RestResponse<>(CreateCampaignResponse.class, response);
    }

    public Response activateCampaign( String campaignId, String operatingUserEmail){
        return createRequest()
                .pathParam("campaignId",campaignId)
                .queryParam("operatingUserEmail", operatingUserEmail)
                .put(MarketingRoute.getActivate());
    }

    public Response getCampaignDetail(String campaignId){
        Response response = createRequest()
                .pathParam("campaignId",campaignId)
                .get(MarketingRoute.getCampaignCoupon());

        writeStepLog();
        return response;
    }

    public Response deleteCampaign(String campaignId){
        Response response = createRequest()
                .pathParam("campaignId",campaignId)
                .delete(MarketingRoute.getDeleteCampaign());
        writeStepLog();
        return response;
    }

    public Response updateCampaign(String campaignId, String operatingUserEmail, UpdateCampaignRequest updateCampaignRequest){
        Response response = createRequest()
                .pathParam("campaignId",campaignId)
                .queryParam("operatingUserEmail", operatingUserEmail)
                .body(updateCampaignRequest)
                .put(MarketingRoute.getConvertCompensation());
        writeStepLog();
        return response;
    }

    public Response createCompensation(CreateCompensationRequest createCompensationRequest){
        Response response = createRequest()
                .body(createCompensationRequest)
                .post(MarketingRoute.getCompensation());
        writeStepLog();
        return response;
    }

    public Response suspendCampaign(String campaignId, String operatingUserEmail){
        Response response = createRequest()
                .pathParam("campaignId",campaignId)
                .queryParam("operatingUserEmail", operatingUserEmail)
                .put(MarketingRoute.getSuspendCampaign());
        writeStepLog();
        return response;
    }

}
