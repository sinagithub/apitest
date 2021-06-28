package clients.carsi.microServiceClients;

import apiEngine.ApiClient;
import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.MarketingRoute;
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

}
