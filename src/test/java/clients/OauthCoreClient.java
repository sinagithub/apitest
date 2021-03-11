package clients;

import apiEngine.*;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Addresses;
import apiEngine.models.response.Token;
import cucumber.TestContext;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class OauthCoreClient extends ApiClient {
    public OauthCoreClient(String baseUrl) {
        super(baseUrl);
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
        String accessToken = JsonUtil.getJsonElement(response, "access_token");

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

        TokenHelper.setToken(tokenResponse.access_token);

    }



}
