package stepDefinitions;

import apiEngine.PlatformTypeHelper;
import clients.OauthCoreClient;
import clients.carsi.*;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
    private CarsiFavoriteClient carsiFavoriteClient;
    private CarsiContentClient carsiContentClient;


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
        carsiFavoriteClient = testContext.getCarsiFavoriteClient();
        carsiContentClient = testContext.getCarsiContentClient();
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

    public CarsiBasketClient getCarsiBasketClient() {
        return carsiBasketClient;
    }

    public CarsiContentClient getCarsiContentClient() {
        return carsiContentClient;
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

    public CarsiFavoriteClient getCarsiFavoriteClient() {
        return carsiFavoriteClient;
    }

    public void assertNotNull(String property) {
        Assert.assertFalse(property.isEmpty());
    }

    public void assertNotNull(Double property) {
        Assert.assertFalse(property.isNaN());
    }

    public void assertNotNull(String property , String message) {
        assertThat(message, property, is(notNullValue()));
    }

    public void assertNotNull(int property, String message) {
        assertThat(message, property, is(notNullValue()));
    }

    public void assertFalse(Boolean property) {
        Assert.assertFalse(property);
    }

    public void assertTrue(Boolean property, String message) {
        Assert.assertTrue(message, property);
    }

    public void setCurrentPlatformType(String platformType) {
        PlatformTypeHelper.getInstance().setPlatformType(platformType);
    }

    public void assertEqual(String reason, String actual, String expected) {
        assertThat(reason, actual, equalToIgnoringCase(expected));
    }


}