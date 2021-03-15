package clients;

import apiEngine.*;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Token;
import cucumber.TestContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import stepDefinitions.BaseSteps;

public class OauthCoreClient extends ApiClient {
    String baseUrl;
    public OauthCoreClient(String baseUrl) {
        super(baseUrl);
        this.baseUrl = baseUrl;
    }

    private String client_id = "E369A71D-2D0F-4D9F-B6C5-932081BD66CB";
    private String grant_type = "client_credentials";
    public static RequestSpecification tokenRequest;

    public void authenticateUser(AuthorizationRequest authRequest, boolean isLogged) {
        tokenRequest = RestAssured.given();
        tokenRequest.baseUri(baseUrl);
        tokenRequest.header("Content-Type", "application/json");
        tokenRequest.header("YS-Culture", "tr-TR");

        Token tokenResponse;
        Response response = tokenRequest.
                queryParam("client_id", client_id)
                .queryParam("grant_type", grant_type).post(Route.generateAccessToken());

        if (response.getStatusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response.toString() +
                    " , Status Code : " + response.statusCode());
        }
        String accessToken = JsonUtil.getJsonElement(response, "access_token");

        if (isLogged) {
            Response loginTokenResponse = tokenRequest.header("Authorization", "Bearer " + accessToken).body(authRequest)
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

        TokenHelper.getInstance().setToken(tokenResponse.access_token);

    }

    public void resetToken(){
    }



}
