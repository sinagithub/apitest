package stepDefinitions;

import clients.carsi.CarsiClient;
import clients.OauthCoreClient;
import clients.YSClient;
import clients.carsi.CarsiHomePageClient;
import clients.carsi.CarsiUserClient;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseSteps {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private YSClient ysClient;
    private ScenarioContext scenarioContext;
    private CarsiUserClient carsiUserClient;
    private CarsiHomePageClient carsiHomePageClient;


    public BaseSteps(TestContext testContext) {
        oauthCoreClient = testContext.getOauthCoreClient();
        carsiClient = testContext.getCarsiClient();
        ysClient = testContext.getYsClient();
        scenarioContext = testContext.getScenarioContext();
        carsiUserClient = testContext.getCarsiUserClient();
        carsiHomePageClient = testContext.getCarsiHomePageClient();

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
        System.out.println(this.getClass().getResource("/").getPath());
        if (format.equals("JSON")) {
            response.then().assertThat().contentType(ContentType.JSON)
                    .and()
                    .body(matchesJsonSchemaInClasspath(path));

        }
    }

    public CarsiHomePageClient getCarsiHomePageClient() {
        return carsiHomePageClient;
    }
}