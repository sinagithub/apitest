package clients;

import apiEngine.*;
import apiEngine.Routes.Route;
import apiEngine.Utilies.TokenHelper;
import apiEngine.Utilies.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.requests.YsUserService.RegisterRequest;
import apiEngine.models.requests.YsUserService.UserData;
import apiEngine.models.requests.YsUserService.YsRequest;
import apiEngine.models.response.Token;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.io.IOException;

public class OauthCoreClient extends ApiClient {
    String baseUrl;

    public OauthCoreClient(String baseUrl) {
        super(baseUrl);
        this.baseUrl = baseUrl;
    }

    private String client_id = "E369A71D-2D0F-4D9F-B6C5-932081BD66CB";
    private String grant_type = "client_credentials";
    public static RequestSpecification tokenRequest;
    public static RequestSpecification registerRequestSpec;

    private Response getAnonymousAccessTokenResponse() {
        Response response = tokenRequest.
                queryParam("client_id", client_id)
                .queryParam("grant_type", grant_type).post(Route.generateAccessToken());

        if (response.getStatusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response.toString() +
                    " , Status Code : " + response.statusCode());
        }
        return response;
    }

    private Response getLoginUserTokenResponse(AuthorizationRequest authRequest, String anonymousAccessToken) {
        Response loginTokenResponse =
                tokenRequest.header("Authorization", "Bearer " + anonymousAccessToken).body(authRequest)
                        .post(Route.getLoginToken());

        if (loginTokenResponse.statusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("Login Authentication Failed. Content of failed Response: " + loginTokenResponse.toString() +
                    " , Status Code : " + loginTokenResponse.statusCode());
        }
        return loginTokenResponse;
    }


    public void authenticateUser(AuthorizationRequest authRequest, boolean isLogged) {
        tokenRequest = RestAssured.given();
        tokenRequest.baseUri(baseUrl);
        tokenRequest.header("Content-Type", "application/json");
        tokenRequest.header("YS-Culture", "tr-TR");

        Token tokenResponse;
        Response response = getAnonymousAccessTokenResponse();
        String accessToken = JsonUtil.getJsonElement(response, "access_token");

        if (isLogged) {
            Response loginTokenResponse = getLoginUserTokenResponse(authRequest, accessToken);
            tokenResponse = loginTokenResponse.body().jsonPath().getObject("$", Token.class);
        } else {
            tokenResponse = response.body().jsonPath().getObject("$", Token.class);
        }
        setTokenCurrentInstance(tokenResponse.access_token);
    }

    private void setTokenCurrentInstance(String token) {
        TokenHelper.getInstance().setToken(token);
    }

    public void registerNewUser(String email, String password) throws IOException {
        tokenRequest = RestAssured.given();
        tokenRequest.baseUri(baseUrl);
        tokenRequest.header("Content-Type", "application/json");
        tokenRequest.header("YS-Culture", "tr-TR");
        String token = JsonUtil.getJsonElement(getAnonymousAccessTokenResponse(), "refresh_token");

        YsRequest ysRequest = new YsRequest("0",
                "0",
                "E369A71D-2D0F-4D9F-B6C5-932081BD66CB",
                "postakip",
                token);
        UserData userData = new UserData(
                "E369A71D-2D0F-4D9F-B6C5-932081BD66CB",
                "4fdf4148-db99-4d17-a73d-8eab51b7f750",
                email,
                "true",
                "YsCarsi",
                "ApiTest",
                password,
                "test11",
                "true");

        RegisterRequest registerRequest = new RegisterRequest(userData,ysRequest);
        registerRequestSpec = RestAssured.given();
        registerRequestSpec.header("Content-Type", "application/json");
        registerRequestSpec.header("YS-Culture", "tr-TR");
       Response registerResponse = registerRequestSpec.baseUri(Utils.getGlobalValue("ysWebServiceBase"))
                .body(registerRequest)
                .post("/CreateUser");
        registerResponse.getBody();
    }


}
