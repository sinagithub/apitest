package stepDefinitions;

import clients.carsi.*;
import clients.OauthCoreClient;
import clients.YSClient;
import cucumber.ScenarioContext;
import cucumber.Storage;
import cucumber.TestContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseSteps {

    private OauthCoreClient oauthCoreClient;
    private CarsiClient carsiClient;
    private CarsiSplashClient carsiSplashClient;
    private ScenarioContext scenarioContext;
    private CarsiUserClient carsiUserClient;
    private CarsiHomePageClient carsiHomePageClient;
    private CarsiProductClient carsiProductClient;
    private CarsiBasketClient carsiBasketClient;
    private CarsiVendorClient carsiVendorClient;


    public BaseSteps(TestContext testContext) {
        oauthCoreClient = testContext.getOauthCoreClient();
        carsiClient = testContext.getCarsiClient();
        scenarioContext = testContext.getScenarioContext();
        carsiUserClient = testContext.getCarsiUserClient();
        carsiHomePageClient = testContext.getCarsiHomePageClient();
        carsiProductClient = testContext.getCarsiProductClient();
        carsiSplashClient = testContext.getCarsiSplashClient();
        carsiBasketClient = testContext.getCarsiBasketClient();
        carsiVendorClient = testContext.getCarsiVendorClient();
    }


    public CarsiClient getCarsiClient() {
        return carsiClient;
    }

    public CarsiVendorClient getCarsiVendorClient() {
        return carsiVendorClient;
    }

    public OauthCoreClient getOauthCoreClient() {
        return oauthCoreClient;
    }

    public CarsiUserClient getCarsiUserClient() {
        return carsiUserClient;
    }

    public CarsiSplashClient getCarsiSplashClient() {
        return carsiSplashClient;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public CarsiBasketClient getCarsiBasketClient(){
        return carsiBasketClient;
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

    public CarsiProductClient getCarsiProductClient() {
        return carsiProductClient;
    }

    public void assertNotEmpty(String property) {
        Assert.assertFalse(property.isEmpty());
    }

    public void assertNotEmpty(int property) {
        Assert.assertNotNull(property);
    }

    public void assertFalse(Boolean property) {
        Assert.assertFalse(property);
    }

    public void assertTrue(Boolean property, String message) {
        Assert.assertTrue(message,property);
    }


}