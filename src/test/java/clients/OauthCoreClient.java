package clients;

import apiEngine.ApiClient;
import apiEngine.Route;
import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Token;
import cucumber.TestContext;
import enums.Context;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class OauthCoreClient extends ApiClient {
    public OauthCoreClient() {
        super("https://oauthcore.yemeksepeti.com");
    }

    private String client_id = "E369A71D-2D0F-4D9F-B6C5-932081BD66CB";
    private String grant_type = "client_credentials";


    public void authenticateUser(AuthorizationRequest authRequest, boolean isLogged) {

        Token tokenResponse;
        Response response = request.queryParam("client_id", client_id)
                .queryParam("grant_type", grant_type).post(Route.generateAccessToken());

        if (response.getStatusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response.toString() +
                    " , Status Code : " + response.statusCode());
        }
        String accessToken = Utils.getJsonPath(response, "access_token");

        if (isLogged) {
            Response loginTokenResponse = request.header("Authorization", "Bearer " + accessToken).body(authRequest)
                    .post(Route.getLoginToken());

            if (loginTokenResponse.statusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Login Authentication Failed. Content of failed Response: " + loginTokenResponse.toString() +
                        " , Status Code : " + loginTokenResponse.statusCode());
            }
            tokenResponse = loginTokenResponse.body().jsonPath().getObject("$", Token.class);
        }

        else {
            tokenResponse = response.body().jsonPath().getObject("$", Token.class);
        }

        request.header("Authorization", "Bearer " + tokenResponse.access_token);
    }

}
