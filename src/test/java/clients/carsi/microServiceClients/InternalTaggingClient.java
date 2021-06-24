package clients.carsi.microServiceClients;

import apiEngine.MicroBaseClient;
import apiEngine.Routes.TaggingRoute;
import apiEngine.models.requests.InternalVendor.Tagging.UserTagRequest;
import io.restassured.response.Response;

public class InternalTaggingClient extends MicroBaseClient {

    public InternalTaggingClient(String baseUrl) {
        super(baseUrl);
    }

    public Response setUserTag(UserTagRequest userTagRequest){
        Response response = createRequest()
                .body(userTagRequest)
                .post(TaggingRoute.getUserTag());
        writeStepLog();
        return response;
    }

}
