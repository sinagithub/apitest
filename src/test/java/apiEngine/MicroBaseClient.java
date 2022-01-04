package apiEngine;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
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
        String code = "API Request: " + logFilter.getRequestBuilder() +
                "\n" + "API Response: " + logFilter.getResponseBuilder();
        Storage.getScenario().attach(logFilter.getRequestBuilder(),"text","req");

        Markup m = MarkupHelper.createCodeBlock(code, CodeLanguage.XML);

        try {
            Status status =   ExtentCucumberAdapter.getCurrentStep().getStatus();
            Storage.getScenario().log(code);
            ExtentCucumberAdapter.getCurrentStep().log(status,m);

        } catch (Exception e) {

        }
    }



}