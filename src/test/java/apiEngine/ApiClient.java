package apiEngine;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class ApiClient {
    public static RequestSpecification request;

    public ApiClient(String baseUrl) {

        request = RestAssured.given().log().all();
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        request.header("YS-Culture", "tr-TR");
        String token = TokenHelper.getInstance().getToken();
        if (token != null) {
            request.header("Authorization", "Bearer " + token);
        }
    }
}