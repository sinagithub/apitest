package clients.carsi.microServiceClients;

import apiEngine.ApiClient;
import apiEngine.Routes.TaggingRoute;
import apiEngine.models.requests.InternalVendor.Marketing.PostCampaignRequest;
import io.restassured.response.Response;

public class InternalMarketingClient extends ApiClient {

    public InternalMarketingClient(String baseUrl) {
        super(baseUrl);
    }

    public Response createCampaign(PostCampaignRequest postCampaignRequest, String operatingUserEmail){
        Response response = createRequest()
                .body(postCampaignRequest)
                .post(TaggingRoute.getUserTag());
        writeStepLog();
        return response;
    }
}
