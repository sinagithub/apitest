package stepDefinitions;

import clients.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import clients.carsi.CarsiUserClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseSteps {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ScenarioContext scenarioContext;
    private CarsiUserClient carsiUserClient;


    public BaseSteps(TestContext testContext) {
        oauthCoreClient = testContext.getOauthCoreClient();
        carsiClient = testContext.getCarsiClient();
        ysClient = testContext.getYsClient();
        scenarioContext = testContext.getScenarioContext();
        carsiUserClient = testContext.getCarsiUserClient();

    }


    public CarsiClient getCarsiClient() {
        return carsiClient;
    }

    public YSClient getYsClient() {
        return ysClient;
    }

    public OauthCoreClient getOauthCoreClient() {
        return oauthCoreClient;
    }

    public CarsiUserClient getCarsiUserClient() {
        return carsiUserClient;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public void schemaValidator(String format, Response response, String path) {
        if (format.equals("JSON")) {
            response.then().assertThat().contentType(ContentType.JSON)
                    .and()
                    .body(matchesJsonSchemaInClasspath(path));

        }
    }


}