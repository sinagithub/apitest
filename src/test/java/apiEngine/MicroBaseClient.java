package apiEngine;

import cucumber.CustomLogFilter;
import cucumber.Storage;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.Hooks;


public class MicroBaseClient extends Hooks {


    public CustomLogFilter logFilter;
    private final RestAssuredConfig config;
    private final String baseUrl;


    public RequestSpecification createRequest() {
        RequestSpecification request = RestAssured.given().log().all().config(config).with().filter(logFilter);
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        return request;
    }

    public MicroBaseClient(String baseUrl) {
        this.baseUrl = baseUrl;
        config = RestConfig.createConfig();
        logFilter = new CustomLogFilter();
    }

    public void writeStepLog() {
        Storage.getScenario().log("\n" + "API Request: " + logFilter.getRequestBuilder()
                + "\n" + "API Response: " + logFilter.getResponseBuilder());
    }

    public void writeStepLog(boolean showResponse, boolean showRequest) {

        if (showRequest && showResponse) {
            Storage.getScenario().log("\n" + "API Request: " + logFilter.getRequestBuilder()
                    + "\n" + "API Response: " + logFilter.getResponseBuilder());
        } else if (showRequest) {
            Storage.getScenario().log("\n" + "API Request: " + logFilter.getRequestBuilder());
        } else if (showResponse) {
            Storage.getScenario().log("API Response: " + logFilter.getResponseBuilder());
        }
    }


}