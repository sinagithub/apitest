package stepDefinitions;

import apiEngine.ApiClient;
import cucumber.CustomLogFilter;
import cucumber.Storage;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.filter.Filter;

public class Hooks {
    @Before(order = 1)
    public void getScenario(Scenario scenario) {
        Storage.putScenario(scenario);
    }


}
