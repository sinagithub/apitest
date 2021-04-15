package apiEngine;

import cucumber.CustomLogFilter;
import cucumber.Storage;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.Hooks;



public class ApiClient extends Hooks {
    public RequestSpecification request;
    public CustomLogFilter logFilter;


    public ApiClient(String baseUrl) {
        String catalog = CatalogSelector.getInstance().getCatalogName();
        String token = TokenHelper.getInstance().getToken();
        RestAssuredConfig config = RestConfig.createConfig();
        logFilter = new CustomLogFilter();
        request = RestAssured.given().config(config).with().filter(logFilter).log().all();
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        request.header("YS-Culture", "tr-TR");

        request.header("Authorization", "Bearer " + token);
        if (catalog != null) {
            request.header("YS-Catalog", catalog);
        }

    }

    public void writeStepLog() {
        Storage.getScenario().write("\n" + "API Request: " + logFilter.getRequestBuilder()
                + "\n" + "API Response: " + logFilter.getResponseBuilder());
    }

    public void writeStepLog(boolean showResponse,boolean showRequest) {

        if (showRequest && showResponse){
            Storage.getScenario().write("\n" + "API Request: " + logFilter.getRequestBuilder()
                    + "\n" + "API Response: " + logFilter.getResponseBuilder());
        }
        else if (showRequest && !showResponse){
            Storage.getScenario().write("\n" + "API Request: " + logFilter.getRequestBuilder());
        }
        else if (showResponse && !showRequest){
            Storage.getScenario().write("API Response: " + logFilter.getResponseBuilder());
        }
    }

    public Response getImageUrlResponse(String bannerUrls) {
        writeStepLog(false,true);
        return request.get(bannerUrls);
    }

}