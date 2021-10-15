package apiEngine;

import apiEngine.Utilies.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import cucumber.CustomLogFilter;
import cucumber.StepDetails;
import cucumber.Storage;
import cucumber.TestRail.TestRailApi;
import cucumber.TestRail.TestRailLogHelper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.Hooks;
import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;

import java.util.UUID;

public class ApiClient extends Hooks {

    public RequestSpecification cdnRequest;
    public CustomLogFilter logFilter;
    private final String catalog;
    private final String token;
    private final String platformType;
    private final RestAssuredConfig config;
    private final String baseUrl;
    private final Double latitude;
    private final Double longitude;
    private final String sessionId;

    public RequestSpecification createRequest() {
        RequestSpecification request = RestAssured.given().log().all().request().config(config).with().filter(logFilter);
        request.baseUri(baseUrl);
        request.header("Content-Type", "application/json");
        request.header("YS-Culture", "tr-TR");
        if (PlatformTypeHelper.getInstance().getPlatformType() != null) {
            request.header("PlatformType", PlatformTypeHelper.getInstance().getPlatformType());
        }
        request.header("Authorization", "Bearer " + token);

        if (catalog != null) {
            request.header("YS-Catalog", catalog);
        }


        if (latitude != null) {
            request.header("X-Address-Lat", latitude);
        }

        if (longitude != null) {
            request.header("X-Address-Long", longitude);
        }

        if (sessionId != null) {
            request.header("X-Session-Id", sessionId);
        }

        return request;
    }

    public ApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        catalog = CatalogSelector.getInstance().getCatalogName();
        token = TokenHelper.getInstance().getToken();
        platformType = PlatformTypeHelper.getInstance().getPlatformType();
        latitude = LatLongHelper.getInstance().getLatitude();
        longitude = LatLongHelper.getInstance().getLongitude();
        sessionId = GuidHelper.getInstance().getGuid();
        config = RestConfig.createConfig();
        logFilter = new CustomLogFilter();
    }

    public void writeStepLog() {
        String code = "API Request: " + logFilter.getRequestBuilder() +
                "\n" + "API Response: " + logFilter.getResponseBuilder();
        Markup m = MarkupHelper.createCodeBlock(code, CodeLanguage.XML);
        Status status =   ExtentCucumberAdapter.getCurrentStep().getStatus();
        Storage.getScenario().log(code);
        ExtentCucumberAdapter.getCurrentStep().log(status,m);


        TestRailLogHelper.getInstance().setLog(DateUtil.generateDateNow() ,
                "\n" + "API Request: " + logFilter.getRequestBuilder() +
                        "\n" + "API Response: " + logFilter.getResponseBuilder());
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

    public Response getImageUrlResponse(String imageUrl) {
        RestAssuredConfig config = RestConfig.createConfig();
        cdnRequest = RestAssured.given().config(config);
        return cdnRequest.get(imageUrl);
    }

}