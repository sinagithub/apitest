package apiEngine;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import javax.xml.ws.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiClient {
    protected final RequestSpecification request;

    public ApiClient(String baseUrl) {
        request = RestAssured.given().log().all();
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
    }


}