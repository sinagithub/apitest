package apiEngine;
import apiEngine.models.requests.AuthorizationRequest;
import apiEngine.models.response.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiClient {
    public static RequestSpecification request;
    protected static String token;
    private String client_id = "E369A71D-2D0F-4D9F-B6C5-932081BD66CB";
    private String grant_type = "client_credentials";

    public ApiClient(String baseUrl) {
        request = RestAssured.given().log().all();
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        request.header("YS-Culture","tr-TR");
        if (TokenHelper.getToken() != null){
            request.header("Authorization", "Bearer " + TokenHelper.getToken());
        }
    }
}