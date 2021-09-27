package clients.carsi.microServiceClients;

import apiEngine.MicroBaseClient;
import apiEngine.Routes.TaggingRoute;
import apiEngine.models.requests.InternalVendor.Tagging.TagRequest;
import io.restassured.response.Response;

public class InternalTaggingClient extends MicroBaseClient {

    public InternalTaggingClient(String baseUrl) {
        super(baseUrl);
    }

    public Response createUserTag(TagRequest tagRequest){
        Response response = createRequest()
                .body(tagRequest)
                .post(TaggingRoute.getUserTag());
        writeStepLog();
        return response;
    }

    public Response createVendorTag(TagRequest tagRequest){
        Response response = createRequest()
                .body(tagRequest)
                .post(TaggingRoute.getVendorTag());
        writeStepLog();
        return response;
    }

    public Response deleteUserTag(String tagId, String deletedUserId, String deletedUserName){
        Response response = createRequest()
                .pathParam("id", tagId)
                .queryParam("deletedUserId",deletedUserId)
                .queryParam("deletedUserName", deletedUserName)
                .delete(TaggingRoute.deleteUserTag());
        writeStepLog();
        return response;
    }

    public Response deleteVendorTag(String tagId, String deletedUserId, String deletedUserName){
        Response response = createRequest()
                .pathParam("id", tagId)
                .queryParam("deletedUserId",deletedUserId)
                .queryParam("deletedUserName", deletedUserName)
                .delete(TaggingRoute.deleteVendorTag());
        writeStepLog();
        return response;
    }

}
