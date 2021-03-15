package apiEngine;

import cucumber.CustomLogFilter;
import cucumber.Storage;
import io.cucumber.java.AfterStep;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.Hooks;


public class ApiClient extends Hooks{
    public RequestSpecification request;
    public Filter logFilter;

    public ApiClient(String baseUrl) {
        logFilter = new CustomLogFilter();
        request = RestAssured.given().with().filter(logFilter);
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        request.header("YS-Culture", "tr-TR");
        String token = TokenHelper.getInstance().getToken();
        request.header("Authorization", "Bearer " + token);

    }

    public void writeStepLog(){
        if (logFilter instanceof CustomLogFilter) {
            CustomLogFilter customLogFilter = (CustomLogFilter) logFilter;
            Storage.getScenario().write("\n" + "API Request: " + customLogFilter.getRequestBuilder()
                    + "\n" + "API Response: " + customLogFilter.getResponseBuilder());
        }
    }
}